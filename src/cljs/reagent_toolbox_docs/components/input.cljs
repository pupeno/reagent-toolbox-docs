;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.input
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))

(defn view []
  (fn []
    [:article
     [:h1 "Input"]
     [:p "Although we are calling them Inputs they actually correspond to Material Design "
      [:a {:href "https://material.io/guidelines/components/text-fields.html"} "Text fields"] ". It allows a user to "
      "input text and it's the base for other components like the autocomplete."]
     [ui/display-and-eval-code "
(defn input-test []
  (let [name (reagent.ratom/atom \"\")
        label (reagent.ratom/atom \"\")
        multiline (reagent.ratom/atom \"\")
        email (reagent.ratom/atom \"\")
        phone (reagent.ratom/atom \"\")
        hint (reagent.ratom/atom \"\")
        error (reagent.ratom/atom \"\")]
    (fn []
      [:div
       [:p \"Value: \" (pr-str @name)]
       [reagent-toolbox.core/input {:label      \"Name\"
                                    :name       \"name\"
                                    :type       \"text\"
                                    :value      @name
                                    :max-length 16
                                    :on-change  (fn [value event] (reset! name value))}]

       [:p \"Value: \" (pr-str @label)]
       [reagent-toolbox.core/input {:hint       \"With Hint, no label\"
                                    :name       \"name\"
                                    :type       \"text\"
                                    :value      @label
                                    :max-length 16
                                    :on-change  (fn [value event] (reset! label value))}]

       [:p \"Value: \" [:i \"none\"]]
       [reagent-toolbox.core/input {:label    \"Disabled field\"
                                    :disabled true}]

       [:p \"Value: \" (pr-str @multiline)]
       [reagent-toolbox.core/input {:label      \"Multiline\"
                                    :type       \"text\"
                                    :value      @multiline
                                    :multiline  true
                                    :max-length 20
                                    :on-change  (fn [value event] (reset! multiline value))}]

       [:p \"Value: \" (pr-str @email)]
       [reagent-toolbox.core/input {:label     \"Email address\"
                                    :type      \"email\"
                                    :value     @email
                                    :icon      \"email\"
                                    :on-change (fn [value event] (reset! email value))}]

       [:p \"Value: \" (pr-str @phone)]
       [reagent-toolbox.core/input {:label     \"Phone\"
                                    :type      \"tel\"
                                    :value     @phone
                                    :icon      \"phone\"
                                    :on-change (fn [value event] (reset! phone value))}]

       [:p \"Value: \" (pr-str @hint)]
       [reagent-toolbox.core/input {:label     \"Required Field\"
                                    :hint      \"With Hint\"
                                    :type      \"text\"
                                    :required  true
                                    :icon      \"share\"
                                    :value     @hint
                                    :on-change (fn [value event] (reset! hint value))}]

       [:p \"Value: \" (pr-str @error)]
       [reagent-toolbox.core/input {:label     \"Error\"
                                    :hint      \"With Hint\"
                                    :type      \"text\"
                                    :value     @error
                                    :on-change (fn [value event] (reset! error value))
                                    :error     [:span \"Error!! \" [:a {:href     \"#!\"
                                                                      :on-click (fn [e]
                                                                                  (.preventDefault e)
                                                                                  (println \"Some help\"))}
                                                                  \"?\"]]}]])))

[input-test]"]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTInput"] "."]
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
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a class name to give custom styles."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, component will be disabled."]]
        [:tr
         [:td [:code "error"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "Give an error node to display under the field."]]
        [:tr
         [:td [:code "floating"]]
         [:td [:code "boolean"]]
         [:td [:code "true"]]
         [:td "Indicates if the label is floating in the input field or not."]]
        [:tr
         [:td [:code "hint"]]
         [:td [:code "string"] " or reagent component"]
         [:td [:code "\"\""]]
         [:td "The text string to use for hint text element."]]
        [:tr
         [:td [:code "icon"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "Name of an icon to use as a label for the input."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "The text string to use for the floating label element."]]
        [:tr
         [:td [:code "max-length"]]
         [:td [:code "number"]]
         [:td]
         [:td "Specifies the maximum number of characters allowed in the component."]]
        [:tr
         [:td [:code "multiline"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, a textarea element will be rendered. The textarea also grows and shrinks according to the "
          "number of lines."]]
        [:tr
         [:td [:code "rows"]]
         [:td [:code "number"]]
         [:td]
         [:td "The number of rows the multiline input field has."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when component is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the component\"s value changes."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when component is focused."]]
        [:tr
         [:td [:code "on-key-press"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when a key is pressed."]]
        [:tr
         [:td [:code "required"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the html input has a required attribute."]]
        [:tr
         [:td [:code "type"]]
         [:td [:code "string"]]
         [:td [:code "text"]]
         [:td "Type of the input element. It can be a valid HTML5 input type"]]
        [:tr
         [:td [:code "value"]]
         [:td [:code "any"]]
         [:td]
         [:td "Current value of the input element."]]]]]
     [:section
      [:h2 "Theming"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "bar"]]
         [:td "Used for the bar under the input."]]
        [:tr
         [:td [:code "counter"]]
         [:td "Used for the counter element."]]
        [:tr
         [:td [:code "disabled"]]
         [:td "Added to the root class when input is disabled."]]
        [:tr
         [:td [:code "error"]]
         [:td "Used for the text error."]]
        [:tr
         [:td [:code "errored"]]
         [:td "Added to the root class when input is errored."]]
        [:tr
         [:td [:code "hidden"]]
         [:td "Used when the input is hidden."]]
        [:tr
         [:td [:code "hint"]]
         [:td "Used for the hint text."]]
        [:tr
         [:td [:code "icon"]]
         [:td "Used for the icon in case the input has icon."]]
        [:tr
         [:td [:code "input"]]
         [:td "Used as root class for the component."]]
        [:tr
         [:td [:code "inputElement"]]
         [:td "Used for the HTML input element."]]
        [:tr
         [:td [:code "label"]]
         [:td "Used for the label when the input has a label."]]
        [:tr
         [:td [:code "required"]]
         [:td "Used in case the input is required."]]
        [:tr
         [:td [:code "withIcon"]]
         [:td "Added to the root class if the input has icon."]]]]]
     [:section
      [:h2 "Methods"]
      [:p "The " [:code "Input"] " component has some imperative methods that are used as a bypass to the native "
       "rendered DOM element. To call this methods you will need to retrieve the instance of the component. Check the "
       [:a {:href "http://react-toolbox.com/#/install"} "Install"] " section for details on how to do this. The "
       "methods included for the " [:code "Input"] " are:"]
      [:ul
       [:li
        [:code "blur"] " used to blur the "
        [:code "input"] " element."]
       [:li
        [:code "focus"] " used to focus the "
        [:code "input"] " element."]]]]))

(defmethod layout/pages :input [_]
  [view])
