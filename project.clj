(defproject vote "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
   :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.2.0-SNAPSHOT"]
                 [hiccup "1.0.5"]
                 [org.clojure/java.jdbc "0.4.2"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [org.xerial/sqlite-jdbc "3.8.11.2"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler vote.core/app})