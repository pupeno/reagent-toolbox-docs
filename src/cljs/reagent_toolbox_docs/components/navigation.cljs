;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.navigation
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Navigation"]
     [:p "This component is intended to be a common wrapper for a group of links or buttons. "
      "It sets a minimal layout, semantic markup and spacing for each of those elements."]

     [ui/display-and-eval-code "
(defn navigation-test []
  (let [actions [{:label \"Alarm\" :raised true :icon \"access_alarm\"}
                 {:label \"Location\" :raised true :accent true :icon \"room\"}]
        routes [{:href \"/navigation\" :label \"Favorite\" :icon \"favorite\"}
                {:href \"/navigation\" :active true :label \"History\" :icon \"history\"}]]
    (fn []
      [:div
       [reagent-toolbox.core/navigation {:type    \"horizontal\"
                                         :actions actions}]
       [reagent-toolbox.core/navigation {:type \"vertical\"}
        [reagent-toolbox.core/link {:href  \"/navigation\"
                                    :label \"Inbox\"
                                    :icon  \"inbox\"}]
        [reagent-toolbox.core/link {:href   \"/navigation\"
                                    :active true
                                    :label  \"Profile\"
                                    :icon   \"person\"}]]
       [reagent-toolbox.core/navigation {:routes routes}]])))

[navigation-test]"]

     [:p "If you want to provide a theme via context, the component key " [:code "RTCheckbox"] "."]

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
         [:td [:code "actions"]]
         [:td [:code "vector"]]
         [:td [:code ""]]
         [:td "Vector of maps that will be represented as buttons so the keys will be "
          "transferred as properties the button component."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td]
         [:td "Set a custom class styles to style the navigation."]]
        [:tr
         [:td [:code "routes"]]
         [:td [:code "vector"]]
         [:td]
         [:td "Vector of maps similar to actions but that will be rendered as link "
          "component definition."]]
        [:tr
         [:td [:code "type"]]
         [:td [:code "String"]]
         [:td [:code "horizontal"]]
         [:td "Type of the navigation, it can be vertical or horizontal."]]]]]

     [:section
      [:h2 "Theme"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "button"]]
         [:td "Used for buttons provided in the component."]]
        [:tr
         [:td [:code "horizontal"]]
         [:td "Used for the root element if the layout is horizontal."]]
        [:tr
         [:td [:code "link"]]
         [:td "Used for links provided in the component."]]
        [:tr
         [:td [:code "vertical"]]
         [:td "Used for the root element if the layout is vertical."]]]]]]))

(defmethod layout/pages :navigation [_]
  [view])
