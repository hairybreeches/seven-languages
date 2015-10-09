(ns seven-languages-clojure.core-test
  (:use seven-languages-clojure.core)
  (:use clojure.test))

(deftest know-when-string-is-longer
  (is (longer? "steve" 4)))

(deftest know-when-string-is-not-longer
  (is (not (longer? "francois" 8))))

(deftest can-determine-list-type
  (is (= :list (collection-type '(1 2 3)))))

(deftest can-determine-vector-type
  (is (= :vector (collection-type ["foo" "bar" "baz" "qux"]))))

(deftest can-determine-map-type
  (is (= :map (collection-type {}))))

(deftest throws-when-unknown-type
  (is (thrown? Exception (collection-type #{}))))
