(ns clojure-lab-2.lab_2_1)

(defn trapezoidal-rule
  ([x, f, step]
   (*
     step
     (+
       (/ (+ (f 0) (f x)) 2)
       (trapezoidal-rule x f step (- (/ x step) 1))
       )
     )

   )
  ([x, f, step, n]
   (if (> n 1)
     (+ (f (* n step)) (trapezoidal-rule x f step (- n 1)))
     (f (* n step))
     )
   )
  )

(defn sqr
  [x]
  (* x x)
  )

(defn line
  [x]
  x
  )

(defn const
  [x]
  1
  )

(defn log
  [x]
  (Math/log x)
  )
