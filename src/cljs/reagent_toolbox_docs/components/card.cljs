;;;; Copyright © 2017 Flexpoint Tech Ltd.

(ns reagent-toolbox-docs.components.card
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))

(defn view []
  (fn []
    [:article
     [:h1 "Card"]
     [:p "A " [:a {:href "https://material.google.com/components/cards.html"} "Card"] " is a piece of paper with "
      "unique related data that serves as an entry point to more detailed information. For example, a card could "
      "contain a photo, text, and a link about a single subject."]
     [:p "Cards are composed of multiple subcomponents in React Toolbox. You can combine each of the subcomponents to "
      "create all different Material Design Cards given in the spec."]
     [ui/display-and-eval-code "
(defn card-test []
  (fn []
    [reagent-toolbox.core/card {:style {:width \"350px\"}}
      [reagent-toolbox.core/card-title {:avatar   \"https://placeimg.com/80/80/animals\"
                                        :title    \"Avatar style title\"
                                        :subtitle \"Subtitle here\"}]
      [reagent-toolbox.core/card-media {:aspect-ratio \"wide\"
                                        :image        \"https://placeimg.com/800/450/nature\"}]
      [reagent-toolbox.core/card-title {:title    \"Title goes here\"
                                        :subtitle \"Subtitle here\"}]
      [reagent-toolbox.core/card-text \"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.\"]
      [reagent-toolbox.core/card-actions
       [reagent-toolbox.core/button {:label \"Action 1\"}]
       [reagent-toolbox.core/button {:label \"Action 2\"}]]]))

[card-test]"]
     [:p "This component and all of its subcomponents are themeable by context using the key " [:code "RTCard"] ". "
      "This component theme can also include class modifiers for " [:code "Button"] " and " [:code "Avatar"]
      " component."]
     [:section
      [:h2 "Card"]
      [:p "The base card component. This acts as the main card container that all subcomponents are placed within."]
      [:section
       [:h3 "Properties"]
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
          [:td [:code "Any"]]
          [:td]
          [:td "Child components, usually Card subcomponents."]]
         [:tr
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td]
          [:td "Additional class(es) for custom styling."]]
         [:tr
          [:td [:code "raised"]]
          [:td [:code "boolean"]]
          [:td]
          [:td "Increases the shadow depth to appear elevated."]]]]]
      [:section
       [:h3 "Theme"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "card"]]
          [:td "Class used for the root element."]]
         [:tr
          [:td [:code "raised"]]
          [:td "Added to the root element in case the card is raised."]]]]]]
     [:section
      [:h2 "Card Title"]
      [:p "A versatile title block that can be used in various places on the card, including the media area. "
       "This component can also display an avatar next to the title content."]
      [:section
       [:h3 "Properties"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Type"]
          [:th "Default"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td
           [:code "avatar"]]
          [:td [:code "string"] " or element"]
          [:td]
          [:td "A string URL or element to specify an avatar in the left side of the title."]]
         [:tr
          [:td
           [:code "children"]]
          [:td [:code "string"] ", element or " [:code "vector"]]
          [:td]
          [:td "Children to pass through the component."]]
         [:tr
          [:td
           [:code "class-name"]]
          [:td [:code "string"]]
          [:td]
          [:td "Additional class(es) for custom styling."]]
         [:tr
          [:td [:code "subtitle"]]
          [:td [:code "string"]]
          [:td]
          [:td "Text used for the sub header of the card."]]
         [:tr
          [:td [:code "title"]]
          [:td [:code "string"]]
          [:td]
          [:td "Text used for the title of the card."]]]]]
      [:sectino
       [:h3 "Theme"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "card-title"]]
          [:td "Class used for the root element."]]
         [:tr
          [:td [:code "large"]]
          [:td "Added to the root element when the card has no avatar."]]
         [:tr
          [:td [:code "small"]]
          [:td "Added to the root element when the card has avatar."]]
         [:tr
          [:td [:code "subtitle"]]
          [:td "Added to the subtitle element."]]
         [:tr
          [:td [:code "title"]]
          [:td "Added to the title element."]]]]]]
     [:section
      [:h2 "Card Media"]
      [:p "Used for displaying media such as images or videos on a card. Can also be used with a solid background "
       "color instead of an image."]
      [:section
       [:h3 "Properties"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Type"]
          [:th "Default"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "aspect-ratio"]]
          [:td [:code "\"wide\""] " or" [:code "\"square\""]]
          [:td]
          [:td "Forces a 16:9 or 1:1 aspect ratio respectively. Unset, the media area will have a flexible height."]]
         [:tr
          [:td [:code "children"]]
          [:td [:code "Any"]]
          [:td]
          [:td "Usually an image/video element or a " [:code "card-title"] " component."]]
         [:tr
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td]
          [:td "Additional class(es) for custom styling."]]
         [:tr
          [:td [:code "color"]]
          [:td [:code "string"]]
          [:td]
          [:td "Sets the background color."]]
         [:tr
          [:td [:code "content-overlay"]]
          [:td [:code "boolean"]]
          [:td]
          [:td "Creates a dark overlay underneath the child components."]]
         [:tr
          [:td [:code "image"]]
          [:td [:code "string"] " or element"]
          [:td]
          [:td "Can be used instead of children. Accepts an element or a URL string."]]]]]
      [:section
       [:h3 "Theme"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "card-media"]]
          [:td "Added to the element root."]]
         [:tr
          [:td [:code "content"]]
          [:td "Used for the content element."]]
         [:tr
          [:td [:code "content-overlay"]]
          [:td "Added to content element if its overlayed."]]
         [:tr
          [:td [:code "square"]]
          [:td "Added to content element if its squared."]]
         [:tr
          [:td
           [:code "wide"]]
          [:td "Added to content element if its wide."]]]]]]
     [:section
      [:h2 "Card Text"]
      [:p "Basic card content container. Good for small descriptions or other supplementary text."]
      [:section
       [:h3 "Properties"]
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
          [:td [:code "Any"]]
          [:td]
          [:td "Children to pass through the component."]]
         [:tr
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td]
          [:td "Additional class(es) for custom styling."]]]]]
      [:section
       [:h3 "Theme"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "card-text"]]
          [:td "Used for the main root element."]]]]]]
     [:section
      [:h2 "Card Actions"]
      [:p "This component is used as a container for supplemental card actions. Supplemental actions within the card "
       "are explicitly called out using icons, text, and UI controls, typically placed at the bottom of the card."]
      [:section
       [:h3 "Properties"]
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
          [:td [:code "Any"]]
          [:td]
          [:td "Children to pass through the component."]]
         [:tr
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td]
          [:td "Additional class(es) for custom styling."]]]]]
      [:section
       [:h3 "Theme"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "card-actions"]]
          [:td "Used for a wrapper around actions as the root element."]]]]]]]))

(defmethod layout/pages :card [_]
  [view])
