;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.time-picker
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "Time Picker"]
     [:p "A " [:a {:href "https://material.google.com/components/pickers.html#pickers-time-pickers"} "dialog picker"]
      " is used to select a single time (hours:minutes). The selected time is indicated by the filled circle at the end"
      " of the clock hand."]
     [ui/display-and-eval-code "
(defn time-picker-test []
  (let [value (atom (js/Date.))]
    (fn []
      [reagent-toolbox.core/time-picker {:label     \"Finishing time\"
                                         :value     @value
                                         :on-change (fn [& args] (println \"change\" args))}])))

[time-picker-test]"]

     [:p "If you want to provide a theme via context, the component key is " [:code "RTTimePicker"] "."]
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
         [:td [:code "active"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "Allows to control if the picker should be shown from outside. Beware you should update the prop when the"
          " Dialog is closed."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td]
         [:td "This class will be placed at the top of the " [:code "TimePickerDialog"] " component so you can provide "
          "custom styles."]]
        [:tr
         [:td [:code "error"]]
         [:td [:code "string"]]
         [:td]
         [:td "Provide error text which will be displayed under the field."]]
        [:tr
         [:td [:code "input-class-name"]]
         [:td [:code "string"]]
         [:td]
         [:td "This class will be applied to " [:code "Input"] " component of " [:code "TimePicker"] "."]]
        [:tr
         [:td [:code "format"]]
         [:td [:code "string"]]
         [:td [:code "24hr"]]
         [:td "Format to display the clock. It can be " [:code "24hr"] " or " [:code "ampm"] "."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string to use for the floating label element in the input component."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback called when the picker value is changed."]]
        [:tr
         [:td [:code "readonly"]]
         [:td [:code "boolean"]]
         [:td]
         [:td "The input element will be readonly and look like disabled."]]
        [:tr
         [:td [:code "value"]]
         [:td [:code "Date"]]
         [:td]
         [:td "Datetime object with currrently selected time."]]]]]
     [:section
      [:h2 "Theme"]
      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th.description "Description"]]]
       [:tbody
        [:tr
         [:td [:code "active"]]
         [:td "Added to the number which is active in clock face."]]
        [:tr
         [:td [:code "am"]]
         [:td "AM label in dialog header when mode is AM/PM."]]
        [:tr
         [:td [:code "amFormat"]]
         [:td "Added to the dialog when the selected format is AM."]]
        [:tr
         [:td [:code "ampm"]]
         [:td "Wrapper for AM and PM labels in header when mode is AM/PM."]]
        [:tr
         [:td [:code "button"]]
         [:td "Used for buttons inside the dialog of the picker."]]
        [:tr
         [:td [:code "clock"]]
         [:td "Clock root class element."]]
        [:tr
         [:td [:code "clockWrapper"]]
         [:td "Wrapper for the proper positioning of the clock."]]
        [:tr
         [:td [:code "dialog"]]
         [:td "Used for the dialog component."]]
        [:tr
         [:td [:code "face"]]
         [:td "Used to style the clock face."]]
        [:tr
         [:td [:code "hand"]]
         [:td "Used for the clock's hand."]]
        [:tr
         [:td [:code "header"]]
         [:td "Dialog header wrapper class."]]
        [:tr
         [:td [:code "hours"]]
         [:td "Used for hours in dialog header."]]
        [:tr
         [:td [:code "hoursDisplay"]]
         [:td "Added to the dialog hours are displayed."]]
        [:tr
         [:td [:code "input"]]
         [:td "Used for Input element that opens the picker."]]
        [:tr
         [:td [:code "knob"]]
         [:td "Used for the knob of the hand."]]
        [:tr
         [:td [:code "minutes"]]
         [:td "Used for minutes in dialog header."]]
        [:tr
         [:td [:code "minutesDisplay"]]
         [:td "Added to the dialog minutes are displayed."]]
        [:tr
         [:td [:code "number"]]
         [:td "Each of the numbers in the clock's face."]]
        [:tr
         [:td [:code "placeholder"]]
         [:td "Placeholder for the clock inside the dialog (inner wrapper)."]]
        [:tr
         [:td [:code "pm"]]
         [:td "PM label in dialog header when mode is AM/PM."]]
        [:tr
         [:td [:code "pmFormat"]]
         [:td "Added to the dialog when the selected format is PM."]]
        [:tr
         [:td [:code "separator"]]
         [:td "Is the " [:code ":"] " separator between hours and minutes in dialog header."]]
        [:tr
         [:td [:code "small"]]
         [:td "Added to the knob when no round number is selected."]]]]]]))

(defmethod layout/pages :time-picker [_]
  [view])
