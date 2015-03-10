(ns simpimmut.core
  (:gen-class))

(defn -main
  [& args]
    
    ;; create a future
    (future 
        ;;set it to repeat 1000
        (dotimes [n 1000] 
            ;; pause the thread for .01 sec
            (Thread/sleep 10) 
            ;; define the variable
            (def x "Hello") 
            ;; print the number of execution and the variable
            (println n x))
        ;; notify when finished looping
        (println "fn 1 complete")
    )
    
    ;; creation of the second future
    (future 
        ;;set it to repeat 1000
        (dotimes [n 1000] 
            ;; pause the thread for .01 sec
            (Thread/sleep 10) 
            ;; define a new variable with the same name
            (def x "Goodbye") 
            ;; print the number of execution to show simulataneous execution
            (println n)) 
        ;; notify when finished looping
        (println "fn 2 complete")
    )
    
)
