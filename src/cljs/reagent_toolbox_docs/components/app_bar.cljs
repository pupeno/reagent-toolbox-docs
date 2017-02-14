;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.app-bar
  (:require [reagent-toolbox-docs.layout :as layout]))

(defmethod layout/pages :app-bar [_]
  (fn [_]
    [:article
     [:h1 "App Bar"]]))
