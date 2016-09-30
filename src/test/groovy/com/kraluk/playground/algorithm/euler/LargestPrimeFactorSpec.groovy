package com.kraluk.playground.algorithm.euler

import spock.lang.Ignore
import spock.lang.Specification

class LargestPrimeFactorSpec extends Specification {

    def "calculate largest prime factor of the given number"() {

        expect:
            LargestPrimeFactor.calculate(number) == expected

        where:
            number              | expected
            2                   | -1
            13_195              | 29
            600_851_475_143     | 6_857
            222_634_543_654_234 | 5_477
    }

    @Ignore
    def "calculate largest prime factor of the given number (optimized)"() {

        expect:
            LargestPrimeFactor.calculateOptimized(number) == expected

        where:
            number              | expected
            2                   | -1
            13_195              | 29
            600_851_475_143     | 6_857
            222_634_543_654_234 | 5_477
    }
}