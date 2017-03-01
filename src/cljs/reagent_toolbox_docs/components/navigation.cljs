;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.navigation
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Navigation"]
     [:p "This component is intended to be a common wrapper for a group of links or buttons. "
      "It sets a minimal layout, semantic markup and spacing for each of those elements."]

     [ui/display-and-eval-code
      "(defn navigation-test
         []
         (let [actions [{:label \"Alarm\" :raised true :icon \"access_alarm\"}
                        {:label \"Location\" :raised true :accent true :icon \"room\"}]]
           (fn []
             [:div
              [reagent-toolbox.core/navigation {:type \"horizontal\" :actions actions}]
])))
       [navigation-test]"]
     ]))

(defmethod layout/pages :checkbox [_]
  [view])
