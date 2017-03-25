;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.progress-bar
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Progress Bar"]
     [:p "Minimize visual changes that occur while your app loads content by representing "
      "each operation with a single activity indicator. For example, a refresh operation should "
      "display either a refresh bar or an activity circle, but not both."]

     [ui/display-and-eval-code "
(defn progress-bar-test []
  (fn []
    [:div
     [reagent-toolbox.core/progress-bar {:type \"circular\"
                                         :mode \"indeterminate\"}]
     [reagent-toolbox.core/progress-bar {:type   \"linear\"
                                         :mode   \"determinate\"
                                         :value  83
                                         :buffer 90}]]))

[progress-bar-test]"]

     [:p "If you want to provide a theme via context, the component key is " [:code "RTProgressBar"] "."]

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
         [:td [:code "buffer"]]
         [:td [:code "int"]]
         [:td [:code "0"]]
         [:td "Value of a secondary progress bar useful for buffering."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Additional class name to provide custom styling."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, component will be disabled."]]
        [:tr
         [:td [:code "max"]]
         [:td [:code "int"]]
         [:td [:code "100"]]
         [:td "Maximum value permitted."]]
        [:tr
         [:td [:code "min"]]
         [:td [:code "int"]]
         [:td [:code "0"]]
         [:td "Minimum value permitted."]]
        [:tr
         [:td [:code "mode"]]
         [:td [:code "string"]]
         [:td [:code "indeterminate"]]
         [:td "Mode of the progress bar, it can be determinate or indeterminate."]]
        [:tr
         [:td [:code "multicolor"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the circular progress bar will be changing its color."]]
        [:tr
         [:td [:code "type"]]
         [:td [:code "string"]]
         [:td [:code "linear"]]
         [:td "Type of the progress bar, it can be circular or linear."]]
        [:tr
         [:td [:code "value"]]
         [:td [:code "int"]]
         [:td [:code "0"]]
         [:td "Value of the current progress."]]
        ]]]

     [:section
      [:h2 "Theme"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "buffer"]]
         [:td "Used to style the buffer element in the linear progress."]]
        [:tr
         [:td [:code "circle"]]
         [:td "Used for the circle element in the circular progress."]]
        [:tr
         [:td [:code "circular"]]
         [:td "Used for the root element when the type is circular."]]
        [:tr
         [:td [:code "indeterminate"]]
         [:td "Added to the root element if mode is indeterminate."]]
        [:tr
         [:td [:code "linear"]]
         [:td "Used for the root element when the type is linear."]]
        [:tr
         [:td [:code "multicolor"]]
         [:td "Added to the root if the component is multicolor (circular)."]]
        [:tr
         [:td [:code "path"]]
         [:td "Used for the inner path in the circular progress."]]
        [:tr
         [:td [:code "value"]]
         [:td "Used to style the value element in the linear progress."]]]]]]))

(defmethod layout/pages :progress-bar [_]
  [view])
