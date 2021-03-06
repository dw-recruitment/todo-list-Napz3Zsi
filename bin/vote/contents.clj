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
      [:h2 {:class "text-danger"}"UNDER CONSTRUCTION" ]]        
   [:ul {:class "text-center col-sm-7" :style "font-size: 1.8em; margin-top: 80px; list-style: none; max-width: 50%"}
     [:li (vals (first db/first-thing)) ]
     [:li (vals (first db/second-thing)) ]
     [:li (vals (first db/third-thing)) ]]
       [:div {:class "col-sm-offset-5 col-sm-7"}
        [:h1 {:class "text-info"} "Create an item"]]
         [:div {:class "col-sm-offset-5 col-lg-7"}
          (form-to {:class "form-inline"} [:post "/"] 
           (text-field {:class "form-control" :style "min-width: 300px;" :placeholder "Type item here"} "newitem")
         (submit-button  {:type "submit" :class "btn btn-primary"} "Submit"))]
        ])

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
