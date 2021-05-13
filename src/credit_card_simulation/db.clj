(ns credit-card-simulation.db)

(def order1 {:user {:name "User1", :cpf "26706992003", :email "user1@email.com"},
             :card {:number "5351578058054924", :cvv "103", :valid "10/05/2023", :limit 15000},
             :details {:date "02/05/2021", :total-price 261.21, :establishment "Pão de Açúcar", :category "Food"}})

(def order2 {:user {:name "User2", :cpf "66273113050", :email "user2@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 3000},
             :details {:date "12/05/2021", :total-price 75.31, :establishment "McDonald's", :category "Food"}})


(def order3 {:user {:name "User3", :cpf "70364819006", :email "user3@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 5500},
             :details {:date "15/05/2021", :total-price 700, :establishment "Tok&Stok", :category "Store"}})

(def order4 {:user {:name "User4", :cpf "70364819006", :email "Denize@email.com"},
             :card {:number "5283753121890900", :cvv "308", :valid "10/04/2022", :limit 1500},
             :details {:date "21/05/2021", :total-price 50, :establishment "Netflix", :category "Service"}})

(def order5 {:user {:name "User1", :cpf "26706992003", :email "user1@email.com"},
             :card {:number "5351578058054924", :cvv "103", :valid "10/05/2023", :limit 15000},
             :details {:date "22/04/2021", :total-price 7500, :establishment "Amazon", :category "Store"}})

(def order6 {:user {:name "User2", :cpf "66273113050", :email "user2@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 3000},
             :details {:date "25/05/2021", :total-price 279.90, :establishment "Disney", :category "Service"}})


(def order7 {:user {:name "User3", :cpf "70364819006", :email "user3@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 5500},
             :details {:date "28/05/2021", :total-price 123.69, :establishment "Hering", :category "Store"}})

(def order8 {:user {:name "User4", :cpf "70364819006", :email "user4@email.com"},
             :card {:number "5283753121890900", :cvv "308", :valid "10/04/2022", :limit 1500},
             :details {:date "19/04/2021", :total-price 85.50, :establishment "Ifood", :category "Food"}})

(def order9 {:user {:name "User1", :cpf "26706992003", :email "user1@email.com"},
             :card {:number "5351578058054924", :cvv "103", :valid "10/05/2023", :limit 15000},
             :details {:date "12/04/2021", :total-price 3000, :establishment "CVC", :category "Service"}})

(def order10 {:user {:name "User2", :cpf "66273113050", :email "user2@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 3000},
             :details {:date "25/05/2021", :total-price 36.75, :establishment "Uber", :category "Service"}})


(def order11 {:user {:name "User3", :cpf "70364819006", :email "user3@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 5500},
             :details {:date "22/05/2021", :total-price 140, :establishment "Outback", :category "Food"}})

(def order12 {:user {:name "User4", :cpf "70364819006", :email "user4@email.com"},
             :card {:number "5283753121890900", :cvv "308", :valid "10/04/2022", :limit 1500},
             :details {:date "19/05/2021", :total-price 25.12, :establishment "Uber", :category "Service"}})

(def order13 {:user {:name "User1", :cpf "26706992003", :email "user1@email.com"},
             :card {:number "5351578058054924", :cvv "103", :valid "10/05/2023", :limit 15000},
             :details {:date "15/05/2021", :total-price 45.50, :establishment "Bacio Di Latte", :category "Food"}})

(def order14 {:user {:name "User2", :cpf "66273113050", :email "user2@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 3000},
             :details {:date "23/05/2021", :total-price 50, :establishment "Spotify", :category "Service"}})


(def order15 {:user {:name "User3", :cpf "70364819006", :email "user3@email.com"},
             :card {:number "5413563480092870", :cvv "988", :valid "10/10/2022", :limit 5500},
             :details {:date "06/05/2021", :total-price 97.67, :establishment "Veloso Bar", :category "Food"}})

(def order16 {:user {:name "User4", :cpf "70364819006", :email "user4@email.com"},
             :card {:number "5283753121890900", :cvv "308", :valid "10/04/2022", :limit 1500},
             :details {:date "20/05/2021", :total-price 279.90, :establishment "Disney", :category "Service"}})

(defn all-orders []
  [order1, order2, order3, order4, order5, order6, order7, order8, order9, order10,
   order11, order12, order13, order14, order15, order16])