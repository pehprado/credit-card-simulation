(ns credit-card-simulation.core
  (:require [credit-card-simulation.db :as cc.db]
            [credit_card_simulation.logic :as cc.logic]))

(defn all-credit-cards []
  (->>
    (cc.db/all-orders)
    (cc.logic/get-all-names-and-cards)))

(defn all-orders-by-user []
  (->>
    (cc.db/all-orders)
    (cc.logic/get-all-name-and-purchases)))

(defn total-value-by-category []
  (->>
    (cc.db/all-orders)
    (cc.logic/get-purchase-by-category)
    (cc.logic/total-price-by-category)))

(println "All orders" (cc.db/all-orders))
(println "All credit cards" (all-credit-cards))
(println "All orders by users" (all-orders-by-user))
(println "Total value by category" (total-value-by-category))