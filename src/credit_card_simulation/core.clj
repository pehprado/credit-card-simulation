(ns credit-card-simulation.core
  (:use clojure.pprint)
  (:require [datomic.api :as d]
            [credit-card-simulation.db :as db]
            [credit-card-simulation.model :as model]
            [credit_card_simulation.logic :as logic]))

(def conn (db/open-connection!))

(db/create-schema! conn)

(def card1 (model/new-card "5413563480092870" "988" 3000M))
(def card2 (model/new-card "5351578058054924" "103" 12000M))
(def card3 (model/new-card "5413563480092870" "308" 2500M))
(pprint @(db/add-card! conn [card1 card2 card3]))

(def carlos (model/new-user "Carlos" "26706992003" "carlos@gmail.com"))
(def ana (model/new-user "Ana" "66273113050" "ana@gmail.com"))
(def amanda (model/new-user "Amanda" "70364819006" "amanda@gmail.com"))
(pprint @(db/add-user! conn [carlos ana amanda]))

(db/set-user-into-card! conn card1 carlos)
(db/set-user-into-card! conn card2 ana)
(db/set-user-into-card! conn card3 amanda)

; Purchases
(def purchase1 (model/new-purchase 261.21M "Pão de Açúcar" "Food"))
(def purchase2 (model/new-purchase 700M "Tok&Stok" "Store"))
(def purchase3 (model/new-purchase 50M "Netflix" "Service"))
(def purchase4 (model/new-purchase 150M "Hering" "Store"))
(def purchase5 (model/new-purchase 35M "Uber" "Service"))
(def purchase6 (model/new-purchase 97.45M "Veloso Bar" "Food"))
(pprint @(db/add-purchase! conn [purchase1 purchase2 purchase3
                                 purchase4 purchase5 purchase6]))
(db/set-card-into-purchase! conn [purchase3 purchase4 purchase6] card1)
(db/set-card-into-purchase! conn [purchase1 purchase2 purchase5] card2)




(println "All purchases" (logic/all-purchases (d/db conn)))

;(db/remove-database!)