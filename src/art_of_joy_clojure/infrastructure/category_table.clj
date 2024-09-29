(ns art-of-joy-clojure.infrastructure.category-table
  (:require [next.jdbc :as jdbc])
  (:use [art-of-joy-clojure.configuration]))

(defn get-category []
  (let [categories (jdbc/execute! datasource [
                             "select c.name, c.id,
                              COALESCE(
                                  json_agg(
                                      json_build_object(
                                         'id', s.id, 'name', s.name, 'categoryId', s.category_id
                                      )
                                  ), '[]'::json
                              ) as subCategories
                              from category c
                              left join subcategory s on s.id = c.id
								              group by c.name, c.id;"
                             ]
                 )]
    (map (fn [category]
           (assoc category :subcategories (.getValue (:subcategories category)) )
           ) categories)
  ))

(defn get-brand []
  (jdbc/execute! datasource ["select id, name from brand"]))
