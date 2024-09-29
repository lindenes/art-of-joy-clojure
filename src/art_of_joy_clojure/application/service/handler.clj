(ns art-of-joy-clojure.application.service.handler
  (:require [clojure.data.json :as json])
  (:require [art-of-joy-clojure.domain.category_service :as category-service]))

(defn get-category []
  (let [categories (map
                     (fn [category] (-> category
                                        (dissoc :subcategories)
                                        (assoc :subCategories (:subcategories category) )
                                        ))
                     (category-service/get-category))]
    {:headers {"Content-Type" "application/json"}
     :body (json/write-str categories)}
    )
  )

(defn get-brand []
  {:headers {"Content-Type" "application/json"}
   :body (json/write-str (category-service/get-brand))}
  )
