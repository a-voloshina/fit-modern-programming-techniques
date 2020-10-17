(ns clojure-lab-1.lab_1_3)

(defn my-map
  [foo, coll]
  (reduce
    (fn [acc elem]
      (concat acc (list (foo elem))))
    ()
    coll
    )
  )

(defn my-filter
  [pred coll]
  (reduce
    (fn [acc elem]
      (if
        (pred elem)
        (concat acc (list elem))
        acc
        )
      )
    ()
    coll
    )
  )
