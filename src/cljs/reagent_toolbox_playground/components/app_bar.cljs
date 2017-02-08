;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.components.app-bar
  (:require [reagent-toolbox-playground.layout :as layout]))

(defmethod layout/pages :app-bar [_]
  (fn [_]
    [:article
     [:h1 "App Bar"]]))