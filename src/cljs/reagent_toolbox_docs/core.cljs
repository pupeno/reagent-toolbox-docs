;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            reagent-toolbox-docs.components.app-bar
            reagent-toolbox-docs.components.autocomplete
            reagent-toolbox-docs.components.avatar
            reagent-toolbox-docs.components.button
            reagent-toolbox-docs.components.card
            reagent-toolbox-docs.components.checkbox
            reagent-toolbox-docs.components.drawer
            reagent-toolbox-docs.components.dropdown
            reagent-toolbox-docs.components.font-icon
            reagent-toolbox-docs.components.input
            reagent-toolbox-docs.components.link
            reagent-toolbox-docs.components.navigation
            reagent-toolbox-docs.components.progress-bar
            reagent-toolbox-docs.components.radio-buttons
            reagent-toolbox-docs.components.reagent-switch
            reagent-toolbox-docs.components.slider
            reagent-toolbox-docs.components.snackbar
            reagent-toolbox-docs.components.tabs
            reagent-toolbox-docs.components.time-picker
            [reagent-toolbox-docs.db :as db]
            [reagent-toolbox-docs.routing :as routing]
            [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.config :as config]))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [layout/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (enable-console-print!)
  (re-frame/dispatch-sync [:initialize-db])
  (routing/start!)
  (mount-root))
