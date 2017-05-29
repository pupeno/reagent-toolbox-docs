;;;; Copyright © 2017 Flexpoint Tech Ltd.

(ns reagent-toolbox-docs.components.snackbar
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "Snackbar"]
     [:p "Snackbars provide lightweight feedback about an operation by showing a brief message at the bottom of the "
      "screen. Snackbars can contain an action."]
     [ui/display-and-eval-code "
(defn snackbar-test []
  (let [state (reagent.ratom/atom false)]
    (fn []
      [:section
       [reagent-toolbox.core/button {:label    \"Show Snackbar\"
                                     :raised   true
                                     :primary  true
                                     :on-click #(reset! state true)}]
       [reagent-toolbox.core/snackbar {:action     \"Dismiss\"
                                       :active     @state
                                       :label      \"Snackbar action cancel\"
                                       :timeout    2000
                                       :on-click   #(reset! state false)
                                       :on-timeout #(reset! state false)
                                       :type       \"cancel\"}]])))

[snackbar-test]"]
     [:p "This component can be styled by context providing a theme with the key " [:code "RTSnackbar"] " through the "
      "theme provider."]
     [:section
      [:h2 "Properties"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "action"]]
         [:td [:code "String"]]
         [:td]
         [:td "Label for the action component inside the Snackbar."]]
        [:tr
         [:td [:code "active"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the snackbar will be active."]]
        [:tr
         [:td [:code "children"]]
         [:td [:code "String"] " or reagent component"]
         [:td [:code "false"]]
         [:td "Text or node to be displayed in the content as alternative to " [:code "label"] "."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Additional class name to provide custom styling."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "String"] " or reagent component"]
         [:td]
         [:td "Text to display in the content."]]
        [:tr
         [:td [:code "on-click"]]
         [:td [:code "Function"]]
         [:td]
         [:td "Callback function that will be called when the button action is clicked."]]
        [:tr
         [:td [:code "on-timeout"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function when finish the set timeout."]]
        [:tr
         [:td [:code "timeout"]]
         [:td [:code "number"]]
         [:td]
         [:td "Amount of time in milliseconds after the Snackbar will be automatically hidden."]]
        [:tr
         [:td [:code "type"]]
         [:td [:code "string"]]
         [:td]
         [:td "Indicates the action type. Can be " [:code "accept"] ", " [:code "warning"] " or "
          [:code "cancel"]]]]]]
     [:section
      [:h2 "Theme"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "accept"]]
         [:td "Added to the root element in case it's accept type."]]
        [:tr
         [:td [:code "active"]]
         [:td "Added to the root element when its active."]]
        [:tr
         [:td [:code "button"]]
         [:td "Used for the button inside the component."]]
        [:tr
         [:td [:code "cancel"]]
         [:td "Added to the root element in case it's cancel type."]]
        [:tr
         [:td [:code "label"]]
         [:td "Used for the label element."]]
        [:tr
         [:td [:code "snackbar"]]
         [:td "Used as the className for the root element of the component."]]
        [:tr
         [:td [:code "warning"]]
         [:td "Added to the root element in case it's warning type."]]]]]]))

(defmethod layout/pages :snackbar [_]
  [view])
