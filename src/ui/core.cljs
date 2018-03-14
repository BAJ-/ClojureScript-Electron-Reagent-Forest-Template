(ns ui.core
  (:require [reagent.core :as reagent]
            [ui.page :refer (page)]))

(defn root-component []
         ; The electro-forest id defines the text animation.
         ; Forest seems not to support animation, so this you
         ; will have to do something like this instead.
  [page [:h1#electro-forest "Electro forest"]])

(reagent/render
  [root-component]
  (js/document.getElementById "app"))
