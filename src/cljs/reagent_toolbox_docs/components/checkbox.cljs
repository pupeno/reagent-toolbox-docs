;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.checkbox
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))

(defn view []
  (fn []
    [:article
     [:h1 "Checkbox"]
     [:p
      [:a {:href "https://material.google.com/components/selection-controls.html#selection-controls-checkbox"} "Checkboxes"]
      " allow the user to select multiple options from a set. If you have multiple options appearing in a list, you can "
      "preserve space by using checkboxes instead of on/off switches. If you have a single option, avoid using a checkbox "
      "and use an on/off switch instead."]

     [ui/display-and-eval-code "
(defn checkbox-test []
  (let [checkboxes (reagent.ratom/atom {:box1 true :box2 false})]
    (fn []
      [:div
       [reagent-toolbox.core/checkbox {:checked   (@checkboxes :box1)
                                       :label     (if (@checkboxes :box1) \"Checked\" \"Unchecked\")
                                       :on-change #(swap! checkboxes update :box1 not)}]
       [reagent-toolbox.core/checkbox {:checked   (@checkboxes :box2)
                                       :label     (if (@checkboxes :box2) \"Checked\" \"Unchecked\")
                                       :on-change #(swap! checkboxes update :box2 not)}]
       [reagent-toolbox.core/checkbox {:disabled true
                                       :label    \"Disabled checkbox\"}]])))

[checkbox-test]"]

     [:p "If you want to provide a theme via context, the component key " [:code "RTCheckbox"] "."]

     [:section
      [:h2 "Properties"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "checked"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Value for the checkbox, can be true or false."]]
        [:tr
         [:td [:code "children"]]
         [:td [:code "string, element, or array"]]
         [:td]
         [:td "Children to pass through the component."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a class to give customized styles to the checkbox field."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the checkbox shown as disabled and cannot be modified."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "Text label to attach next to the checkbox element."]]
        [:tr
         [:td [:code "name"]]
         [:td [:code "string"]]
         [:td [:code "false"]]
         [:td "The name of the field to set in the input checkbox."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the checkbox is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the checkbox value is changed."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the checkbox is focused."]]]]]

     [:section
      [:h2 "Theme"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "check"]]
         [:td "Used as root in the check element."]]
        [:tr
         [:td [:code "checked"]]
         [:td "Used for the check element when it's checked"]]
        [:tr
         [:td [:code "disabled"]]
         [:td "Used when the component is disabled."]]
        [:tr
         [:td [:code "field"]]
         [:td "Used as the root class of the component."]]
        [:tr
         [:td [:code "input"]]
         [:td "Used for the input element."]]
        [:tr
         [:td [:code "ripple"]]
         [:td "Used for the ripple component."]]
        [:tr
         [:td [:code "text"]]
         [:td "Used for the text label."]]]]]]))

(defmethod layout/pages :checkbox [_]
  [view])
