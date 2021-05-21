(ns credit_card_simulation.logic
  (:require [datomic.api :as d]))

(defn all-purchases [db]
  (d/q '[:find ?user-name ?card-number ?price ?establishment ?category
         :keys user card-number price establishment category
         :with ?purchase
         :where [?purchase :purchase/price ?price]
                [?purchase :purchase/establishment ?establishment]
                [?purchase :purchase/category ?category]
                [?purchase :purchase/card ?card]
                [?card     :card/number ?card-number]
                [?card     :card/user   ?user]
                [?user     :user/name   ?user-name]]
       db))