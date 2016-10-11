package com.kraluk.playground.algorithm.euler

import spock.lang.Specification

class LargestPrimeFactorSpec extends Specification {

    def "calculate largest prime factor of the given number"() {

        expect:
            LargestPrimeFactor.calculate(number) == expected

        where:
            number        | expected
            13_195        | 29
            124_234       | 5_647
            600_851_475   | 54_499
            //9_345_333_122 | 245_929_819
    }

    def "calculate largest prime factor of the given number (very crude)"() {

        expect:
            LargestPrimeFactor.calculateVeryCruded(number) == expected

        where:
            number        | expected
            13_195        | 29
            124_234       | 5_647
            600_851_475   | 54_499
            9_345_333_122 | 245_929_819
    }

    def "calculate largest prime factor of the given number (improved)"() {

        expect:
            LargestPrimeFactor.calculateImproved(number) == expected

        where:
            number        | expected
            13_195        | 29
            124_234       | 5_647
            600_851_475   | 54_499
            9_345_333_122 | 245_929_819
    }

    def "calculate largest prime factor of the given number (optimized)"() {

        expect:
            LargestPrimeFactor.calculateOptimized(number) == expected

        where:
            number        | expected
            13_195        | 29
            124_234       | 5_647
            600_851_475   | 54_499
            9_345_333_122 | 245_929_819
    }
}