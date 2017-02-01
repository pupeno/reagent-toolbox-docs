;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.views
  (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div "Hello from " @name])))
