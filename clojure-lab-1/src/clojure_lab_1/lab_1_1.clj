(ns clojure-lab-1.lab_1_1
  (:require [clojure.string :as clojure-str]))

(defn add-letter
  ([letter, words]
   (concat
     (if-not
       (clojure-str/starts-with? (first words) letter)
       (list (str letter (first words)))
       ()
       )
     (if
       (empty? (rest words))
       ()
       (add-letter letter (rest words)))
     )
   )
  )

(defn algorithm-step
  ([letters, words]
   (concat
     (add-letter (first letters) words)
     (if (empty? (rest letters))
       ()
       (algorithm-step (rest letters) words))
     )
   )
  )

(defn get-combinations
  ([n, letters] (get-combinations n letters letters))
  ([n, letters, words]
   (if
     (> n 1)
     (get-combinations (- n 1) letters (algorithm-step letters words))
     words)
   )
  )
