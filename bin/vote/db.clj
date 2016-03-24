(ns vote.db
  (:require [clojure.java.jdbc :refer :all]))

(def first-item
  {:name "Read books about Clojure"
   :todo 1
   :done 0
   })

(def second-item
  {:name "Build voter engagement, restore election process"
   :todo 1
   :done 0
   })

(def third-item
  {:name "Take the dog for a walk"
   :todo 1
   :done 0
   })

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"
   })

(defn create-db []
  (try (db-do-commands db
                       (create-table-ddl :list
                                         [:id :integer
                                          :primary :key
                                          :autoincrement]
                                         [:name :text]
                                         [:todo :integer]
                                         [:done :integer]))
       (catch Exception e (println e))))

(create-db)
(insert! db :list first-item second-item third-item)

(def first-thing
  (query db ["select name from list where id=?" 1]))
(def second-thing
  (query db ["select name from list where id=?" 2]))
(def third-thing
  (query db ["select name from list where id=?" 3]))

;(defn create [new-item] (insert! db :list new-item))