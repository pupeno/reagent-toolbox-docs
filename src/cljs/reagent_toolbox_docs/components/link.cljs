;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.link
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "Link"]
     [:p "The link is a very simple component that acts mostly as a wrapper for the HTML anchor. It's not included in "
      "Material Design Specification but we provide it as an easy way to create links with icons and counters."]
     [ui/display-and-eval-code "
(defn link-test []
  (fn []
    [:div
     [reagent-toolbox.core/link {:active true
                                 :href   \"/link\"
                                 :label  \"Work\"
                                 :count  4
                                 :icon   \"business\"}]
     [reagent-toolbox.core/link {:href  \"/link\"
                                 :label \"Blog\"
                                 :icon  \"speaker_notes\"}]
     [reagent-toolbox.core/link {:href  \"/link\"
                                 :label \"Explore\"
                                 :icon  \"explore\"}]]))
[link-test]"]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTLink"] "."]
     [:section
      [:h2 "Properties"]
      [:p "You can add as many properties as you want to be directly transferred to the output anchor element. Apart "
       "from them you have the following properties:"]
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
         [:td "If true, adds active style to link."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a custom class name to add styles to the link."]]
        [:tr
         [:td [:code "count"]]
         [:td [:code "integer"]]
         [:td]
         [:td "Sets a count number."]]
        [:tr
         [:td [:code "icon"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "An icon key string to include a font-icon component in front of the text."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string used for the text content of the link."]]]]]
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
         [:td "Added to the root element if the link is active."]]
        [:tr
         [:td [:code "icon"]]
         [:td "Used for the icon element if it's present."]]
        [:tr
         [:td [:code "link"]]
         [:td "Used for the root element."]]]]]]))

(defmethod layout/pages :link [_]
  [view])
