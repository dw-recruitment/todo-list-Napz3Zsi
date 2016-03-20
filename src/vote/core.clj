(ns vote.core
(:use ring.adapter.jetty)
  (:use ring.util.response)
  (:use compojure.core)
  (:use hiccup.page hiccup.element)
  (:require [ring.middleware.resource :as resource]
            [ring.middleware.file-info :as file-info]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [vote.core :as core]))

(defn index []
  (html5
    [:html
     [:head
      [:title "Software Developer"]]
     [:body
      [:h1 "Web Applicationing Development Using Clojure"]
      [:h2 "UNDER CONSTRUCTION"]
      [:img {:src "http://c71123.com/img/jk_keller-under_construction.gif"}]
      ]]))

(defroutes app-routes
  (GET "/" [] (index))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(run-jetty #'app {:port 3500})