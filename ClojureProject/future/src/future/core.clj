(ns future.core
  (:gen-class)
  (:use seesaw.core))

(defn -main
    [& args]

;; define handlers for each button
(defn handlera [event]
    ;; start the download in a future, sleep the thread to slow down execution
    (future (Thread/sleep 4000) (def wall1 (button :text "" :icon "http://fc09.deviantart.net/fs70/i/2014/309/3/4/busting_by_skyrace-d85edrw.jpg"))
    ;; create a panel to display the downloaded image
    (def panela
        (flow-panel :items [wall1]))
    (-> (frame :content panela :on-close :dispose) 
            pack! show!)))
    
(defn handlerb [event]
    (future (Thread/sleep 4000) (def wall2 (button :text "" :icon "http://fc08.deviantart.net/fs20/i/2007/248/c/6/No_wallpaper_by_Alexxg.jpg"))
    (def panelb
        (flow-panel :items [wall2]))
    (-> (frame :content panelb :on-close :dispose) 
            pack! show!)))
    
(defn handlerc [event]
    (future (Thread/sleep 4000) (def wall3 (button :text "" :icon "http://fc00.deviantart.net/fs13/f/2007/085/8/9/Wallpaper_by_kalvindesign.jpg"))
    (def panelc
        (flow-panel :items [wall3]))
    (-> (frame :content panelc :on-close :dispose) 
            pack! show!)))
    
(defn handlerd [event]
    (future (Thread/sleep 4000) (def wall4 (button :text "" :icon "http://th09.deviantart.net/fs27/PRE/f/2008/081/c/7/wallpaper_by_sandara.jpg"))
    (def paneld
        (flow-panel :items [wall4]))
    (-> (frame :content paneld :on-close :dispose) 
            pack! show!)))
    
(defn handlere [event]
    (future (Thread/sleep 4000) (def wall5 (button :text "" :icon "http://th03.deviantart.net/fs71/PRE/f/2010/024/e/b/be_wallpaper_by_madazulu.jpg"))
    (def panele
        (flow-panel :items [wall5]))
    (-> (frame :content panele :on-close :dispose) 
            pack! show!)))
    
;; create the buttons
(def a (button :text "Download" :listen [:action handlera] :icon "http://oi47.tinypic.com/xkpp1d.jpg"))

(def b (button :text "Download" :listen [:action handlerb] :icon "http://oi49.tinypic.com/15wyvbm.jpg"))

(def c (button :text "Download" :listen [:action handlerc] :icon "http://oi54.tinypic.com/2e58qh4.jpg"))

(def d (button :text "Download" :listen [:action handlerd] :icon "http://oi48.tinypic.com/2luzbt3.jpg"))
    
(def e (button :text "Download" :listen [:action handlere] :icon "http://oi53.tinypic.com/b88bw0.jpg"))

;;create a panel to cisplay the buttons
(def panel
  (flow-panel :items [a b c d e]))

(invoke-later
  (-> (frame :content panel :on-close :dispose) 
      pack! show!))
  (println "Execution Complete"))
