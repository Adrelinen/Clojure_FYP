;;Create a GUI which allows user to input a string and to select "word count" or "letter count". When "Start" is clicked pass both the string and either (wordCount [string x]) or (letterCount [string x]) to 
;;declare functions as variables
;;show function that takes functions as parameters
;;show function that returns another function

(ns firstclass.core
  (:gen-class)
  (:use seesaw.core))

(defn -main
  [& args]
    
;; request input from the user
(def strInput (input "Please enter a string to be evaluated"))
    
;; define a button group to attach selection buttons to
(def groups (button-group))
;; define a variable which stores the users selection
(def s (selection groups))
    
;; create the selection buttons and add them to the button group
(def letterRadio (radio :text "Letter" :group groups))
(def wordRadio (radio :text "Word" :group groups))
    
;;define the function for counting the number of letters in the input string
(defn letterCount
  [string]
  (count (seq string)))
 
;; define the function for counting the number of words in the input string
(defn wordCount
  [string]
;; split the string into individual words. based off code retrieved from http://commandercoriander.net/blog/2013/10/26/counting-words-in-clojure/
  (def split-words (clojure.string/split string #"\s"))

    (defn record-word-count [memo word]
  (assoc memo word (inc (memo word 0))))

(defn count-words [string]
  (reduce record-word-count {} string))

(count-words split-words)) ;; end of code retrieved from http://commandercoriander.net/blog/2013/10/26/counting-words-in-clojure/

;; Define the function which intakes other functions and the user input and applies the function to the string
(defn counter [x strInput] (x strInput))
    
;; create the handler for the start button
(defn handler [event]
    (if-let [s letterRadio]
        (println (counter letterCount strInput)))
    (if-let [s wordRadio]
        (println (counter wordCount strInput))))
  
;; define a button for starting the counts
(def start (button :text "Start Count" :listen [:action handler] ))

;; create a panel to display the input and options
(def panel
  (flow-panel :items [strInput, start]))

(invoke-later
  (-> (frame :content panel :on-close :dispose) 
      pack! show!)))