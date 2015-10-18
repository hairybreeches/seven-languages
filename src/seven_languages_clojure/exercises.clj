(ns seven-languages-clojure.exercises)

(defn longer? [string length]
  (> (count string) length))


(defn collection-type [col]
  (cond (instance? clojure.lang.PersistentArrayMap col) :map
        (instance? clojure.lang.PersistentVector col) :vector
        (instance? clojure.lang.PersistentList col) :list
        :else (throw (Exception. (str "Don't recognise type: " (type col))))))

(defmacro unless [condition a b]
  (list 'if
        condition
        b
        a))


(defprotocol Die
  (spots[d])
  (roll[d])
  (increment[d bonus]))


(defrecord SixSidedDie[value]
  Die
  (spots [_]  value)
  (roll [_] (SixSidedDie. (inc (int (rand 6)))))
  (increment [_ bonus] (SixSidedDie. (+ value bonus))))



(def accounts (ref [1 2 3 5 8 13 -21 -16 -3]))

(defn modify-account[current-accounts index operation]
  (assoc current-accounts index (operation (current-accounts index))))

(defn do-transfer[current-accounts amount index-to-add index-to-subtract]
  (->
   current-accounts
   (modify-account index-to-add #(+ % amount))
   (modify-account index-to-subtract #(- % amount))))

(defn transfer-money[amount index-to-add index-to-subtract]
  (dosync
   (alter accounts do-transfer amount index-to-add index-to-subtract)))

