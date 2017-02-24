;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.input
  (:require [reagent-toolbox-docs.ui :as ui]
            [reagent-toolbox-docs.layout :as layout]))


(defn view []
  (fn []
    [:article
     [:h1 "Input"]
     [:p "Although we are calling them Inputs they actually correspond to Material Design "
      [:a {:href "https://material.io/guidelines/components/text-fields.html"} "Text fields"]
      ". It allows a user to input text and it's the base for other components like the autocomplete."]
     [ui/display-and-eval-code "
(defn input-test []
  (let [name (reagent.ratom/atom \"\")
        label (reagent.ratom/atom \"\")
        multiline (reagent.ratom/atom \"\")
        email (reagent.ratom/atom \"\")
        phone (reagent.ratom/atom \"\")
        hint (reagent.ratom/atom \"\")
        error (reagent.ratom/atom \"\")]
    (fn []
      [:div
       [:p \"Value: \" (pr-str @name)]
       [reagent-toolbox.core/input {:label      \"Name\"
                                    :name       \"name\"
                                    :type       \"text\"
                                    :value      @name
                                    :max-length 16
                                    :on-change  (fn [value event] (reset! name value))}]

       [:p \"Value: \" (pr-str @label)]
       [reagent-toolbox.core/input {:hint       \"With Hint, no label\"
                                    :name       \"name\"
                                    :type       \"text\"
                                    :value      @label
                                    :max-length 16
                                    :on-change  (fn [value event] (reset! label value))}]

       [:p \"Value: \" [:i \"none\"]]
       [reagent-toolbox.core/input {:label    \"Disabled field\"
                                    :disabled true}]

       [:p \"Value: \" (pr-str @multiline)]
       [reagent-toolbox.core/input {:label      \"Multiline\"
                                    :type       \"text\"
                                    :value      @multiline
                                    :multiline  true
                                    :max-length 20
                                    :on-change  (fn [value event] (reset! multiline value))}]


       [:p \"Value: \" (pr-str @email)]
       [reagent-toolbox.core/input {:label     \"Email address\"
                                    :type      \"email\"
                                    :value     @email
                                    :icon      \"email\"
                                    :on-change (fn [value event] (reset! email value))}]


       [:p \"Value: \" (pr-str @phone)]
       [reagent-toolbox.core/input {:label     \"Phone\"
                                    :type      \"tel\"
                                    :value     @phone
                                    :icon      \"phone\"
                                    :on-change (fn [value event] (reset! phone value))}]

       [:p \"Value: \" (pr-str @hint)]
       [reagent-toolbox.core/input {:label     \"Required Field\"
                                    :hint      \"With Hint\"
                                    :type      \"text\"
                                    :required  true
                                    :icon      \"share\"
                                    :value     @hint
                                    :on-change (fn [value event] (reset! hint value))}]

       [:p \"Value: \" (pr-str @error)]
       [reagent-toolbox.core/input {:label     \"Error\"
                                    :hint      \"With Hint\"
                                    :type      \"text\"
                                    :value     @error
                                    :on-change (fn [value event] (reset! error value))
                                    :error     [:span \"Error!! \" [:a {:href     \"#!\"
                                                                      :on-click (fn [e]
                                                                                  (.preventDefault e)
                                                                                  (println \"Some help\"))}
                                                                  \"?\"]]}]])))

[input-test]"]
     [:p "If you want to provide a theme via context, the component key is " [:code "RTInput"] "."]]))

(defmethod layout/pages :input [_]
  [view])
