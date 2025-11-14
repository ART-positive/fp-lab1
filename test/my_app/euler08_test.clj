(ns my-app.euler08-test
  (:require [clojure.test :refer [deftest is testing]]
            [my-app.euler08 :refer [digits
                                    recursive
                                    tailrec
                                    mapindexed
                                    lazy
                                    str-input]]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest digits-basic-test
  (testing "digits returns correct digits for small samples"
    (is (= (vec (digits "12345")) [1 2 3 4 5]))
    (is (= (vec (digits "a1b2c3")) [1 2 3]))))

(deftest sample-4-test
  (testing "Пример из условия: максимальное произведение 4 подряд цифр = 5832"
    ;; используем str-input и проверяем, что для окна 4 получаем 5832
    (is (= 5832 (recursive str-input 4)))
    (is (= 5832 (tailrec str-input 4)))
    (is (= 5832 (mapindexed str-input 4)))
    (is (= 5832 (lazy str-input 4)))))

(deftest full-13-test
  (testing "Полный 1000-значный пример: ожидаем 23514624000"
    (let [expected 23514624000]
      (is (= expected (recursive str-input 13)))
      (is (= expected (tailrec str-input 13)))
      (is (= expected (mapindexed str-input 13)))
      (is (= expected (lazy str-input 13))))))

(deftest short-input-test
  (testing "Если длина входа меньше окна, возвращаем 0"
    (is (= 0 (recursive "123" 4)))
    (is (= 0 (tailrec "123" 4)))
    (is (= 0 (mapindexed "123" 4)))
    (is (= 0 (lazy "123" 4)))))
