(ns art-of-joy-clojure.infrastructure.repository
  (:require [honey.sql :as sql]
            [next.jdbc :as jdbc])
  (:use [art-of-joy-clojure.configuration]))

(def sqlmap {:select [:id :name]
             :from   [:category]})

(def query (sql/format sqlmap))

(defn fetch-data []
  (jdbc/execute! datasource query))
