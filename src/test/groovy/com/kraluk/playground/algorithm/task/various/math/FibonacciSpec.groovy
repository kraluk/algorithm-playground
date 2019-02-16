package com.kraluk.playground.algorithm.task.various.math

import spock.lang.Specification

class FibonacciSpec extends Specification {

    def "value of Fibonacci sequence (iterative)"() {

        expect:
        Fibonacci.iterative(number) == expected

        where:
        number | expected
        0      | 0
        1      | 1
        10     | 55
        19     | 4181
        35     | 9_227_465
    }

    def "value of Fibonacci sequence (recursive)"() {

        expect:
        Fibonacci.recursive(number) == expected

        where:
        number | expected
        0      | 0
        1      | 1
        10     | 55
        19     | 4181
        35     | 9_227_465
    }
}