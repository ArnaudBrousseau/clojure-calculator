# Functional calculator

This app is a simple calculator written in Clojure. It's also my first try at
functional web programming. (I've done some to solve trivial algorithmic
problems...but web programming brings a whole different class of problems!)

As an additional challenge, this calculator only uses Ring's Jetty
adapter...and that's all! No middleware at all. Let's learn more about
request/response object, URI params parsing. Com'on, it's fun!

## Usage example

Go to http://clojure-calculator.herokuapp.com

1. /add?args=1,2,-30,5,
2. /subtract?args=30,5,8
3. /multiply?args=20,4,-1

For now, only the first example works properly.

## License

Copyright (C) 2013 Arnaud Brousseau
Distributed under the Eclipse Public License, the same as Clojure.
