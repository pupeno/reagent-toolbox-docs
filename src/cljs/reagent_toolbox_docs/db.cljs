;;;; Copyright © 2017 Flexpoint Tech Ltd.

(ns reagent-toolbox-docs.db
  (:require [re-frame.core :as re-frame]))

(def default-db
  {:current-rount nil})

(re-frame/reg-event-db :initialize-db
  (fn [_ _]
    default-db))
