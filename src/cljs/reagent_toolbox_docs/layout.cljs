;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.layout
  (:require [cljs.pprint :as pp]
            [reagent.core :as reagent]
            [reagent.ratom :as ratom :include-macros true]
            [re-frame.core :as re-frame]
            [reagent-toolbox.core :as rt]
            [reagent-toolbox-docs.routing :as routing]))

(defn ui-dispatch
  "Re-frame dispatch enhanced for UI. On top of re-frame-dispatching args, it:
  * stops the default handling from happening, so links and forms don't get submitted.
  * passes the target of the event (the form or link) as the last argument to the re-frame-dispatch."
  [js-event event]
  (.preventDefault js-event)
  (re-frame/dispatch event))

(defmulti pages :name)

(defmethod pages nil [_]                                    ; While the app is loading, the current-route is nil for an instant. Without this we would be showing :default, which is a page not found error.
  [:div [:h1 "Loading..."]])

(defmethod pages :default [_]
  [:div [:h1 "Page not found"]])

(defn main-panel []
  (let [current-route (re-frame/subscribe [:current-route])]
    (fn []
      [:div#whole-page-wrapper
       [rt/app-bar {:left-icon          "home"
                    :on-left-icon-click #(routing/redirect-to :home)
                    :title              "Reagent Toolbox"}]
       [:div#main-and-asides
        [:aside.menu
         [rt/list {:selectable true :ripple true}
          (map (fn [[legend name]]
                 ^{:key name}
                 [rt/list-item {:legend legend
                                :to     (routing/url-for name)}])
               [["App Bar" :app-bar]
                ["Autocomplete" :autocomplete]
                ["Avatar" :avatar]
                ["Button" :button]
                ["Checkbox" :checkbox]
                ["Font Icon" :font-icon]
                ["Input" :input]
                ["Link" :link]
                ["Navigation" :navigation]
                ["Progress Bar" :progress-bar]
                ["Time Picker" :time-picker]])]]
        [:main.content ^{:key @current-route} [pages @current-route]]]
       [:footer
        [:p "Sponsored by " [:a {:href "https://dashman.tech"} "Dashman"] ". Copyright © 2017 Flexpoint Tech."]]])))

(defmethod pages :home [_]
  (fn [_]
    [:article
     [:h1 "Reagent Toolbox"]]))
