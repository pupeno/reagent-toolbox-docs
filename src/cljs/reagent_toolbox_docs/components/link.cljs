;;;; Copyright © 2017 Flexpoint Tech Ltd

(ns reagent-toolbox-docs.components.link
  (:require [reagent-toolbox-docs.layout :as layout]
            [reagent-toolbox-docs.ui :as ui]))

(defn view
  []
  (fn []
    [:article
     [:h1 "Link"]
     [:p "The link is a very simple component that acts mostly as a wrapper for the HTML anchor. "
      "It's not included in Material Design Specification but we provide it as an easy way to "
      "create links with icons and counters."]

     [ui/display-and-eval-code
      "(defn link-text
         []
         (fn []
           [:div
            [reagent-toolbox.core/link {:active true
                                        :href \"/link\"
                                        :label \"Work\"
                                        :count 4
                                        :icon \"business\"}]]))
       [link-text]"]]))

(defmethod layout/pages :link [_]
  [view])
