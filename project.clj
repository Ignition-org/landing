(defproject landing "0.0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [io.pedestal/pedestal.service "0.3.1"]
                 [io.pedestal/pedestal.jetty "0.3.1"]
                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]
                 [environ "0.5.0"]]

  :min-lein-version "2.0.0"

  :plugins [[environ/environ.lein "0.2.1"]]

  :resource-paths ["config", "resources"]

  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "landing.server/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.3.1"]]}
             :production {:env {:production true}}}

  :uberjar-name "ignition-landing-standalone.jar"
  :uberjar {:aot :all}

  :main ^{:skip-aot true} landing.server)
