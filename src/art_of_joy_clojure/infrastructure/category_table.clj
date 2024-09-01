(ns art-of-joy-clojure.infrastructure.category-table
  (:require [honey.sql :as sql]
            [next.jdbc :as jdbc])
  (:use [art-of-joy-clojure.configuration]))

(defn get-category []
  (jdbc/execute! datasource (sql/format {:select [[:c.id :id]
                                                  [:c.name :name]
                                                  [:sc.id :subcategory_id]
                                                  [:sc.name :subcategory_name]
                                                  [:sc.category_id :category_id]]
                                         :join   [[:subcategory :sc] [:= :c.id :sc.category_id]]
                                         :from   [[:category :c]]})
                 )
  )
(defn get-brand []
  (jdbc/execute! datasource (sql/format{:select [:id :name]
                                        :from   [:brand]})
                 )
  )