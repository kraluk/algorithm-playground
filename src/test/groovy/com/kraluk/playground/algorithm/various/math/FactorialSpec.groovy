package com.kraluk.playground.algorithm.various.math

import spock.lang.Specification

class FactorialSpec extends Specification {

    def "value of given number's factorial (iterative)"() {

        expect:
        Factorial.iterative(number) == expected

        where:
        number | expected
        0      | 1
        1      | 1
        4      | 24
        4      | 24
        20     | 2_432_902_008_176_640_000
    }

    def "value of given number's factorial (recursive)"() {

        expect:
        Factorial.recursive(number) == expected

        where:
        number | expected
        0      | 1
        1      | 1
        4      | 24
        20     | 2_432_902_008_176_640_000
    }

    def "illegal negative arguments occurs (iterative)"() {

        when:
        Factorial.iterative(-1)

        then:
        thrown IllegalArgumentException
    }

    def "illegal negative arguments occurs (recursive)"() {

        when:
        Factorial.recursive(-1)

        then:
        thrown IllegalArgumentException
    }
}