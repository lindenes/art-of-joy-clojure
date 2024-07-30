(ns art-of-joy-clojure.core
  (:use ring.adapter.jetty)
  (:require [ring.middleware.content-type :refer [wrap-content-type]])
  (:use art-of-joy-clojure.application.handler))

(defn -main[]
  (run-jetty handler {:host "localhost"
                      :port 3000
                      :max-threads 8}))