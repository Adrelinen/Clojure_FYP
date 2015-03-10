(defproject immutability "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
    
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"][org.rhq.examples/java-remote-api "1.0.0"]]
  :permissions ["src/immutability/java.policy"]
  :main ^:skip-aot immutabilityjohn.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
    :java-source-paths ["src/immutability/"])
