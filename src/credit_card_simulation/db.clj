(ns credit-card-simulation.db
  (:require [datomic.api :as d]))

(def db-uri "datomic:dev://localhost:4334/creditcard")

(defn open-connection! []
  (d/create-database db-uri)
  (d/connect db-uri))

(defn remove-database! []
  (d/delete-database db-uri))

(def schema [
             ;Users
             {:db/ident       :user/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity}
             {:db/ident       :user/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :user/cpf
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :user/email
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}

             ;Cards
             {:db/ident       :card/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity}
             {:db/ident       :card/number
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/cvv
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/limit
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}
             {:db/ident       :card/user
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}

             ;Purchases
             {:db/ident       :purchase/id
              :db/valueType   :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique      :db.unique/identity}
             {:db/ident       :purchase/price
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/establishment
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/category
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}
             {:db/ident       :purchase/card
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}])

(defn create-schema! [conn]
  (d/transact conn schema))


(defn add-user! [conn user]
  (d/transact conn user))


(defn add-category! [conn category]
  (d/transact conn category))

; CARD FUNCTIONS
(defn add-card! [conn card]
  (d/transact conn card))

(defn db-adds-user-attribution-into-card
  [card user]
  [[:db/add
   [:card/id (:card/id card)]
   :card/user
   [:user/id (:user/id user)]]])

(defn card-aux [card]
  (:card/id card))

(defn user-aux [user]
  (:user/id user))

(defn set-user-into-card!
  [conn card user]
  (let [to-trasanct (db-adds-user-attribution-into-card card user)]
    (println to-trasanct)
    (d/transact conn to-trasanct)))


; PURCHASE FUNCTIONS
(defn add-purchase! [conn purchase]
  (d/transact conn purchase))

(defn db-adds-card-attribution-into-purchase
  [purchase card]
  (reduce (fn [db-adds purchase]
            (conj db-adds [:db/add
                           [:purchase/id (:purchase/id purchase)]
                           :purchase/card
                           [:card/id (:card/id card)]]))
          []
          purchase))

(defn set-card-into-purchase!
  [conn purchase card]
  (let [to-transact (db-adds-card-attribution-into-purchase purchase card)]
    (d/transact conn to-transact)))