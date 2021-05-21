(ns credit-card-simulation.model)

(defn uuid []  (java.util.UUID/randomUUID))

(defn new-user
  ([name cpf email] (new-user (uuid) name cpf email))
  ([uuid name cpf email]
   {:user/id    uuid
    :user/name  name
    :user/cpf   cpf
    :user/email email}))

(defn new-card
  ([number cvv limit] (new-card (uuid) number cvv limit))
  ([uuid number cvv limit]
   {:card/id     uuid
    :card/number number
    :card/cvv    cvv
    :card/limit  limit}))

(defn new-purchase
  ([price establishment category] (new-purchase (uuid) price establishment category))
  ([uuid price establishment category]
   {:purchase/id            uuid
    :purchase/price         price
    :purchase/establishment establishment
    :purchase/category      category}))