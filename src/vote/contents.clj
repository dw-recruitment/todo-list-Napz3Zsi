(ns vote.contents
  (:use [hiccup.form]
        [hiccup.element :only (link-to)])
  (:require [vote.db :as db]
            [clojure.string :as str]))

(defn index []
  [:div {:id "content" :class "row"}
   [:div {:class "col-sm-5"}
    [:img {:src "http://c71123.com/img/jk_keller-under_construction.gif"}]]
   [:div {:class "col-sm-7 text-center"}
    [:h1 {:class "text-info"} "Web Applicationing Development Using Clojure"]
      [:h2 {:class "text-danger"}"UNDER CONSTRUCTION"]]        
       [:ul {:class "text-center col-sm-7" :style "font-size: 2em; margin-top: 80px; list-style: none; max-width: 50%"}
         [:li (vals (first db/first-thing)) ]
         [:li (vals (first db/second-thing)) ]
         [:li (vals (first db/third-thing)) ]
          ]])

(defn about []
  [:div {:id "content" :class "row text-center"}
   [:h1 {:class "text-info"} "About This Project"]
      [:p "This is a To Do List web application built with Clojure."]
      [:p "I am performing this test for the fantastic company, Democracy Works!"]
   ])

(defn not-found []
  [:div
   [:h1 {:class "info-warning"} "Page Not Found"]
   [:p "I swear I saw it around here somewhere. "]
   (link-to {:class "btn btn-info"} "/" "Take me back to the Home Page")])
