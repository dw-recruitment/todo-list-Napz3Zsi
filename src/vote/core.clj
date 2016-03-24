(ns vote.core
(:use ring.adapter.jetty)
  (:use ring.util.response)
  (:use compojure.core)
  (:use hiccup.page hiccup.element)
  (:require [ring.middleware.resource :as resource]
            [ring.middleware.file-info :as file-info]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [vote.core :as core]
            [vote.layout :as layout]
            [vote.contents :as contents]
            [vote.db :as db]
            [clojure.string :as str]
            [ring.util.response :as ring]))

;(defn create
;  [newitem]
;  (when-not (str/blank? newitem)
;    (db/create newitem))
;  (ring/redirect "/"))

(defroutes app-routes
  (GET "/" [] (layout/application "Home" (contents/index)))
  (GET "/about" [] (layout/application "About" (contents/about)))
;  (POST "/" [newitem] (create newitem))
  (ANY "*" [] (route/not-found (layout/application "Page Not Found" (contents/not-found))))
  (route/resources "/"))

(def app
  (handler/site app-routes))

(run-jetty #'app {:port 4000})