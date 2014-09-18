(ns re-demo.time
  (:require [re-demo.util    :refer  [title]]
            [re-com.core     :refer [label]]
            [re-com.time :refer  [time-input time-range-input display-string]]
            [re-com.box      :refer  [h-box v-box box gap line]]
            [reagent.core    :as     reagent]))


(defn single-time []
  (let [model1 (reagent/atom [9 0])
        model2 (reagent/atom [20 30])]
    [v-box
     :gap "0px"
     :children [[title "Time"]
                [:p "Accepts input of a time. Model does not update until a valid time has been entered. Required parameters are -"]
                [:ul
                 [:li "model"]]
                [:p "Optional parameters are -"]
                [:ul
                 [:li "minimum-time - 2 element vec of min hour and min minute - will not allow input less than this time - default [0 0]."]
                 [:li "maximum-time - 2 element vec of max hour and max minute - will not allow input more than this time - default [23 59]."]
                 [:li "callback - function to call upon model change."]]
                [h-box
                  :gap "4px"
                  :children [[label :label "Time with default range:"]
                             [time-input :model model1]
                             [label :label "entered time: "]
                             [label :label (display-string @model1)]]]
                [gap "14px"]
                [h-box
                  :gap "4px"
                  :children [[label :label "Time with range 06:00-21:59:"]
                             [time-input :model model2 :minimum-time [6 0] :maximum-time [21 59]]
                             [label :label "entered time: "]
                             [label :label (display-string @model2)]]]]]))

(defn time-range []
  (let [range-model (reagent/atom [[9 0] [21 0]])]
    [v-box
      :gap "20px"
      :children [[title "Time Range"]
                 [time-range-input :model range-model :gap "60px"]]]))

(defn panel
  []
  [v-box
   :children [[single-time]
              [gap :height "30px"]
              [time-range]]])



