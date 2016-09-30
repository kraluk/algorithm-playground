package com.kraluk.playground.algorithm.euler

import spock.lang.Specification

class FibonacciEvenSummerTest extends Specification {

    def "calculate sum of even values (which maximum value is limited) of the Fibonacci sequences (for loop)"() {
        expect:
            FibonacciEvenSummer.calculate(maximum) == expected

        where:
            maximum    | expected
            4          | 2
            40         | 44
            4_000      | 3_382
            40_000     | 14_328
            400_000    | 257_114
            4_000_000  | 4_613_732
            40_000_000 | 19_544_084
    }

    def "calculate sum of even values (which maximum value is limited) of the Fibonacci sequences (while loop)"() {
        expect:
            FibonacciEvenSummer.calculateWhiled(maximum) == expected

        where:
            maximum    | expected
            4          | 2
            40         | 44
            4_000      | 3_382
            40_000     | 14_328
            400_000    | 257_114
            4_000_000  | 4_613_732
            40_000_000 | 19_544_084
    }

    def "calculate sum of even values (which maximum value is limited) of the Fibonacci sequences (optimized)"() {
        expect:
            FibonacciEvenSummer.calculateOptimized(maximum) == expected

        where:
            maximum    | expected
            4          | 2
            40         | 44
            4_000      | 3_382
            40_000     | 14_328
            400_000    | 257_114
            4_000_000  | 4_613_732
            40_000_000 | 19_544_084
    }
}