package com.kraluk.playground.algorithm.euler

import com.kraluk.playground.algorithm.util.Multiples
import spock.lang.Specification

class MultiplesOfThreeAndFiveSpec extends Specification {

    def "calculate sum of multiples of given number through the given limit"() {
        expect:
            MultiplesOfThreeAndFiveSummer.calculate(limit) == expected

        where:
            limit         | expected
            10            | 23
            1_000         | 233_168
            1_000_000     | 233_333_166_668
            1_000_000_000 | 233_333_333_166_666_668
    }

    def "calculate sum of multiples of given number through the given limit (optimized)"() {
        expect:
            MultiplesOfThreeAndFiveSummer.calculateOptimized(limit) == expected

        where:
            limit         | expected
            10            | 23
            1_000         | 233_168
            1_000_000     | 233_333_166_668
            1_000_000_000 | 233_333_333_166_666_668
    }

    // ----- Legacy Stuff (ULTRA not optimized)

    def "(legacy) calculate sum of multiples of given number through the given limit"() {
        expect:
            MultiplesOfThreeAndFiveSummer.Legacy.calculate(limit) == expected

        where:
            limit | expected
            10    | 23
            1_000 | 233_168
    }

    def "(legacy) illegal limit for simple calculation"() {

        when:
            MultiplesOfThreeAndFiveSummer.Legacy.calculate(Multiples.MAX_LIMIT)

        then:
            thrown IllegalArgumentException
    }

    def "(legacy) calculate sum of multiples of given number through the given limit (Executor)"() {
        expect:
            MultiplesOfThreeAndFiveSummer.Legacy.calculateWithExecutor(limit) == expected

        where:
            limit | expected
            10    | 23
            1_000 | 233_168
    }

    def "(legacy) illegal limit for calculation with usage of Executor"() {

        when:
            MultiplesOfThreeAndFiveSummer.Legacy.calculateWithExecutor(Multiples.MAX_LIMIT)

        then:
            thrown IllegalArgumentException
    }

    def "(legacy) calculate sum of multiples of given number through the given limit (CompletableFuture)"() {
        expect:
            MultiplesOfThreeAndFiveSummer.Legacy.calculateWithCompletableFuture(limit) == expected

        where:
            limit | expected
            10    | 23
            1_000 | 233_168
    }

    def "(legacy) illegal limit for calculation with usage of CompletableFuture"() {

        when:
            MultiplesOfThreeAndFiveSummer.Legacy.calculateWithCompletableFuture(Multiples.MAX_LIMIT)

        then:
            thrown IllegalArgumentException
    }
}