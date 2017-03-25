;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.radio-buttons
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Radio Buttons"]

     [:p
      [:a {:href "https://material.google.com/components/selection-controls.html#selection-controls-radio-button"} "Radio buttons"]
      " allow the user to select one option from a set. Use radio buttons for exclusive "
      "selection if you think that the user needs to see all available options side-by-side. "
      "Otherwise, consider a dropdown, which uses less space than displaying all options. They "
      "should always be used along with RadioGroup."]

     [:p "You can provide the theme for this component using the key ToolboxButton."]

     [ui/display-and-eval-code "
(defn radio-buttons-test []
  (let [radio-value (reagent.ratom/atom {:value \"vvendetta\"})
        target-value (fn [t] (.. t -target -value))
        select (fn [sel] (swap! radio-value assoc :value (target-value sel)))]
    (fn []
      [:div
       [:p \"Value: \" @radio-value]
       [reagent-toolbox.core/radio-group {:name  \"comic\"
                                          :value (:value @radio-value)}
        [reagent-toolbox.core/radio-button {:label     \"The Walking Dead\"
                                            :value     \"thewalkingdead\"
                                            :checked   (when (= (:value @radio-value) \"thewalkingdead\") true)
                                            :on-change #(select %)}]
        [reagent-toolbox.core/radio-button {:label    \"From Hell\"
                                            :value    \"fromhell\"
                                            :disabled true}]
        [reagent-toolbox.core/radio-button {:label     \"V for Vendetta\"
                                            :value     \"vvendetta\"
                                            :checked   (when (= (:value @radio-value) \"vvendetta\") true)
                                            :on-change #(select %)}]
        [reagent-toolbox.core/radio-button {:label     \"Watchmen\"
                                            :value     \"watchmen\"
                                            :checked   (when (= (:value @radio-value) \"watchmen\") true)
                                            :on-change #(select %)}]]])))

[radio-buttons-test]"]

     [:section
      [:h1 "Radio Group"]

      [:p "A radio selector is mean to get a value from a set of choices, that 's why a radio "
       "group is needed. It can take some properties and actions that will be transferred to "
       "the children, but they also can behave independently."]]

     [:section
      [:h2 "Properties"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th "Description"]]]
       [:tr
        [:td [:code "class-name"]]
        [:td [:code "string"]]
        [:td [:code "\"\""]]
        [:td "Set a class to give custom styles to the group."]]
       [:tr
        [:td [:code "disabled"]]
        [:td [:code "boolean"]]
        [:td [:code "false"]]
        [:td "If true, the group will be displayed as disabled."]]
       [:tr
        [:td [:code "name"]]
        [:td [:code "string"]]
        [:td]
        [:td "Name for the input element group."]]
       [:tr
        [:td [:code "on-change"]]
        [:td [:code "function"]]
        [:td]
        [:td "Callback function that will be invoked when the value changes."]]
       [:tr
        [:td [:code "value"]]
        [:td [:code "any"]]
        [:td]
        [:td "Default value selected in the radio group."]]]]

     [:section
      [:h1 "Radio Button"]

      [:p "The inner component to compose radio selectors. They will be rendered as radio input "
       "elements of HTML transferring the given properties that concerns to them."]]

     [:section
      [:h2 "Properties"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th "Description"]]]
       [:tr
        [:td [:code "checked"]]
        [:td [:code "boolean"]]
        [:td [:code "false"]]
        [:td "If true, the input element will be selected by default. Transferred from the "
         "parent."]]
       [:tr
        [:td [:code "class-name"]]
        [:td [:code "string"]]
        [:td [:code "\"\""]]
        [:td "Set a class to give custom styles to the radio button."]]
       [:tr
        [:td [:code "disabled"]]
        [:td [:code "boolean"]]
        [:td [:code "false"]]
        [:td "If true, the item will be displayed as disabled."]]
       [:tr
        [:td [:code "label"]]
        [:td [:code "string"] "or reagent component"]
        [:td [:code "\"\""]]
        [:td "Label for the radio button."]]
       [:tr
        [:td [:code "name"]]
        [:td [:code "string"]]
        [:td]
        [:td "Name for the input element."]]
       [:tr
        [:td [:code "on-blur"]]
        [:td [:code "function"]]
        [:td]
        [:td "Callback function that will be invoked when the input is blurred."]]
       [:tr
        [:td [:code "on-change"]]
        [:td [:code "function"]]
        [:td]
        [:td "Callback function that will be invoked when the value changes."]]
       [:tr
        [:td [:code "on-focus"]]
        [:td [:code "function"]]
        [:td]
        [:td "Callback function that will be invoked when the input is focused."]]
       [:tr
        [:td [:code "value"]]
        [:td [:code "any"]]
        [:td]
        [:td "Value for the radio button."]]]]

     [:section
      [:h2 "Theming"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tr
        [:td [:code "disabled"]]
        [:td "Added to the root of the Radio in case it's disabled."]]
       [:tr
        [:td [:code "field"]]
        [:td "Used as the root class of the component."]]
       [:tr
        [:td [:code "input"]]
        [:td "Used for the input element."]]
       [:tr
        [:td [:code "radio"]]
        [:td "Used to for the radio element."]]
       [:tr
        [:td [:code "radio-checked"]]
        [:td "Used for the radio element when it's checked."]]
       [:tr
        [:td [:code "ripple"]]
        [:td "To provide styles for the ripple."]]
       [:tr
        [:td [:code "text"]]
        [:td "Used to style the text label element."]]]]]))

(defmethod layout/pages :radio-buttons [_]
  [view])
