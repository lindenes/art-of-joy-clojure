(ns art-of-joy-clojure.configuration
  (:require [aero.core :refer [read-config]])
  (:import [com.zaxxer.hikari HikariConfig HikariDataSource]))

(defn create-hikari-config [db-spec]
  (let [config (HikariConfig.)]
    (.setJdbcUrl config (:url db-spec))
    (.setUsername config (:user db-spec))
    (.setPassword config (:password db-spec))
    (.setMaximumPoolSize config (Integer/parseInt (:max_pool_size db-spec)))
    (.addDataSourceProperty config "logger" "com.zaxxer.hikari.slf4j.Slf4jLogger")
    config))

(def datasource (HikariDataSource.
                  (create-hikari-config (:db (read-config "resources/config.edn")))
                  )
  )