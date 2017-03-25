;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.dropdown
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "Dropdown"]
     [:p "The Dropdown selects an option between multiple selections. The element displays the current state and a "
      "down arrow. When it is clicked, it displays the list of available options."]
     [ui/display-and-eval-code "
(defn dropdown-test []
  (let [countries [{:value nil :label \"None\"}
                   {:value :en :label \"English\"}
                   {:value :es :label \"Spainish\"}
                   {:value :eo :label \"Esperanto\"}
                   {:value \"many\" :label \"Many languages\"}]
        state (reagent.ratom/atom :es)]
    (fn []
      [:div
       [:p \"Value: \" (pr-str @state)]
       [reagent-toolbox.core/dropdown {:auto      true
                                       :on-change #(reset! state %)
                                       :source    countries
                                       :value     @state}]])))

[dropdown-test]"]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTDropdown"] "."]
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
         [:td [:code "allow-blank"]]
         [:td [:code "boolean"]]
         [:td [:code "true"]]
         [:td "If false the dropdown will preselect the first item if the supplied value "
          "matches none of the options' values."]]
        [:tr
         [:td [:code "auto"]]
         [:td [:code "boolean"]]
         [:td [:code "true"]]
         [:td "If true, the dropdown will open up or down depending on the position in the "
          "screen."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Set the class to give custom styles to the dropdown."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Set the component as disabled."]]
        [:tr
         [:td [:code "error"]]
         [:td [:code "string"]]
         [:td]
         [:td "Give an error string to display under the field."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string to use for the floating label element."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the component is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the component's value changes."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the component is focused."]]
        [:tr
         [:td [:code "source"]]
         [:td [:code "vector"]]
         [:td]
         [:td "Vector of data objects with the data to represent in the dropdown."]]
        [:tr
         [:td [:code "template"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that returns a JSX template to represent the element."]]
        [:tr
         [:td [:code "value"]]
         [:td [:code "string"]]
         [:td]
         [:td "Default value using JSON data."]]
        [:tr
         [:td [:code "required"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the dropdown has a required attribute."]]]]
      [:section
       [:h2 "Theme"]
       [:p "This component uses an Input under the covers. The theme object is passed down namespaced under input "
        "keyword. This means you can use the same theme classNames from Input component but namespaced with input. For "
        "example, to style the label you "
        "have to use inputLabel className."]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "active"]]
          [:td "Added to the root element when the dropdown is active."]]
         [:tr
          [:td [:code "disabled"]]
          [:td "Added to the root element when it's disabled."]]
         [:tr
          [:td [:code "dropdown"]]
          [:td "Root element class."]]
         [:tr
          [:td [:code "error"]]
          [:td "Used for the error element."]]
         [:tr
          [:td [:code "errored"]]
          [:td "Added to the inner wrapper if it's errored."]]
         [:tr
          [:td [:code "field"]]
          [:td "Used for the inner wrapper of the component."]]
         [:tr
          [:td [:code "label"]]
          [:td "Used for the the label element."]]
         [:tr
          [:td [:code "selected"]]
          [:td "Used to highlight the selected value."]]
         [:tr
          [:td [:code "template-value"]]
          [:td "Used as a wrapper for the given template value."]]
         [:tr
          [:td [:code "up"]]
          [:td "Added to the root element when it's opening up."]]
         [:tr
          [:td [:code "value"]]
          [:td "Used for each value in the dropdown component."]]
         [:tr
          [:td [:code "values"]]
          [:td "Used for the list of values."]]]]]]]))

(defmethod layout/pages :dropdown [_]
  [view])
