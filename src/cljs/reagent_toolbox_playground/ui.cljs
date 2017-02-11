;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.ui
  (:require [reagent.core :as reagent]
            cognitect.transit
            [replumb.core :as replumb]
            [reagent-codemirror.core :as codemirror]))

(defn display-and-eval-code [initial-code]
  (let [code (reagent.ratom/atom (clojure.string/trim initial-code))
        result (reagent.ratom/atom nil)
        eval-code->result! (fn [] (replumb/read-eval-call {:warning-as-error   true
                                                           :no-pr-str-on-value true
                                                           :preloads           {:require '#{reagent-toolbox.core
                                                                                            reagent.ratom}}}
                                                          (fn [{:keys [value success? form warning error]}]
                                                            (if success?
                                                              (reset! result value)
                                                              (do
                                                                (println error)
                                                                (reset! result (.-message (.-cause error))))))
                                                          @code))]
    (eval-code->result!)
    (fn []
      [:div
       [codemirror/codemirror {:value     @code
                               :on-change (fn [doc change]
                                            (reset! code (.getValue doc))
                                            (eval-code->result!))}]
       @result])))
