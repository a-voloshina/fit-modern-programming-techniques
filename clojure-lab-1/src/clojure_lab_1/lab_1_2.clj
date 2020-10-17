(ns clojure-lab-1.lab_1_2
  (:require [clojure.string :as clojure-str]))

(defn add-letter-recur
  ([letter, words]
   (add-letter-recur letter words ())
   )

  ([letter, words, acc]
   (if
     (empty? words)
     acc
     (recur
       letter
       (rest words)
       (concat
         acc
         (if-not
           (clojure-str/starts-with? (first words) letter)
           (list (str letter (first words)))
           ()))
       )
     )
   )
  )

(defn algorithm-step-recur
  ([letters, words]
   (algorithm-step-recur letters words ())
   )

  ([letters, words, acc]
   (if (empty? letters)
     acc
     (recur
       (rest letters)
       words
       (concat
         acc
         (add-letter-recur (first letters) words))
       )
     )
   )
  )

(defn get-combinations-recur
  ([n, letters] (get-combinations-recur n letters letters))
  ([n, letters, words]
   (if
     (> n 1)
     (recur (- n 1) letters (algorithm-step-recur letters words))
     words)
   )
  )
