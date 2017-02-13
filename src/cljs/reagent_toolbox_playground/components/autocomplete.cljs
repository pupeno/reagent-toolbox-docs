;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.components.autocomplete
  (:require [reagent-toolbox-playground.ui :as ui]
            [reagent-toolbox-playground.layout :as layout])
  (:import goog.net.XhrIo))

(defn view []
  (fn []
    [:article
     [:h1 "Autocomplete"]
     [:p "An input field with a set of predeterminated labeled values. When it's focused it shows a list of options that are filtered by label as the user types. They can be simple or multiple depending on the amount of values that can be selected. The opening direction is determined by its current position at opening time."]
     [:code
      #_[ui/display-and-eval-code "[autocomplete-test]"]
      [ui/display-and-eval-code "
(defn autocomplete-test []
  (let [single-value (reagent.ratom/atom \"\")
        multi-value (reagent.ratom/atom [])]
   (fn []
     (let [countries [\"Spain\", \"United Kingdom\", \"USA\", \"Thailand\", \"Tongo\", \"Slovenia\"]
           languages {:es \"Spanish\" :en \"English\" :fr \"French\" :de \"German\"}]
       [:div
         [:p \"Value: \" (pr-str @single-value)]
         [reagent-toolbox.core/autocomplete {:source    countries
                                             :value     @single-value
                                             :multiple  false
                                             :label     \"Choose a country\"
                                             :hint      \"You can only choose one...\"
                                             :on-change #(reset! single-value %)}]

         [:p \"Value: \" (pr-str @multi-value)]
         [reagent-toolbox.core/autocomplete {:source    languages
                                             :value     @multi-value
                                             :multiple  true
                                             :label     \"Choose languages\"
                                             :hint      \"You can many...\"
                                             :on-change #(reset! multi-value %)}]]))))

[autocomplete-test]"]]
     [:p "If you want to provide a theme via context, the component key is RTAutocomplete."]
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
         [:td [:code "allow-create"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Determines if user can create a new option with the current typed value"]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a class to style of the Component."]]
        [:tr
         [:td [:code "direction"]]
         [:td [:code "string"]]
         [:td [:code "auto"]]
         [:td "Determines the opening direction. It can be " [:code "auto"] ", " [:code "top"] " or " [:code "down"]
          "."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, component will be disabled."]]
        [:tr
         [:td [:code "error"]]
         [:td [:code "string"] " or " "Reagent component"]
         [:td]
         [:td "Sets the error string for the internal input element."]]
        [:tr
         [:td [:code "keep-focus-on-change"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Whether component should keep focus after value change."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"] " or " "Reagent component"]
         [:td]
         [:td "The text string to use for the floating label element."]]
        [:tr
         [:td [:code "multiple"]]
         [:td [:code "boolean"]]
         [:td [:code "true"]]
         [:td "If true, component can hold multiple values."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when component is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the components's value changes."]]
        [:tr
         [:td [:code "on-query-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the components's query input value changes."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when component is focused."]]
        [:tr
         [:td [:code "source"]]
         [:td [:code "map"] " or " [:code "vector"]]
         [:td]
         [:td "Object of key/values or array representing all items suggested."]]
        [:tr
         [:td [:code "selected-position"]]
         [:td [:code "string"]]
         [:td [:code "above"]]
         [:td "Determines if the selected list is shown above or below input. It can be "
          [:code "above"] ", "
          [:code "below"] " or "
          [:code "none"] "."]]
        [:tr
         [:td [:code "show-selected-when-not-in-source"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Determines if the selected list is shown if the "
          [:code "value"] " keys don't exist in the source. Only works if passing the "
          [:code "value"] " prop as an Object."]]
        [:tr
         [:td [:code "show-suggestions-when-value-is-set"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the list of suggestions will not be filtered when a value is selected, until the query is"
          "modified."]]
        [:tr
         [:td [:code "suggestion-match"]]
         [:td [:code "string"]]
         [:td [:code "start"]]
         [:td "Determines how suggestions are supplied. It can be "
          [:code "start"] " (query matches the start of a suggestion), "
          [:code "anywhere"] " (query matches anywhere inside the suggestion), or "
          [:code "word"] " (query matches the start of a word in the suggestion)."]]
        [:tr
         [:td [:code "value"]]
         [:td [:code "string"] ", " [:code "vector"] " or " [:code "map"]]
         [:td]
         [:td "Value or array of values currently selected component."]]]]
      [:p "Additional properties will be passed to the Input Component so you can use " [:code "hint"] ", "
       [:code "name"] " ... etc."]]
     [:section
      [:h2 "Theme"]
      [:p "This component uses an " [:code "Input"] " under the covers. The theme object is passed down namespaced "
       " under " [:code "input"] " keyword. This means you can use the same theme classNames from " [:code "Input"]
       " component but namespaced with " [:code "input"] ". For example, to style the label you have to use "
       [:code "inputLabel"] " className."]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "active"]]
         [:td "Used for a suggestion when it's active."]]
        [:tr
         [:td [:code "autocomplete"]]
         [:td "Used for the root element."]]
        [:tr
         [:td [:code "focus"]]
         [:td "Used when the input is focused."]]
        [:tr
         [:td [:code "input"]]
         [:td "Used to style the "
          [:code "Input"] " component."]]
        [:tr
         [:td [:code "suggestion"]]
         [:td "Used to style each suggestion."]]
        [:tr
         [:td [:code "suggestions"]]
         [:td "Used to style the suggestions container."]]
        [:tr
         [:td [:code "up"]]
         [:td "Used for the suggestions when it's opening to the top."]]
        [:tr
         [:td [:code "value"]]
         [:td "Classname used for a single value."]]
        [:tr
         [:td [:code "values"]]
         [:td "Classname used for the values container."]]]]]]))

(defmethod layout/pages :autocomplete [_]
  [view])
