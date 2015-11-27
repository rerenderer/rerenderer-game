(defproject {{name}} "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [rerenderer "0.1.0"]
                 [figwheel-sidecar "0.4.1"]
                 [com.cemerick/piggieback "0.2.1"]
                 [org.clojure/tools.nrepl "0.2.10"]]
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-figwheel "0.4.1"]
            #_ [lein-rerenderer "0.1.0-SNAPSHOT"]]
  :source-paths ["src"]
  :cljsbuild {:builds {:main {:source-paths ["src"]
                              :figwheel {:websocket-host "localhost"}
                              :compiler {:output-to "resources/public/compiled/main.js"
                                         :output-dir "resources/public/compiled"
                                         :asset-path "/compiled"
                                         :source-map true
                                         :main "{{name}}.core"
                                         :optimizations :none
                                         :pretty-print false}}}})
