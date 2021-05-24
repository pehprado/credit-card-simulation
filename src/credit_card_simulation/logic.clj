(ns credit_card_simulation.logic
  (:require [datomic.api :as d]))

(defn all-purchases [db]
  (d/q '[:find ?user-name ?card-number ?price ?establishment ?category
         :keys user card-number price establishment category
         :with ?purchase
         :where [?purchase :purchase/price         ?price]
                [?purchase :purchase/establishment ?establishment]
                [?purchase :purchase/category      ?category]
                [?purchase :purchase/card          ?card]
                [?card     :card/number            ?card-number]
                [?card     :card/user              ?user]
                [?user     :user/name              ?user-name]]
       db))

(defn who-purchased-more [db]
  (->> (all-purchases db)
       (group-by :user)
       (map (fn [[user purchase]]
              {:user-name user
               :purchase-count (count purchase)}))
       (sort-by :purchase-count >)
       first))

(defn most-expensive-purchase [db]
  (->> (all-purchases db)
       (sort-by :price >)
       first))

;(defn purchases-by-users [db]
;  (d/q '[:find (pull ?user [:user/name {:card/_user [:card/number]
;                                        :purchase/_card [:purchase/price :purchase/establishment :purchase/category]}])
;         :where [?user :user/cpf ?cpf]]
;       db))

(defn purchases-by-users [db]
  (d/q '[:find (pull ?e [* {:card/_user [:card/number
                                         {:purchase/_card [:purchase/price :purchase/establishment :purchase/category]}]}])
         :where [?e :user/cpf ?cpf]] db))

;(defn users-who-never-purchases [db]
;  (->> (purchases-by-users db)
;       (filter (fn [arr]
;                 (println "FILTER 1" arr)
;                 (filter (fn [obj]
;                           (println "FILTER 2" obj)
;                           (filter (fn [card]
;                                     (println "FILTER 3" card)
;                                     (< (count (:purchase/_card card))))
;                                   (:card/_user obj))
;                           ) arr)))))



(defn users-who-never-purchases [db]
  (->> (purchases-by-users db)
       (filter (fn [arr]
                 (first arr)))
       (filter (fn [arr]
                 ))))