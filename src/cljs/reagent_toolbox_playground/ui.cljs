;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.ui
  (:require [replumb.core :as replumb]))

(defn display-and-eval-code [initial-code]
  (let [code (reagent.ratom/atom (clojure.string/trim initial-code))
        result (reagent.ratom/atom nil)
        eval-code->result! (fn [] (replumb/read-eval-call {:warning-as-error   true
                                                           :no-pr-str-on-value true
                                                           :preloads           {:require '#{[reagent-toolbox.core :as rt]
                                                                                            [reagent.ratom :as ratom]}}}
                                                          (fn [{:keys [value success? form warning error]}]
                                                            ;(println "Evaluated" initial-code)
                                                            (if success?
                                                              (reset! result value)
                                                              (do
                                                                (println error)
                                                                (reset! result (.-message (.-cause error))))))
                                                          @code))]
    (eval-code->result!)
    (fn []
      [:div
       [:pre "(ns example\n  (:require [[reagent-toolbox.core :as rt]\n             [reagent.ratom :as ratom]])\n"]
       [:textarea.code {:on-change (fn [arg]
                                     (reset! code (.-value (.-target arg)))
                                     (eval-code->result!))
                        :value     @code}]
       [:br]
       @result])))
