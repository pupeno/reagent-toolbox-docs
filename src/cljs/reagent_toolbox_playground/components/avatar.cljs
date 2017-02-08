;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.components.avatar
  (:require [reagent-toolbox-playground.layout :as layout]))

(defmethod layout/pages :avatar [_]
  (fn [_]
    [:article
     [:h1 "Avatar"]]))