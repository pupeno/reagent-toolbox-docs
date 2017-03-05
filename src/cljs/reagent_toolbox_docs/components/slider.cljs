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

     ]))

(defmethod layout/pages :slider [_]
  [view])
