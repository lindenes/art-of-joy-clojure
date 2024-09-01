(defproject art-of-joy_clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"],
                 [org.clojure/data.json "2.5.0"],
                 [com.github.seancorfield/honeysql "2.6.1147"],
                 [org.postgresql/postgresql "42.7.2"],
                 [com.github.seancorfield/next.jdbc "1.3.939"],
                 [com.zaxxer/HikariCP "5.1.0"],
                 [org.slf4j/slf4j-api "2.0.12"],
                 [ch.qos.logback/logback-classic "1.5.7"],
                 [ch.qos.logback/logback-core "1.5.7"],
                 [aero "1.1.6"]]
  :repl-options {:init-ns art-of-joy-clojure.core}
  :main art-of-joy-clojure.core)
