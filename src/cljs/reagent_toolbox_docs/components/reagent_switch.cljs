;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.reagent-switch
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view []
  (fn []
    [:article
     [:h1 "Switch"]

     [:p "On/off switches toggle the state of a single settings option. The option that the "
      "switch controls, as well as the state it's in, should be made clear from the "
      "corresponding inline label. Switches take on the same visual properties of the radio "
      "button."]

     [ui/display-and-eval-code "
(defn switch-test []
  (let [flip (fn [a k] (swap! a update k not))
        switches (reagent.ratom/atom {:switch1 true :switch2 false :switch3 true})]
    (fn []
      [:section
       [reagent-toolbox.core/switch {:checked (@switches :switch1)
                                     :label \"Push notifications\"
                                     :on-change #(flip switches :switch1)}]
       [reagent-toolbox.core/switch {:checked (@switches :switch2)
                                     :label \"Mail notifications\"
                                     :on-change #(flip switches :switch2)}]
       [reagent-toolbox.core/switch {:checked (@switches :switch3)
                                     :disabled true
                                     :label \"Nothing, thanks\"
                                     :on-change #(flip switches :switch3)}]])))

[switch-test]"]

     [:p "This component can be styled by context providing a theme with the key " [:code "RTSwitch"] "through the "
      "theme provider."]

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
         [:td [:code "checked"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, the switch will be enabled."]]
        [:tr
         [:td [:code "class-name"]]
         [:td [:code "string"]]
         [:td [:code "\"\""]]
         [:td "Sets a class to give custom styles to the switch."]]
        [:tr
         [:td [:code "disabled"]]
         [:td [:code "boolean"]]
         [:td [:code "false"]]
         [:td "If true, component will be disabled."]]
        [:tr
         [:td [:code "label"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string to use for the floating label element."]]
        [:tr
         [:td [:code "name"]]
         [:td [:code "string"]]
         [:td]
         [:td "The text string used as name of the input."]]
        [:tr
         [:td [:code "on-blur"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when when the switch is blurred."]]
        [:tr
         [:td [:code "on-change"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the component's value changes."]]
        [:tr
         [:td [:code "on-focus"]]
         [:td [:code "function"]]
         [:td]
         [:td "Callback function that is fired when the switch is focused."]]]]]

     [:section
      [:h2 "Theme"]

      [:table
       [:thead
        [:tr
         [:th "Name"]
         [:th "Description"]]]
       [:tbody
        [:tr
         [:td [:code "disabled"]]
         [:td "Used for the root element if the component is disabled."]]
        [:tr
         [:td [:code "field"]]
         [:td "Used for the root element if the component is not disabled."]]
        [:tr
         [:td [:code "input"]]
         [:td "Used for the input element."]]
        [:tr
         [:td [:code "off"]]
         [:td "Used for a wrapper around the thumb if checked is false."]]
        [:tr
         [:td [:code "on"]]
         [:td "Used for a wrapper around the thumb if checked is true."]]
        [:tr
         [:td [:code "ripple"]]
         [:td "Used for the ripple inside the switch."]]
        [:tr
         [:td [:code "text"]]
         [:td "Used for the text label element."]]
        [:tr
         [:td [:code "thumb"]]
         [:td "Used for the thumb element."]]]]]]))

(defmethod layout/pages :reagent-switch [_]
  [view])
