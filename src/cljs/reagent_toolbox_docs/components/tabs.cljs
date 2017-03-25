;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.tabs
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))

(defn view []
  (fn []
    [:article
     [:h1 "Tabs"]
     [:p [:a {:href "https://material.io/guidelines/components/tabs.html"} "Tabs"] " make it easy to explore and "
      "switch between different views or functional aspects of an app or to browse categorized data sets. Tabs are "
      "composed with their content, but only the active tab's content is rendered. In the future, we may add the "
      "ability to render headers only, with event listeners.\n\n"]
     [ui/display-and-eval-code "
(defn tabs-test []
  (let [index (reagent.ratom/atom 0)
        fixed-index (reagent.ratom/atom 0)
        inverse-index (reagent.ratom/atom 0)]
   (fn []
     [:div
       [reagent-toolbox.core/tabs {:index     @index
                                   :on-change #(reset! index %)}
        [reagent-toolbox.core/tab {:label \"First\"}
         [:small \"Primary content\"]]
        [reagent-toolbox.core/tab {:label \"Second\"}
         [:small \"Secondary content\"]]
        [reagent-toolbox.core/tab {:label \"Third\" :disabled true}
         [:small \"Terciary content\"]]
        [reagent-toolbox.core/tab {:label \"Fourth\" :hidden true}
         [:small \"Quaternary content\"]]
        [reagent-toolbox.core/tab {:label \"Fifth\"}
         [:small \"Quinary content\"]]]

       [reagent-toolbox.core/tabs {:index     @fixed-index
                                   :on-change #(reset! fixed-index %)
                                   :fixed     true}
        [reagent-toolbox.core/tab {:label \"First\"}
         [:small \"Primary content\"]]
        [reagent-toolbox.core/tab {:label \"Second\"}
         [:small \"Secondary content\"]]
        [reagent-toolbox.core/tab {:label \"Third\" :disabled true}
         [:small \"Terciary content\"]]
        [reagent-toolbox.core/tab {:label \"Fourth\" :hidden true}
         [:small \"Quaternary content\"]]
        [reagent-toolbox.core/tab {:label \"Fifth\"}
         [:small \"Quinary content\"]]]

       [reagent-toolbox.core/tabs {:index     @inverse-index
                                   :on-change #(reset! inverse-index %)
                                   :inverse   true}
        [reagent-toolbox.core/tab {:label \"First\"}
         [:small \"Primary content\"]]
        [reagent-toolbox.core/tab {:label \"Second\"}
         [:small \"Secondary content\"]]
        [reagent-toolbox.core/tab {:label \"Third\" :disabled true}
         [:small \"Terciary content\"]]
        [reagent-toolbox.core/tab {:label \"Fourth\" :hidden true}
         [:small \"Quaternary content\"]]
        [reagent-toolbox.core/tab {:label \"Fifth\"}
         [:small \"Quinary content\"]]]])))

[tabs-test]"]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTTabs"] "."]
     [:section
      [:h2 "Tabs"]
      [:p "This component acts as the wrapper and the main controller of the content that is being displayed. It gets "
       "some properties that can be spread to the children."]
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
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td [:code "\"\""]]
          [:td "Additional class name to provide custom styling."]]
         [:tr
          [:td [:code "disable-animated-bBottom-border"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "Disable the animation below the active tab."]]
         [:tr
          [:td [:code "fixed"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If True, the tabs will be \"fixed tabs\"."]]
         [:tr
          [:td [:code "hide-mode"]]
          [:td [:code "\"display\""] " or " [:code "\"unmounted\""]]
          [:td [:code "unmounted"]]
          [:td [:code "unmounted"] " mode will not mount the tab content of inactive tabs. " [:code "display"] " mode "
           "will mount but hide inactive tabs. Consider holding state outside of the Tabs component before using  "
           [:code "display"] " mode"]]
         [:tr
          [:td [:code "index"]]
          [:td [:code "numberic"]]
          [:td [:code "0"]]
          [:td "Current " [:tab]]]
         [:tr
          [:td [:code "inverse"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If true, the tabs will have an inverse style."]]
         [:tr
          [:td [:code "on-change"]]
          [:td [:code "function"]]
          [:td]
          [:td "Callback function that is fired when the tab changes."]]]]]
      [:section
       [:h3 "Theming"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "active"]]
          [:td "Added to the active tab content and header."]]
         [:tr
          [:td [:code "fixed"]]
          [:td "Used to make the tabs \"fixed tabs\"."]]
         [:tr
          [:td [:code "inverse"]]
          [:td "Used to invert the colors."]]
         [:tr
          [:td [:code "navigation"]]
          [:td "Used for the navigation element."]]
         [:tr
          [:td [:code "pointer"]]
          [:td "Used for the moving underline element."]]
         [:tr
          [:td [:code "tabs"]]
          [:td "Used as a root classname for the component."]]
         [:tr
          [:td [:code "tab"]]
          [:td "Used for the tab content element."]]]]]]
     [:section
      [:h2 "Tab"]
      [:p "Represent a single tab element and it should include some properties to describe the tab itself and get children elements as content."]
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
          [:td [:code "active"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If true, the current component is visible."]]
         [:tr
          [:td [:code "active-class-name"]]
          [:td [:code "string"]]
          [:td [:code "\"\""]]
          [:td "Additional class name to provide custom styling for the active tab."]]
         [:tr
          [:td [:code "class-name"]]
          [:td [:code "string"]]
          [:td [:code "\"\""]]
          [:td "Additional class name to provide custom styling for each tab."]]
         [:tr
          [:td [:code "disabled"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If true, the current component is not clickable."]]
         [:tr
          [:td [:code "hidden"]]
          [:td [:code "boolean"]]
          [:td [:code "false"]]
          [:td "If true, the current component is not visible."]]
         [:tr
          [:td [:code "icon"]]
          [:td [:code "string"]]
          [:td]
          [:td "Icon for navigation header."]]
         [:tr
          [:td [:code "label"]]
          [:td [:code "string"]]
          [:td]
          [:td "Label text for navigation header."]]
         [:tr
          [:td [:code "on-active"]]
          [:td [:code "function"]]
          [:td]
          [:td "Callback function that is fired when the tab is activated."]]
         [:tr
          [:td [:code "on-click"]]
          [:td [:code "function"]]
          [:td]
          [:td "Callback function that is fired when the tab is clicked."]]]]]
      [:section
       [:h3 "Theming"]
       [:table
        [:thead
         [:tr
          [:th "Name"]
          [:th "Description"]]]
        [:tbody
         [:tr
          [:td [:code "active"]]
          [:td "Added to the navigation tab element in case it's active."]]
         [:tr
          [:td [:code "disabled"]]
          [:td "Added to the navigation tab element in case it's disabled."]]
         [:tr
          [:td [:code "hidden"]]
          [:td "Added to the navigation tab element in case it's hidden."]]
         [:tr
          [:td [:code "label"]]
          [:td "Added to the navigation tab element in case it's active."]]]]]]]))

(defmethod layout/pages :tabs [_]
  [view])
