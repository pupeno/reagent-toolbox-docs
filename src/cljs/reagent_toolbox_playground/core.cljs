;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-playground.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            reagent-toolbox-playground.components.app-bar
            reagent-toolbox-playground.components.autocomplete
            reagent-toolbox-playground.components.avatar
            [reagent-toolbox-playground.db :as db]
            [reagent-toolbox-playground.routing :as routing]
            [reagent-toolbox-playground.layout :as layout]
            [reagent-toolbox-playground.config :as config]))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [layout/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (re-frame/dispatch-sync [:initialize-db])
  (routing/start!)
  (mount-root))
