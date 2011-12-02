(ns caas.server
  (:require [noir.server :as server]))

(server/load-views "src/caas/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'caas})))

