(ns clojure-lab-1.lab_1_4
  (:require [clojure-lab-1.lab_1_3 :refer :all]))

(defn add-letter-to-words
  [letter words]
  (my-filter (fn [word]
               (not= (nth word 0) (nth word 1)                 )
               )
             (my-map (fn [word]
                       (str letter word))
                     words)
    )
  )

(defn algo-step
  [letters words]
  (reduce concat (map
    (fn [letter]
      (add-letter-to-words letter words))
    letters
    ))
  )

(defn make-combinations
  ([n letters]
   (make-combinations n letters letters)
   )

  ([n letters words]
   (if (> n 1)
     (make-combinations (- n 1) letters (algo-step letters words))
     words
     )
   )
  )