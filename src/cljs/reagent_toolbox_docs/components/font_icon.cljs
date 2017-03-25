;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.font-icon
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "Font Icon"]
     [:p " The font icon component is used to represent an icon from the " [:a {:href "https://material.io/icons/"} "Google Material Design"]
      " icon font. React Toolbox does not provide the font icon for you. You need to get the icons using whatever "
      "method you want. We recommend to import the font and the associated CSS from Google Fonts as is specified "
      [:a {:href "http://google.github.io/material-design-icons/#getting-icons"} "here"] "."]
     [ui/display-and-eval-code "
(defn font-icon-test []
  (fn []
    [:span
     [reagent-toolbox.core/font-icon {:value \"add\"}]
     [reagent-toolbox.core/font-icon {:value \"favorite\"}]
     [reagent-toolbox.core/font-icon {:value \"account_circle\"}]
     [reagent-toolbox.core/font-icon \"star\"]]))

[font-icon-test]"]
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
         [:td [:code "children"]]
         [:td [:code "string"]]
         [:td]
         [:td "The key string for the icon you want to be displayed."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "The class name to give custom styles such as sizing."]]
        [:tr
         [:td [:code "value"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "The key string for the icon you want be displayed."]]]]]]))

(defmethod layout/pages :font-icon [_]
  [view])
