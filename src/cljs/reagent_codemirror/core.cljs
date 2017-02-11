;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-codemirror.core
  (:require [reagent.core :as reagent]
            [camel-snake-kebab.core :as csk]
            [camel-snake-kebab.extras :as csk-extras]
            cljsjs.codemirror
            cljsjs.codemirror.mode.clojure
            cljsjs.codemirror.addon.selection.active-line))

(def event-names
  "Taken from: https://codemirror.net/doc/manual.html#events"
  [:on-change :on-changes :on-before-change :on-cursor-activity :on-key-handled :on-input-read :on-electric-input
   :before-selection-change :viewport-change :swap-doc :gutter-click :gutter-context-menu :focus :blur :scroll :refresh
   :option-change :scroll-cursor-into-view :update :render-line :mousedown :dblclick :touchstart :contextmenu :keydown
   :keypress :keyup :cut :copy :paste :dragstart :dragenter :dragover :dragleave :drop :change :before-change
   :cursor-activity :before-selection-change :delete :change :before-cursor-enter :clear :hide :unhide :redraw])

(defn- ->js-event-name [event-name]
  "Converts an event name, such as :on-input-read into a JavaScript/Codemirror event name, such as inputRead."
  (csk/->camelCase (subs (name event-name) 3)))

(defn codemirror [options]
  (let [codemirror-object (atom nil)]
    (reagent/create-class
      {:component-did-mount          (fn [this]
                                       (let [html-element (reagent/dom-node this)
                                             js-options (clj->js (or (csk-extras/transform-keys csk/->camelCase options) {}))]
                                         (reset! codemirror-object (.fromTextArea js/CodeMirror html-element js-options))
                                         (doseq [[event-name event-fn] (select-keys options event-names)]
                                           (let [js-event-name (->js-event-name event-name)]
                                             (.on @codemirror-object js-event-name event-fn)))))
       ;; TODO: component will unmount
       :component-will-receive-props (fn [this [_ new-props]]
                                       (when (and new-props
                                                  (:value new-props)
                                                  @codemirror-object
                                                  (not= (:value new-props)
                                                        (.getValue @codemirror-object)))
                                         (.setValue @codemirror-object (:value new-props))))
       :reagent-render               (fn [options]
                                       [:textarea {:auto-complete false
                                                   :default-value (:value options)}])})))
