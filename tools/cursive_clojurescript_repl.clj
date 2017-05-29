;;;; Copyright © 2017 Flexpoint Tech Ltd.

;;;; File to run a ClojureScript REPL in Cursive: https://github.com/bhauman/lein-figwheel/wiki/Running-figwheel-in-a-Cursive-Clojure-REPL

(use 'figwheel-sidecar.repl-api)
(start-figwheel!) ;; <-- fetches configuration
(cljs-repl)
