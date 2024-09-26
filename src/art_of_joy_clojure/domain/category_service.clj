(ns art-of-joy-clojure.domain.category_service
  (:require [art-of-joy-clojure.infrastructure.category-table :as category-table]))

(defn get-category []
  (category-table/get-category))

(defn get-brand []
  (category-table/get-brand))
