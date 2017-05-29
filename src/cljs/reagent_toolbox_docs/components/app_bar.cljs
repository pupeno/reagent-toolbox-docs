;;;; Copyright © 2017 Flexpoint Tech Ltd.

(ns reagent-toolbox-docs.components.app-bar
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))

(defn view []
  (fn []
    [:article
     [:h1 "App Bar"]
     [:p "The app bar is a special kind of toolbar that's used for branding, navigation, search, and actions. Usually "
      "it contains controls on the right and left side and a title with the current section or app name. You should "
      "give the content with children elements."]
     [ui/display-and-eval-code "
(defn app-bar-test []
  (fn []
    (let [github-icon [:svg {:view-box \"  0 0 284 277\"} [:g [:path {:d \"M141.888675,0.0234927555 C63.5359948,0.0234927555 0,63.5477395 0,141.912168 C0,204.6023 40.6554239,257.788232 97.0321356,276.549924 C104.12328,277.86336 106.726656,273.471926 106.726656,269.724287 C106.726656,266.340838 106.595077,255.16371 106.533987,243.307542 C67.0604204,251.890693 58.7310279,226.56652 58.7310279,226.56652 C52.2766299,210.166193 42.9768456,205.805304 42.9768456,205.805304 C30.1032937,196.998939 43.9472374,197.17986 43.9472374,197.17986 C58.1953153,198.180797 65.6976425,211.801527 65.6976425,211.801527 C78.35268,233.493192 98.8906827,227.222064 106.987463,223.596605 C108.260955,214.426049 111.938106,208.166669 115.995895,204.623447 C84.4804813,201.035582 51.3508808,188.869264 51.3508808,134.501475 C51.3508808,119.01045 56.8936274,106.353063 65.9701981,96.4165325 C64.4969882,92.842765 59.6403297,78.411417 67.3447241,58.8673023 C67.3447241,58.8673023 79.2596322,55.0538738 106.374213,73.4114319 C117.692318,70.2676443 129.83044,68.6910512 141.888675,68.63701 C153.94691,68.6910512 166.09443,70.2676443 177.433682,73.4114319 C204.515368,55.0538738 216.413829,58.8673023 216.413829,58.8673023 C224.13702,78.411417 219.278012,92.842765 217.804802,96.4165325 C226.902519,106.353063 232.407672,119.01045 232.407672,134.501475 C232.407672,188.998493 199.214632,200.997988 167.619331,204.510665 C172.708602,208.913848 177.243363,217.54869 177.243363,230.786433 C177.243363,249.771339 177.078889,265.050898 177.078889,269.724287 C177.078889,273.500121 179.632923,277.92445 186.825101,276.531127 C243.171268,257.748288 283.775,204.581154 283.775,141.912168 C283.775,63.5477395 220.248404,0.0234927555 141.888675,0.0234927555\"}]]]]
      [reagent-toolbox.core/app-bar {:title               \"Reagent Toolbox\"
                                     :fixed               false
                                     :flat                false
                                     :left-icon           \"menu\"
                                     :on-left-icon-click  nil
                                     :right-icon          github-icon
                                     :on-right-icon-click nil
                                     :scroll-hide         false}
       [reagent-toolbox.core/navigation {:type :horizontal}
        [reagent-toolbox.core/link {:href \"http://\" :label \"Inbox\" :icon \"inbox\"}]
        [reagent-toolbox.core/link {:href \"http://\" :label \"Profile\" :icon \"person\" :active true}]]])))

[app-bar-test]"]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTAppBar"] "."]
     [:p "The app-bar component provides properties for the common use cases of title, leftIcon and rightIcon. "
      "However, you can also override these with your own content by not specifying these and instead provide "
      "children elements, as shown in the example."]
     [:section
      [:h2 "Properties"]
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
         [:td "Set a class for the root component."]]
        [:tr
         [:td [:code "fixed"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Determine if the bar should have position " [:code "fixed"] " or " [:code "relative"] "."]]
        [:tr
         [:td [:code "flat"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the app-bar shows a shadow."]]
        [:tr
         [:td [:code "theme"]]
         [:td [:code "object"]]
         [:td [:code "nil"]]
         [:td "Classnames object defining the component style."]]
        [:tr
         [:td [:code "title"]]
         [:td [:code "string"]]
         [:td [:code "nil"]]
         [:td "Title used for the app-bar."]]
        [:tr
         [:td [:code "left-icon"]]
         [:td [:code "string"] " or reagent component"]
         [:td [:code "nil"]]
         [:td "Left icon."]]
        [:tr
         [:td [:code "on-left-icon-click"]]
         [:td [:code "function"]]
         [:td [:code "nil"]]
         [:td "Called on left icon click event."]]
        [:tr
         [:td [:code "right-icon"]]
         [:td [:code "string"] " or reagent component"]
         [:td [:code "nil"]]
         [:td "Right icon."]]
        [:tr
         [:td [:code "on-right-icon-click"]]
         [:td [:code "function"]]
         [:td [:code "nil"]]
         [:td "Called on right icon click event."]]
        [:tr
         [:td [:code "scroll-hide"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Whether app-bar should be hidden during scroll."]]]]]
     [:h2 "Theme"]
     [:table
      [:thead
       [:tr
        [:th "Name"]
        [:th "Description"]]]
      [:tbody
       [:tr
        [:td [:code "appBar"]]
        [:td "Used for the component root element."]]
       [:tr
        [:td [:code "fixed"]]
        [:td "Added to the root element when the app bar is fixed."]]
       [:tr
        [:td [:code "flat"]]
        [:td "Added to the root element when the app bar is flat."]]
       [:tr
        [:td [:code "title"]]
        [:td "Added to the title element of the app bar."]]
       [:tr
        [:td [:code "left-icon"]]
        [:td "Added to the left icon element when the app bar."]]
       [:tr
        [:td [:code "right-icon"]]
        [:td "Added to the right icon element when the app bar."]]
       [:tr
        [:td [:code "scroll-hide"]]
        [:td "Added to the root element when the app bar is hidden during scroll."]]]]]))

(defmethod layout/pages :app-bar [_]
  [view])
