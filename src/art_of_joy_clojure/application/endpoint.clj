(ns art-of-joy-clojure.application.endpoint
  (:require [clojure.data.json :as json])
  (:use art-of-joy-clojure.infrastructure.repository))

(defn util_endpoint [request]
  (cond
    (= (:uri request) "/version") {:headers {"Content-Type" "application/json"}
                                   :body "0.0.1"}
    (= (:uri request) "/healthcheck") {:headers {"Content-Type" "application/json"}
                                       :body  ( json/write-str {:ok true} ) }
    )
  )

(defn category_endpoint [request]
  (cond
    (= (:uri request) "/category"){:headers {"Content-Type" "application/json"}
                                   :body (json/write-str (fetch-data))
                                   }
    )
  )