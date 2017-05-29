;;;; Copyright © 2017 Flexpoint Tech Ltd.

(ns reagent-toolbox-docs.components.dialog
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))

(defn dialog-test []
  (let [active (reagent.ratom/atom false)]
    (fn []
      [:div
       [reagent-toolbox.core/button {:label    "Show My Dialog"
                                     :on-click #(reset! active true)}]
       [reagent-toolbox.core/dialog {:active           @active
                                     :actions          [{:label "Cancel" :on-click #(reset! active false)}
                                                        {:label "Save" :on-click #(reset! active false)}]
                                     :on-esc-key-down  #(reset! active false)
                                     :on-overlay-click #(reset! active false)
                                     :title            "My awesome dialog"}
        [:p "Here you can add arbitrary content. Components like pickers are using dialogs now."]]])))

(defn view []
  (fn []
    [:article
     [:h1 "Dialog"]
     [:p
      [:a {:href "https://material.google.com/components/dialogs.html"} "Dialogs"] " contain text and UI controls "
      "focused on a specific task. They inform users about critical information, require users to make decisions, or "
      "involve multiple tasks. You would need an additional component to take actions and display or hide the dialog."]
     [dialog-test]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTDialog"] "."]
     [:section
      [:h1 "Properties"]
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
         [:td [:code "[]"]]
         [:td "A vector of objects representing the buttons for the dialog navigation area. The properties will be transferred to the buttons."]]
        [:tr
         [:td [:code "active"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the dialog will be active."]]
        [:tr
         [:td [:code "className"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a class to give customized styles to the dialog."]]
        [:tr
         [:td [:code "on-esc-key-down"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the ESC key is pressed with the overlay active."]]
        [:tr
         [:td [:code "on-overlay-click"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback to be invoked when the dialog overlay is clicked."]]
        [:tr
         [:td [:code "on-overlay-mouse-down"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the mouse button is pressed on the overlay."]]
        [:tr
         [:td [:code "on-overlay-mouse-move"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the mouse is moving over the overlay."]]
        [:tr
         [:td [:code "on-overlay-mouse-up"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the mouse button is released over the overlay."]]
        [:tr
         [:td [:code "title"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string to use as standar title of the dialog."]]
        [:tr
         [:td [:code "type"]]
         [:td [:code "string"]]
         [:td [:code "\"normal\""]]
         [:td "Used to determine the size of the dialog. It can be " [:code "\"small\""] ", " [:code "\"normal\""] ", "
          [:code "\"large\""] " or " [:code "\"fullscreen\""] "."]]]]
      [:p
       "Notice that the " [:code "\"fullscreen\""] " option only applies on mobile devices with small screens (i.e. "
       "cellphones), and on other devices it behaves as a "
       [:code "large"] " dialog."]]
     [:section
      [:h1 "Theme"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "active"]]
         [:td "Used for the root when the dialog is active."]]
        [:tr
         [:td [:code "body"]]
         [:td "Used to wrap the dialog body."]]
        [:tr
         [:td [:code "button"]]
         [:td "Used in buttons when the dialog implements actions."]]
        [:tr
         [:td [:code "dialog"]]
         [:td "Used for the root element."]]
        [:tr
         [:td [:code "navigation"]]
         [:td "Used for the navigation element when it implements actions."]]
        [:tr
         [:td [:code "title"]]
         [:td "Used for the title element of the dialog."]]]]]]))

(defmethod layout/pages :dialog [_]
  [view])
