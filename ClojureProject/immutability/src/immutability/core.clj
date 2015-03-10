(ns immutability.core
  (:import (stub SayName)
           (java.rmi.registry LocateRegistry)
           (java.rmi.server UnicastRemoteObject))
  (:gen-class))

(defn -main
  [& args]
  (println "Hello, World!"))

(def SM (proxy [SecurityManager] [] 
          ))

(System/setSecurityManager SM)

(def rmi-registry
  (LocateRegistry/createRegistry 1099))

(defn name-server []
  (reify SayName
    (Name [personname] "Hello, " + personname)))

(defn register-server []
  (.bind
   (LocateRegistry/getRegistry)
   "Hello"
   (UnicastRemoteObject/exportObject
    (name-server) 0)))

(register-server)
