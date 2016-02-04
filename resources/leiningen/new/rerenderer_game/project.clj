(defproject {{name}} "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [org.clojure/core.async "0.2.371"]
                 [rerenderer "0.2.0"]]
  :plugins [[lein-cljsbuild "1.1.2"]
            [lein-figwheel "0.5.0-6"]]
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
