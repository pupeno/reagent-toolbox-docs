;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.dropdown
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn dropdown-test
  []
  (let [countries [{:value 'EN-gb' :label 'England'}
                   {:value 'ES-es' :label 'Spain'}
                   {:value 'TH-th' :label 'Thailand'}
                   {:value 'EN-en' :label 'USA'}]
        state (reagent.ratom/atom {:value 'ES-es'})]
    [reagent-toolbox.core/dropdown {:auto true
                                    :on-change #(swap! state assoc :value %)
                                    :source countries
                                    :value (@state :value)}]))
(defn view
  []
  (fn []
    [:article
     [:h1 "Dropdown"]
     [:p "The Dropdown selects an option between multiple selections. The element displays "
      "the current state and a down arrow. When it is clicked, it displays the list of "
      "available options."]

     [ui/display-and-eval-code
      "(defn dropdown-test
         []
         (let [countries [{:value \"EN-gb\" :label \"England\"}
                          {:value \"ES-es\" :label \"Spain\"}
                          {:value \"TH-th\" :label \"Thailand\"}
                          {:value \"EN-en\" :label \"USA\"}]
               state (reagent.ratom/atom {:value \"ES-es\"})]
           (fn []
             [:div
              [:p \"Value: \" (pr-str @state)]
              [reagent-toolbox.core/dropdown {:auto true
                                              :on-change #(swap! state assoc :value %)
                                              :source countries
                                              :value (:value @state)}]])))

       [dropdown-test]"]]))

(defmethod layout/pages :dropdown [_]
  [view])
