;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.slider
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Slider"]
     [:p
      [:a {:href "https://material.google.com/components/sliders.html"} "Sliders"]
      " let users select a value from a continuous or discrete range of values by moving the "
      "slider thumb. The smallest value is to the left, the largest to the right. Sliders can "
      "have icons to the left and right of the bar that reflect the value intensity. The "
      "interactive nature of the slider makes it a great choice for settings that reflect "
      "intensity levels, such as volume, brightness, or color saturation."]

     [ui/display-and-eval-code
      "(defn slider-test
         []
         (let [sliders (reagent.ratom/atom {:slider2 5 :slider3 1 :slider4 3})]
           (fn []
             [:section
[:p \"Value: \" (pr-str @sliders)]
              [:p \"Normal slider\"]
              [reagent-toolbox.core/slider {:value (@sliders :slider1)
                                            :on-change #(swap! sliders assoc :slider1 %)}]
              [:p \"With steps, initial value, and editable\"]
              [reagent-toolbox.core/slider {:value (@sliders :slider2)
                                            :min 0
                                            :max 10
                                            :editable true
                                            :on-change #(swap! sliders assoc :slider2 %)}]
              [:p \"Pinned and with snaps\"]
              [reagent-toolbox.core/slider {:value (@sliders :slider3)
                                            :editable true
                                            :pinned true
                                            :snaps true
                                            :min 0
                                            :max 10
                                            :step 1
                                            :on-change #(swap! sliders assoc :slider3 %)}]
              [:p \"Disabled\"]
              [reagent-toolbox.core/slider {:value (@sliders :slider4)
                                            :disabled true
                                            :on-change #(swap! sliders assoc :slider4 %)}]

])))
       [slider-test]"]

     [:p "This component can be styled by context providing a theme with the key RTSwitch through the theme provider."]

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
         [:td "If true, the switch will be enabled."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "''"]]
         [:td "Sets a class to give custom styles to the switch."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, component will be disabled."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string to use for the floating label element."]]
        [:tr
         [:td [:code "name"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string used as name of the input."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when when the switch is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the component's value changes."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the switch is focused."]]
        ]]]

     [:section
      [:h2 "Theme"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tr
        [:td [:code "disabled"]]
        [:td "Used for the root element if the component is disabled."]]
       [:tr
        [:td [:code "field"]]
        [:td "Used for the root element if the component is not disabled."]]
       [:tr
        [:td [:code "input"]]
        [:td "Used for the input element."]]
       [:tr
        [:td [:code "off"]]
        [:td "Used for a wrapper around the thumb if checked is false."]]
       [:tr
        [:td [:code "on"]]
        [:td "Used for a wrapper around the thumb if checked is true."]]
       [:tr
        [:td [:code "ripple"]]
        [:td "Used for the ripple inside the switch."]]
       [:tr
        [:td [:code "text"]]
        [:td "Used for the text label element."]]
       [:tr
        [:td [:code "thumb"]]
        [:td "Used for the thumb element."]]]]]))

(defmethod layout/pages :slider [_]
  [view])
