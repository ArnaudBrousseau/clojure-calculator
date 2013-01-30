(ns calculator.web
  (:use [ring.adapter.jetty :only [run-jetty]]))

  (defn app [req]
    {:status 200
       :headers {"Content-Type" "text/plain"}
          :body "Oh Yeah, Calculator!"})

          (defn -main [port]
            (run-jetty app {:port (Integer. port)}))
