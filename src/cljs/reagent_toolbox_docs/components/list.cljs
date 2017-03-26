;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.list
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "List"]
     [:p "A " [:a {:href "https://material.io/guidelines/components/lists.html"} "list component"] " consists of a "
      "single continuous column of tessellated sub-divisions of equal width called rows that function as containers "
      "for tiles. Tiles hold content, and can vary in height within a list."]
     [:p "Lists are best suited to presenting a homogeneous data type or sets of data types, such as images and text, "
      "optimized for reading comprehension with the goal of differentiating between like data types or qualities "
      "within a single data type. You can compose lists based on subcomponents."]
     [ui/display-and-eval-code "
(defn list-test []
  (let [notify-new-comics (reagent.ratom/atom false)]
    (fn []
      [:div
       [reagent-toolbox.core/list {:selectable true
                                   :ripple     true}
        [reagent-toolbox.core/list-sub-header {:caption \"Explore characters\"}]
        [reagent-toolbox.core/list-item {:avatar     \"http://vignette1.wikia.nocookie.net/watchmen/images/7/7c/Doctor_Manhattan_%28movie%29.jpg\"
                                         :caption    \"Dr. Manhattan\"
                                         :legend     \"Jonathan 'Jon' Osterman\"
                                         :right-icon \"star\"}]

        [reagent-toolbox.core/list-item {:avatar     \"http://vignette1.wikia.nocookie.net/watchmen/images/5/5b/Ozymandias.jpg\"
                                         :caption    \"Ozymandias\"
                                         :legend     \"Adrian veidt\"
                                         :right-icon \"star\"}]

        [reagent-toolbox.core/list-item {:avatar     \"http://vignette3.wikia.nocookie.net/watchmen/images/6/64/Rorschach.jpg\"
                                         :caption    \"Rorschach\"
                                         :legend     \"Walter Joseph Kovacs\"
                                         :right-icon \"star\"}]

        [reagent-toolbox.core/list-sub-header {:caption \"Configuration\"}]
        [reagent-toolbox.core/list-checkbox {:caption   \"Notify new comics\"
                                             :legend    \"You will receive a notification when a new one is published\"
                                             :checked   @notify-new-comics
                                             :on-change #(reset! notify-new-comics %)}]
        [reagent-toolbox.core/list-divider]
        [reagent-toolbox.core/list-item {:caption   \"Contact the publisher\"
                                         :left-icon \"send\"}]
        [reagent-toolbox.core/list-item {:caption   \"Remove this publication\"
                                         :left-icon \"delete\"}]]])))

[list-test]"]
     [:p "If you want to provide styles via context to this components, you should use the key " [:code "RTList"] "."]
     [:section
      [:h2 "List"]
      [:p "Is used as a wrapper for the list. It can hold properties that affect to the whole list and get styles for the wrapper."]
      [:section
       [:h3 "Properties"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Type"]
          [:th "Default"]
          [:th.description "Description"]]]
        [:tbody
         [:tr
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td [:code "\"\""]]
          [:td "Sets a class to give custom styles to the list wrapper."]]
         [:tr
          [:td [:code "ripple"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If true, each element in the list will have a ripple effect on click"]]
         [:tr
          [:td
           [:code "selectable"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If true, the elements in the list will display a hover effect and a pointer cursor."]]]]]
      [:section
       [:h3 "Theme"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th.description "Description"]]]
        [:tbody
         [:tr
          [:td [:code "list"]]
          [:td "Used for the root element of the list."]]]]]]
     [:section
      [:h2 {:id "list-item"} "List Item"]
      [:p "Represents a list item that can have avatar, icons, title, subtitle, etc. Note: you have to set it as an inmediate child of "
       [:code "List"] " component."]
      [:h3 {:id "properties"} "Properties"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "avatar"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "A string URL to specify an avatar in the left side of the item."]]
        [:tr
         [:td [:code "caption"]]
         [:td [:code "string"]]
         [:td]
         [:td "Main text of the item."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Set a class to give custom styles to the list item."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "string"]]
         [:td [:code "false"]]
         [:td "If true, the item is displayed as disabled and is not clickable."]]
        [:tr
         [:td [:code "item-content"]]
         [:td "reagent component"]
         [:td]
         [:td "An element that will be displayed as the item. If set, this will override " [:code "caption"] " and "
          [:code "legend"] "."]]
        [:tr
         [:td [:code "leftActions"]]
         [:td [:code "Vector of reagent components"]]
         [:td]
         [:td "A list of elements that are placed on the left side of the item and after the avatar attribute."]]
        [:tr
         [:td [:code "left-icon"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "A string key of a font icon or element to display an icon in the left side of the item."]]
        [:tr
         [:td [:code "legend"]]
         [:td [:code "string"]]
         [:td]
         [:td "Secondary text to display under the caption."]]
        [:tr
         [:td [:code "on-click"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback the is invoked when the item is clicked if it's not disabled."]]
        [:tr
         [:td [:code "right-icon"]]
         [:td [:code "string"] " or reagent component"]
         [:td]
         [:td "The same as the " [:code "left-icon"] " but in this case the icon is displayed in the right side."]]
        [:tr
         [:td [:code "rightActions"]]
         [:td [:code "Vector of reagent components"]]
         [:td]
         [:td "A list of elements that are placed on the right side of the item and after the " [:code "right-icon"]
          " attribute."]]
        [:tr
         [:td [:code "ripple"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the item displays a ripple effect on click. By default it's inherited from the parent "
          "element."]]
        [:tr
         [:td
          [:code "selectable"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the elements in the list will display a hover effect and a pointer cursor. Inherited from the "
          "parent."]]
        [:tr
         [:td [:code "to"]]
         [:td [:code "string"]]
         [:td]
         [:td "In case you want to provide the item as a link, you can pass this property to specify the href."]]]]
      [:h3 "Theme"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "disabled"]]
         [:td "Added to the inner content if its a disabled item."]]
        [:tr
         [:td [:code "item"]]
         [:td "Used for the inner content of a list item."]]
        [:tr
         [:td
          [:code "item-action"]]
         [:td "Used for each action element (left/right)."]]
        [:tr
         [:td [:code "item-contentRoot"]]
         [:td "Used for the content wrapper element in list item."]]
        [:tr
         [:td [:code "itemText"]]
         [:td "Added to the text inside of the list item."]]
        [:tr
         [:td [:code "large"]]
         [:td "Added to the content wrapper element if size is large."]]
        [:tr
         [:td [:code "left"]]
         [:td "Added for the element that wraps left actions."]]
        [:tr
         [:td [:code "listItem"]]
         [:td "Used for the root element of the list."]]
        [:tr
         [:td [:code "primary"]]
         [:td "Added to the text inside of the list item if its primary."]]
        [:tr
         [:td [:code "right"]]
         [:td "Added for the element that wraps right actions."]]
        [:tr
         [:td [:code "selectable"]]
         [:td "Added to the inner content if its a selectable item."]]]]]
     [:section
      [:h2 "List Checkbox"]
      [:p "A special type of item that has a checkbox control on the left side. It implements similar methods to the "
       [:code "ListItem"] " component and some additional to control the checkbox."]
      [:h3 "Properties"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "caption"]]
         [:td [:code "string"]]
         [:td]
         [:td "Main text of the item. Required."]]
        [:tr
         [:td [:code "class-name"]]
         [:td
          [:code "string"]]
         [:td]
         [:td "Set a class to give custom styles to Component."]]
        [:tr
         [:td [:code "checked"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true the checkbox appears checked by default."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "string"]]
         [:td [:code "false"]]
         [:td "If true, the item is displayed as disabled and it's not clickable."]]
        [:tr
         [:td [:code "legend"]]
         [:td [:code "string"]]
         [:td]
         [:td "Secondary text to display under the caption."]]
        [:tr
         [:td [:code "name"]]
         [:td [:code "string"]]
         [:td]
         [:td "Name for the checkbox input item."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the input element is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the input element is changed."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the input element is focused."]]]]
      [:h3 "Theme"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "checkbox"]]
         [:td "Used as a wrapper class for the subheader element."]]
        [:tr
         [:td [:code "checkboxItem"]]
         [:td "Added to the checkbox element."]]
        [:tr
         [:td [:code "disabled"]]
         [:td "Added to the root element if the component is disabled."]]
        [:tr
         [:td [:code "item"]]
         [:td "Used as a wrapper class root element element. Same as List."]]
        [:tr
         [:td [:code "item-contentRoot"]]
         [:td "Used for the content wrapper element in list item."]]
        [:tr
         [:td [:code "itemText"]]
         [:td "Added to the text inside of the list item."]]
        [:tr
         [:td [:code "large"]]
         [:td "Added to the content wrapper element if size is large."]]
        [:tr
         [:td [:code "primary"]]
         [:td "Added to the text inside of the list item if its primary."]]]]]
     [:section
      [:h2 "List Subheader"]
      [:p "Simple subcomponent used to give a title to a list area."]
      [:h3 "Properties"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Type"]
         [:th "Default"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "caption"]]
         [:td [:code "string"]]
         [:td]
         [:td "Text that will be displayed."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Set a class to give custom styles to the list subheader."]]]]
      [:h3 "Theme"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td
          [:code "subheader"]]
         [:td "Used as a wrapper class for the subheader element."]]]]]
     [:section
      [:h2 "List Divider"]
      [:p "Simple subcomponent used to separate list sections or items. It has only one property " [:code "inset"] " "
       "which is a " [:code "boolean"] " that indicates if the divider should be full with or should leave an space "
       "to the left side. It has two theming keys: " [:code "inset"] " and " [:code "divider"] " that will be used "
       "depending on wether it should full width or leave space."]]]))

(defmethod layout/pages :list [_]
  [view])
