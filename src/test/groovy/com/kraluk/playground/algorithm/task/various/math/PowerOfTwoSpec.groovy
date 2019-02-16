package com.kraluk.playground.algorithm.task.various.math

import spock.lang.Specification

class PowerOfTwoSpec extends Specification {

    def "calculate power of 2 using brute force method"() {

        expect:
        PowerOfTwo.bruteForce(number) == expected

        where:
        number        | expected
        1024          | true
        1111          | false
        1024 * 2 * 2  | true
        4 * 4 * 4 * 4 | true
    }

    def "calculate power of 2 using logarithms"() {

        expect:
        PowerOfTwo.logarithm(number) == expected

        where:
        number        | expected
        1024          | true
        1111          | false
        1024 * 2 * 2  | true
        4 * 4 * 4 * 4 | true
    }

    def "calculate power of 2 using bitwise method"() {

        expect:
        PowerOfTwo.bitwise(number) == expected

        where:
        number        | expected
        1024          | true
        1111          | false
        1024 * 2 * 2  | true
        4 * 4 * 4 * 4 | true
    }

    def "calculate power of 2 using another bitwise method"() {

        expect:
        PowerOfTwo.bitwiseOtherApproach(number) == expected

        where:
        number        | expected
        1024          | true
        1111          | false
        1024 * 2 * 2  | true
        4 * 4 * 4 * 4 | true
    }
}