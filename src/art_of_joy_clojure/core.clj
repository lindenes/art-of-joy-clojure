(ns art-of-joy-clojure.core
  (:use ring.adapter.jetty)
  (:require [aero.core :refer [read-config]])
  (:use art-of-joy-clojure.application.route))

(defn -main[]
  (let [http_config (:http (read-config "resources/config.edn"))]
    (run-jetty get_routes {:host (:host http_config)
                           :port (Integer. (:port http_config))
                           :max-threads (Integer. (:max-thread http_config))})
    )
  )