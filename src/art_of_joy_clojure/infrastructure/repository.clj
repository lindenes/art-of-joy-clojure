(ns art-of-joy-clojure.infrastructure.repository
  (:require [honey.sql :as sql]
            [next.jdbc :as jdbc])
  (:import [com.zaxxer.hikari HikariConfig HikariDataSource]))

(def db-spec
  {:jdbcUrl "jdbc:postgresql://109.107.189.134:5432/artofjoy"
   :username "artofjoyuser"
   :password "artofjoy"
   :maximumPoolSize 10})

;; Создание HikariConfig с использованием метода .set
(defn create-hikari-config [db-spec]
  (let [config (HikariConfig.)]
    (.setJdbcUrl config (:jdbcUrl db-spec))
    (.setUsername config (:username db-spec))
    (.setPassword config (:password db-spec))
    (.setMaximumPoolSize config (:maximumPoolSize db-spec))
    (.addDataSourceProperty config "logger" "com.zaxxer.hikari.slf4j.Slf4jLogger")
    config))

(def hikari-config (create-hikari-config db-spec))
(def datasource (HikariDataSource. hikari-config))

(def sqlmap {:select [:id :name]
             :from   [:category]})

(def query (sql/format sqlmap))

(defn fetch-data []
  (jdbc/execute! datasource query))
