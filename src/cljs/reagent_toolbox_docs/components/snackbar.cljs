;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.snackbar
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Snackbar"]

     [:p "Snackbars provide lightweight feedback about an operation by showing a brief "
      "message at the bottom of the screen. Snackbars can contain an action."]

     [ui/display-and-eval-code
      "(defn snackbar-test
         []
         (let [snackbar (reagent.ratom/atom {:active false})]
         (fn []
           [:section
            [reagent-toolbox.core/button {:label \"Show Snackbar\"
                                          :raised true
                                          :on-click #(swap! snackbar assoc :active true)}]
             [reagent-toolbox.core/snackbar {:action \"Nice\"
                                             :active (:active @snackbar)
                                             :label \"A new developer started using Reagent Toolbox\"
                                             :on-click #(swap! snackbar assoc :active false)
                                             :ref \"snackbar\"
                                             :type \"accept\"}]])))

       [snackbar-test]"]
     ]))

(defmethod layout/pages :snackbar [_]
  [view])
