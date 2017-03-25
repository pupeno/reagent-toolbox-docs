;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.drawer
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Drawer"]
     [:p "The "
      [:a {:href "https://material.google.com/patterns/navigation-drawer.html"}
       "navigation drawer"]
      " slides in from the left. It is a common pattern found in Google apps and follows the "
      "keylines and metrics for lists."]

     [ui/display-and-eval-code
      "(defn drawer-test
         []
         (let [state (reagent.ratom/atom {:active false})]
           (fn []
             [:div
              [reagent-toolbox.core/button {:label \"Show Drawer\"
                                            :raised true
                                            :accent true
                                            :on-click #(swap! state update :active not)}]
              [reagent-toolbox.core/drawer {:active (@state :active)
                                            :on-overlay-click #(swap! state update :active not)}
               [:h5 \"This is your Drawer.\"]
               [:p \"You can embed any content you want; for example, a Menu.\"]]])))

      [drawer-test]"]

     [:p "If you want to provide a theme via context, the component key is " [:code "RTDrawer"] "."]

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
         [:td [:code "active"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the drawer will be visible."]]
        [:tr
         [:td [:code "active"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the drawer will be visible."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a class to give customized styles to the drawer."]]
        [:tr
         [:td [:code "on-overlay-click"]]
         [:td [:code "function"]]
         [:td [:code ""]]
         [:td "Callback function to be invoked when the overlay is clicked."]]
        [:tr
         [:td [:code "type"]]
         [:td [:code "string"]]
         [:td [:code "left"]]
         [:td "Type of drawer. It can be left or right to display the drawer on the left or "
          "right side of the screen."]]]]]

     [:section
      [:h2 "Theme"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "active"]]
         [:td "Used for the root class when the drawer is active."]]
        [:tr
         [:td [:code "content"]]
         [:td "Used for the drawer content."]]
        [:tr
         [:td [:code "drawer"]]
         [:td "Root class."]]
        [:tr
         [:td [:code "left"]]
         [:td "Added to the root class when drawer is to the left."]]
        [:tr
         [:td [:code "right"]]
         [:td "Added to the root class when drawer is to the right."]]]]]]))

(defmethod layout/pages :drawer [_]
  [view])
