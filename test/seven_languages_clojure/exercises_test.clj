(ns seven-languages-clojure.exercises-test
  (:use seven-languages-clojure.exercises)
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

(defn returns-3 []
  (unless true
          (throw (Exception. "Should not evaluate this branch of code"))
          3))

(deftest can-evaluate-unless-when-true
  (is (= (returns-3) 3)))

(defn returns-5 []
  (unless false
          5
          (throw (Exception. "Should not evaluate this branch of code"))))

(deftest can-evaluate-unless-when-false
  (is (= (returns-5) 5)))

(defn writing-unless-doesnt-evaluate-condition []
  (unless (throw (Exception. "Should not evaluate the condition unless the function is called"))
          2
          3))

(deftest can-roll-a-die
  (let [die (.roll (seven_languages_clojure.exercises.SixSidedDie. 0))]
    (is (<= (.spots die) 6))
    (is (>= (.spots die) 1))))

(deftest can-add-bonus-to-a-die
  (let [die (.increment (seven_languages_clojure.exercises.SixSidedDie. 3) 5)]
    (is (= (.spots die) 8))))


(deftest can-modify-accounts
  (do (transfer-money 6 6 2)
    (is (= @accounts [1 2 -3 5 8 13 -15 -16 -3]))))
