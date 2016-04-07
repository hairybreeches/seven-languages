(ns seven-languages-clojure.core)

(def queue (agent 0))
(def barber (agent 0))

;timing
(def start (atom 0))

(defn get-time
  []
  (System/currentTimeMillis))

(defn set-start
  []
  (reset! start (get-time)))

(defn elapsed
  []
  (- (get-time) @start))

;code for shaving people in the queue
(defn finish-shaving
  [length]
  (if (= length 0)
      (throw (Exception. "Trying to finish shaving a customer who isn't there!"))
      (dec length)))

(defn shave-customer
  [already-shaved]
  (if (<= @queue 0)
    (throw (Exception. "Trying to start shaving a customer who isn't there!")))
  (Thread/sleep 20)
  (send queue finish-shaving)
  (inc already-shaved))

;code for updating queue with new arrivals
(defn get-queue-interval
  []
  (+ 10 (rand 20)))

(defn wait-for-next-arrival
  []
  (Thread/sleep (get-queue-interval)))

(defn add-new-arrival
  [length]
  (if (= length 4)
      length
      (do
        (send barber shave-customer)
        (inc length))))

(defn run-queue
  []
  (while true
    (do
      (wait-for-next-arrival)
      (send queue add-new-arrival))))

(defn calculate-shaves
  []
  (set-start)
  (.start (Thread. run-queue))
  (Thread/sleep 10000)
  @barber)

(defn -main
  [& args]
  (prn "Calculating shaves given in 10 seconds")
  (prn "Maximum number of shaves possible is 499")
  (prn "Minimum number of shaves possible is 332")
  (prn "Shaves given: " (calculate-shaves))
  (prn "Customers in queue at end: " @queue))




