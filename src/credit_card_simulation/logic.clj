(ns credit_card_simulation.logic)

; Generic functions
(defn get-name-and-card [elements]
  {:name (get-in elements [:user :name]) :card (:card elements)})

(defn get-all-names-and-cards [elements]
  (->> elements
       (map get-name-and-card)
       set))

(defn get-name-and-purchase [elements]
  {:name     (get-in elements [:user :name])
   :purchase (:details elements)})

(defn get-all-name-and-purchases [elements]
  (->> elements
       (map get-name-and-purchase)
       set))

; Functions about users
(defn get-all-users
  [elements]
  (->> elements
       (group-by :user)
       (map first)))

(defn get-user-by-name
  [name elements]
  (->> (filter
         #(= (:name %) name)
         (get-all-users elements))
       first))


; Functions about credit card
(defn get-card-by-user-name
  [name elements]
  (->> (get-all-names-and-cards elements)
       (filter
         #(= (:name %) name))
       first))

; Functions about purchase
(defn get-order-price [order]
  (get order :total-price))

(defn get-purchase-by-category
  [orders]
  (->> orders
       (map :details)
       (group-by :category)))

(defn price-by-category
  [[category details]]
  {:category category
   :price (->> details
               (map get-order-price)
               (reduce +))})

(defn total-price-by-category
  [orders]
  (->> orders
       (map price-by-category)))
