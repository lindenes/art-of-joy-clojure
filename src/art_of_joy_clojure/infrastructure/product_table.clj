(ns art-of-joy-clojure.infrastructure.product-table
  (:require [honey.sql :as sql]
            [next.jdbc :as jdbc])
  (:use [art-of-joy-clojure.configuration]))

(defn get-product-by-id [id]
  (jdbc/execute! datasource ["select * from product where id = ?" id]
                 )
  )
