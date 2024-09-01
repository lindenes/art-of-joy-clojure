(ns art-of-joy-clojure.infrastructure.category-table
  (:require [honey.sql :as sql]
            [next.jdbc :as jdbc])
  (:use [art-of-joy-clojure.configuration]))

(defn get-category []
  (jdbc/execute! datasource (sql/format{:select [:id :name]
                                        :from   [:category]})
                 )
  )
(defn get-brand []
  (jdbc/execute! datasource (sql/format{:select [:id :name]
                                        :from   [:brand]})
                 )
  )