(ns caas.models.entry
  (:use korma.db)
  (:require [korma.core :as db]))

(defdb development
       (mysql { :db "caas_development.db"
               :classname "org.sqlite.JDBC"
               :subprotocol "sqlite"
               :subname "caas_development.db"
               :username "root"
               :password "" }))

(db/defentity entries)

(def base
  "Basic record query for entries"
  (-> (db/select* entries)
        (db/fields :title :body :created_at)
        (db/order :created_at)))

(defn all []
  (db/exec base))

(defn where
  "Apply lookup criteria to our base query"
  [criteria]
  (-> base (db/where criteria)))

(defn find-by-id
  "Finds an entry by id"
  [id]
  (first (db/exec (where { :id id }))))

; (defn publish!
;   "Marks an entry as published"
;   [entry]
;   (-> (db/update entries
;         (set-fields { :published true }
;         (find (:id entry))))))

; (defn published []
;   "Returns published entries"
;   (db/exec (where {:status "published"})))
