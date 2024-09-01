(ns art-of-joy-clojure.application.endpoint
  (:require [clojure.data.json :as json])
  (:require [art-of-joy-clojure.application.service.handler :as handler]))

(defn util_endpoint [request]
  (case
    [(:uri request) (:request-method request)]
      ["/version" :get] {:headers {"Content-Type" "application/json"}
                         :body "0.0.1"}
      ["/healthcheck" :get] {:headers {"Content-Type" "application/json"}
                             :body  ( json/write-str {:ok true} ) }
    )
  )

(defn category_endpoint [request]
  (case [(:uri request) (:request-method request)]
      ["/category" :get] (handler/get-category)
      ["/brand" :get] (handler/get-brand)
    )
  )