(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você perdeu"))
(defn ganhou [] (print "Você ganhou"))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra)
  )

(defn acertou-a-palavra-toda? [palavra acertos] 
  (empty? (letras-faltantes palavra acertos))
  )

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn jogo [vidas palavra acertos]
  (cond 
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Letra Correta!")
          (recur vidas palavra (conj acertos chute)))
        (do
          (println "Letra Errada! Perdeu Vida.")
          (recur (dec vidas) palavra acertos))))))

(defn soma [n]
  (loop [contador 1 soma 0]
    (if (> contador n) soma
      (recur (inc contador) (+ soma contador)))))

(defn -main
"I don't do a whole lot ... yet."
[& args]
(println "Hello, World!"))


; (defn fib [x]
;   (if (= x 0) 0
;     (if (= x 1) 1
;       (loop [a 1 b 1 numero 2]
;         (if
;           (= numero x) b
;           (recur b (+ a b) (inc numero)))))))

; (defn fibold [x]
;   (if (= x 0) 0
;     (if (= x 1) 1
;       (+ (fib (- x 1)) (fib (- x 2))))))