(ns seven-languages-clojure.core-test
  (:use seven-languages-clojure.core)
  (:use clojure.test))

(deftest know-when-string-is-longer
  (is (longer? "steve" 4)))

(deftest know-when-string-is-not-longer
  (is (not (longer? "francois" 8))))
