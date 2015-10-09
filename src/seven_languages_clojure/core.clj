(ns seven-languages-clojure.core)

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

