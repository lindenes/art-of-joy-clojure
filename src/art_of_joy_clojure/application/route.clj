(ns art-of-joy-clojure.application.route
  (:require [clojure.data.json :as json])
  (:require [ring.util.response :refer [not-found]])
  (:use [art-of-joy-clojure.application.endpoint]))

(defn get_routes [request]
  (or (category_endpoint request)
      (util_endpoint request)
      (not-found (json/write-str {:error "page not found"} ) ))

  )
