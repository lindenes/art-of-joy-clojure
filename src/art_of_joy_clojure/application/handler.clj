(ns art-of-joy-clojure.application.handler
  (:require [ring.util.response :refer [not-found]])
  (:require [clojure.data.json :as json]))

(def badRequest {:status  400} )

(defn handler [request]
  (cond
    (= (:uri request) "/version") {:body "0.0.1"}
    (= (:uri request) "/healthcheck") {:headers {"Content-Type" "application/json"}
                                       :body  ( json/write-str {:ok true} ) }
    :else (not-found (json/write-str {:error "page not found"} ) ) ))