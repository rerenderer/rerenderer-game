(ns {{name}}.core
  (:require-macros [cljs.core.async.macros :refer [go-loop go]])
  (:require [cljs.core.match :refer-macros [match]]
            [cljs.core.async :refer [<!]]
            [rerenderer.core :refer [init!]]
            [rerenderer.primitives :as primitives]))

(enable-console-print!)

(def colors {:red [255 255 0 0]
             :green [255 0 255 0]
             :blue [255 0 0 255]})

(defn root-view
  [state]
  (primitives/rectangle {:width 200
                         :height 200
                         :color (-> state :color colors)
                         :x 100
                         :y 100}))

(defn change-color
  [color]
  (condp = color
    :red :green
    :green :blue
    :blue :red))

(defn event-handler
  [event-ch state-atom _]
  (go-loop []
    (match (<! event-ch)
      [:click _] (swap! state-atom update :color change-color)
      event (println "Unhandled event:" event))
    (recur)))

(def inital-state {:color :red})

(init!
  :root-view root-view
  :event-handler event-handler
  :state inital-state
  :canvas (.getElementById js/document "canvas"))
