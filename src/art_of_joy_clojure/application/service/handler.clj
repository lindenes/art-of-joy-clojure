(ns art-of-joy-clojure.application.service.handler
  (:require [clojure.data.json :as json])
  (:require [art-of-joy-clojure.infrastructure.category-table :as category-table]))

(defn get-category []
    {:headers {"Content-Type" "application/json"}
     :body (json/write-str (category-table/get-category))
     }
  )

(defn get-brand []
  {:headers {"Content-Type" "application/json"}
   :body (json/write-str (category-table/get-brand))}
  )