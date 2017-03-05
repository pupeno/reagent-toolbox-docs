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
     
     ]))

  (defmethod layout/pages :slider [_]
    [view]))
