;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.avatar
  (:require [reagent-toolbox-docs.layout :as layout]))

(defmethod layout/pages :avatar [_]
  (fn [_]
    [:article
     [:h1 "Avatar"]]))
