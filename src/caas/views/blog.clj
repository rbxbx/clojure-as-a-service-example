(ns caas.views.blog
  (:use noir.core)
  (:require [caas.models.entry :as entry]
            [caas.models.blog :as blog]
            [noir.response :as response]))

(defpage "/" {}
  (response/json blog/as-json))

(defpage "/entries" {}
  (response/json (entry/all)))

(defpage "/entries/:id" {entry-id :id}
  (if-let [current-entry (entry/find-by-id entry-id)]
    (response/json current-entry)
    (response/status 404 "Entry not Found :(")))

(defpage [:post "/entries"] {:keys [title body]}
  (if-let [new-entry (entry/create { :title title :body body })]
    (response/json new-entry)
    (response/empty)))

; (defpage "/entries/remove/:id" {entry-id :id}
;   (if (entry/delete id)
;     (response/json { :id entry-id })
;     (response/empty)))
