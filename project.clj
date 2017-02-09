;;;; Copyright © 2017 Flexpoint Tech Ltd

(defproject tech.dashman/reagent-toolbox-playground "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [cljsjs/react-with-addons "15.2.1-0"]
                 [reagent "0.6.0" :exclusions [cljsjs/react]]
                 [re-frame "0.9.1"]
                 [com.domkm/silk "0.1.2"]
                 [kibu/pushy "0.3.6"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [environ "1.1.0"]
                 [replumb "0.2.4"]
                 [tech.dashman/reagent-toolbox "0.1.0-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-figwheel "0.5.9"]
            [deraen/lein-sass4clj "0.3.0"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js"
                                    "resources/public/css"
                                    "target"]

  :figwheel {:css-dirs       ["resources/public/css"]
             :server-logfile "log/figwheel-logfile.log"
             :ring-handler   reagent-toolbox-playground.core/app}

  :cljsbuild {:builds {:app {:source-paths ["src/cljs"]
                             :figwheel     {:on-jsload "reagent-toolbox-playground.core/mount-root"}
                             :compiler     {:main                 reagent-toolbox-playground.core
                                            :output-to            "resources/public/js/app.js"
                                            :output-dir           "resources/public/js"
                                            :asset-path           "js/"
                                            :source-map-timestamp true
                                            :preloads             [devtools.preload]
                                            :external-config      {:devtools/config {:features-to-install :all}}}}}}

  :sass {:source-paths ["src/assets"]
         :target-path  "resources/public/css"
         :source-map   true}

  :profiles {:dev  {:dependencies [[figwheel-sidecar "0.5.9"]
                                   [binaryage/devtools "0.8.2"]
                                   [com.cemerick/piggieback "0.2.1"]
                                   [org.clojure/tools.nrepl "0.2.12"]]
                    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}
             :prod {:cljsbuild {:builds {:app {:optimizations   :advanced
                                               :closure-defines {goog.DEBUG false}
                                               :pretty-print    false}}}}})
