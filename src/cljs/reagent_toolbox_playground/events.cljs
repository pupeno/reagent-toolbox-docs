;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.events
  (:require [re-frame.core :as re-frame]
            [reagent-toolbox-playground.db :as db]))

(re-frame/reg-event-db :initialize-db
  (fn [_ _]
    db/default-db))
