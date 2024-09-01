(ns art-of-joy-clojure.application.service.handler
  (:require [clojure.data.json :as json])
  (:require [art-of-joy-clojure.infrastructure.category-table :as category-table]))

(defn map_category [categories]
  (map (fn [category]
         {:id (:id category) :name (:name category)
          :subcategories (map
                           (fn [sc] {:id (:subcategory/subcategory_id sc) :name (:subcategory/subcategory_name sc) :category_id (:subcategory/category_id sc)})
                           (filter (fn [c] (= (:id category) (:subcategory/category_id c) ))
                                   categories)
                           )
          }
         )
       (keys (group-by (fn [category]{:id (:category/id category) :name (:category/name category)}) categories))
     )
  )

(defn get-category []
  (let [categories (category-table/get-category)]
    {:headers {"Content-Type" "application/json"}
     :body (json/write-str (map_category categories))
     }
    )
  )

(defn get-brand []
  {:headers {"Content-Type" "application/json"}
   :body (json/write-str (category-table/get-brand))}
  )