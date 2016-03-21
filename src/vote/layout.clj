(ns vote.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5 {:ng-app "myApp" :lang "en"}
         [:head
          [:title title]
          (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css")
          (include-js "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js")]
          [:body
           [:div {:class "container"} content ]]))