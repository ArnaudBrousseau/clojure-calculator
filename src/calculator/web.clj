(ns calculator.web
  (:use [ring.adapter.jetty :only [run-jetty]]
        [clojure.string :only [split]]))

(defn add [& numbers]
  (apply + numbers))

(defn parse-uri [uri]
  (apply str (let [[_ & func-name] uri] func-name)))

(defn get-method-from-uri [uri]
  ; Parses the URI method and returns a Clojure 
  ; function if there is one.
  ; TODO: fail gracefully if a function isn't found
  ; in the current namespace.
  (ns-resolve `calculator.web (
    symbol (parse-uri uri))))

(defn get-args-from-qs [qs]
  ; will return a vector of integers, e.g., [1 3 4]
  (vec (map read-string(
    rest (split qs #"=|,")))))

(defn compute [uri, qs]
  (.toString (apply
    (get-method-from-uri uri)
    (get-args-from-qs qs))))

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (let [{qs :query-string, uri :uri} req]
     (if (= uri "/")
       ; "Home" page
       (apply str (concat
         "Welcome to Clojure Calculator!\n"
         "------------------------------\n"
         "Try /add?args=2,2"))
       (compute uri qs)))})

(defn -main [port]
  (run-jetty app {:port (Integer. port)}))
