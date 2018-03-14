(defproject Electro-forest "0.1.0-SNAPSHOT"
  :license {:name "The MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :source-paths ["src"]
  :description "Electro Forest"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [figwheel "0.5.15"]
                 [reagent "0.7.0"]
                 [forest "0.2.1"]
                 [ring/ring-core "1.6.1"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.15"]]

  :figwheel {:http-server-root "public"
             :css-dirs ["resources/public/css"]
             :builds-to-start [:dev-frontend]
             :ring-handler tools.figwheel-middleware/app
             :server-port 3449}

  :clean-targets ^{:protect false} [[:cljsbuild :builds :dev-electron :compiler :output-to]
                                    [:cljsbuild :builds :dev-frontend :compiler :output-to]
                                    [:cljsbuild :builds :dev-frontend :compiler :output-dir]
                                    [:cljsbuild :builds :release-electron :compiler :source-map]]

  :cljsbuild
  {:builds
   {:dev-electron
    {:source-paths ["src/electron"]
     :compiler {:output-to "resources/main.js"
                :output-dir "resources/public/js/electron-dev"
                :optimizations :simple
                :pretty-print true
                :cache-analysis true}}
   :dev-frontend
    {:source-paths ["src/ui" "src/dev"]
     :compiler {:output-to "resources/public/js/ui-core.js"
                :output-dir "resources/public/js/ui-out"
                :source-map true
                :asset-path "js/ui-out"
                :optimizations :none
                :cache-analysis true
                :main "dev.core"}}
   :release-electron
    {:source-paths ["src/electron"]
     :compiler {:output-to "resources/main.js"
                :output-dir "resources/public/js/electron-release"
                :optimizations :advanced
                :pretty-print true
                :cache-analysis true
                :infer-externs true}}
    :release-frontend
    {:source-paths ["src/ui"]
     :compiler {:output-to "resources/public/js/ui-core.js"
                :output-dir "resources/public/js/ui-release-out"
                :source-map "resources/public/js/ui-core.js.map"
                :optimizations :advanced
                :cache-analysis true
                :infer-externs true
                :main "ui.core"}}}})
