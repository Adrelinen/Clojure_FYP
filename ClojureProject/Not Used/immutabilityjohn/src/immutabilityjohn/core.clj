(ns immutabilityjohn.core
  (:gen-class))

(defn -main
  [& args]
    
(def SM (proxy [SecurityManager] [] 
          ))

(System/setSecurityManager SM)

  (def rmi-registry (java.rmi.registry.LocateRegistry/getRegistry "127.0.0.1"))

(let [sayName (.lookup rmi-registry "Hello")]
  (dotimes [n 1000](println (.SayName "john")))))
