(ns my-app.euler23-test
  (:require [clojure.test :refer [deftest is testing]]
            [my-app.euler23 :refer [divs abundant?
                                    modular
                                    tailrec
                                    recursive
                                    lazy]]))

(deftest divisors-and-abundant-tests
  (testing "sum-proper-divs basic cases"
    (is (= 0  (divs 1)))
    (is (= 16 (divs 12)))
    (is (= 28 (divs 28))))

  (testing "abundant? on known numbers"
    (is (true?  (abundant? 12)))
    (is (false? (abundant? 28)))   ;; perfect
    (is (false? (abundant? 1)))))

(deftest small-limit-24-test
  (testing "Для limit = 24, ans = 276"
    (is (= 276 (modular 24)))
    (is (= 276 (tailrec 24)))
    (is (= 276 (recursive 24)))
    (is (= 276 (lazy 24)))))

(deftest implementations-agree-on-small-and-default
  (testing "Все реализации должны давать одинаковый результат для нескольких лимитов"
    (let [vals-small (map #(% 1000) [modular
                                     tailrec
                                     recursive
                                     lazy])]
      (is (apply = vals-small)))
    (let [vals-default (map #(% 28123) [modular
                                        tailrec
                                        recursive
                                        lazy])]
      (is (apply = vals-default)))))

(deftest euler-23-expected-answer
  (testing "Project Euler #23 — ожидаемый ответ"
    (is (= 4179871 (modular 28123)))
    (is (= 4179871 (tailrec 28123)))
    (is (= 4179871 (recursive 28123)))
    (is (= 4179871 (lazy 28123)))))
