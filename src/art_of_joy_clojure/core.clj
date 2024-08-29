(ns art-of-joy-clojure.core
  (:use ring.adapter.jetty)
  (:use art-of-joy-clojure.application.route))

(defn -main[]
  (run-jetty get_routes {:host "localhost"
                      :port 3000
                      :max-threads 12})
  )