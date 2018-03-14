(ns ui.shared-styles
  (:require [forest.macros :refer-macros [defstylesheet]]))

(defstylesheet styles
  [.flex-center {:display "flex"
                 :flex 1
                 :align-items "center"
                 :justify-content "center"}]
  ; Just to show you how to use composes
  [.container   {:composes flex-center}])
