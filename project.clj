(defproject caas "0.1.0-SNAPSHOT"
            :description "Clojure as a Service example"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [korma "0.2.1"]
                           [noir "1.2.1"]
                           [sqlitejdbc "0.5.6"]]
            :main caas.server)
