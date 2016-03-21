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
            [vote.contents :as contents]))

(defroutes app-routes
  (GET "/" [] (layout/application "Home" (contents/index)))
  (GET "/about" [] (layout/application "About" (contents/about)))
  (ANY "*" [] (route/not-found (layout/application "Page Not Found" (contents/not-found)))))

(def app
  (handler/site app-routes))

(run-jetty #'app {:port 4000})