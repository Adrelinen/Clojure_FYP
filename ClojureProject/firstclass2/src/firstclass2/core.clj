(ns firstclass2.core
  (:gen-class))

(defn -main
  [& args]
  
    ;; define the basic vectors
    (def startPoint (vector 5 5))
    (def vecRight (vector 1 0))
    
    ;; define the full move function
    (defn move [v1 v2]
        ;;split the vectors into their elements and define them as vars
        (let [[x1 y1] v1
            [x2 y2] v2]
        
        ;; make a new vector containing the modified elements
        (vector
            (+ x1 x2)
            (+ y1 y2))))
    
    ;;define moveRight as a partial application of move, specifying that one vector will always be vecRight
    (def moveRight (partial move vecRight))
    
    ;;define ansVec as the result of passing a vector to moveRight
    (def ansVec (moveRight startPoint))
    
    ;;print the returned vector to show that it is the sum of startPoint and vecRight
    (println (str [ansVec]))
)
