(ns predicates)

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== k n))
  )

(defn set->predicate [a-set]
   (fn [x] (contains? a-set x))
  )

(defn pred-and [pred1 pred2]
   (fn [x] (and (pred1 x) (pred2 x))
            ))


(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))
            ))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)

  )

(defn has-award? [book award]
 (contains? (get book :awards) award)
  ; (filter  award  )

)
(defn HAS-ALL-THE-AWARDS? [book awards]

  (every? (get book :awards) awards)
  ;(filter (get book :awards) awards)
  )

(defn my-some [pred a-seq]

;  (filter pred a-seq))
(if (empty? (filter pred a-seq))
   false
  (pred (first (filter pred a-seq) ) )))


(defn my-every? [pred a-seq]
  (if(= (count a-seq)(count (filter true? (map pred a-seq))))
        true
        false
        ))






(defn prime? [n]
  (let [pred (fn [x] (if (= 0 (mod n x))
                       true
                       false))]

  (not (some true? (map  pred (range 2 n)))))

    )
    ;))
;))
;^^



