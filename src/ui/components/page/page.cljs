(ns ui.page
  (:require [ui.shared-styles :as shared]))

(defn page [& children]
  [:div {:class-name shared/container}
    ; Each child needs a unique key.
    (map-indexed #(with-meta %2  {:key %1}) children)])
