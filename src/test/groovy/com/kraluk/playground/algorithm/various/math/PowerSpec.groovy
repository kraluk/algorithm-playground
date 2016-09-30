package com.kraluk.playground.algorithm.various.math

import spock.lang.Specification

class PowerSpec extends Specification {

    def "calculate power of a given number using logarithms"() {

        expect:
            Power.logarithm(number, base) == expected

        where:
            number        | base | expected
            9             | 3    | true
            10            | 3    | false
            10 * 4        | 3    | false
            4 * 4 * 4 * 4 | 4    | true
    }
}