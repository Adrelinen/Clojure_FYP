(ns redditwallpaper.core
  (:gen-class)
  (:require [clojure.contrib.duck-streams :as duck]
            [clojure.java [io :as io] [shell :as shell]]
            [clojure.string :as string]
            [clojure.contrib.json :as json]))
(defn filename [uri]
  (last (string/split uri #"/")))

(defn over_18 [x]
  (:over_18 x))

(defn posts [x]
  (map :data (get-in x [:data :children])))

(defn plain-image [x]
  (re-find #"(.jpg|.png)$" (:url x)))

(def url "http://www.reddit.com/r/wallpaper.json")

(def wallpaperjson (json/read-json (slurp url)))

(defn copy [uri file]
  (with-open [in (io/input-stream uri)
              out (io/output-stream file)]
    (io/copy in out)))

(defn set-background [file]
  (shell/sh "feh" "--bg-scale" file))

(defn -main [& args]
  (let [posts (posts wallpaperjson)
        safe (filter (complement over_18) posts)
        images (filter plain-image safe)
        image (:url (first (shuffle images)))
        fname (filename image)]
    (do
      (println (format "Downloading '%s'" image))
      (def f (future ((copy image fname)
                    (println "Done"))))
      (shutdown-agents))))
