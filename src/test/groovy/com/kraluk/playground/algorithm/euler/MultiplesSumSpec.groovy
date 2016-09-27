package com.kraluk.playground.algorithm.euler

import spock.lang.Specification

class MultiplesSumSpec extends Specification {

    def "calculate sum of multiples of given number through the given limit"() {
        expect:
            MultiplesOfThreeAndFive.calculateSum(limit) == expected

        where:
            limit | expected
            10    | 23
            1000  | 233168
    }

    def "calculate sum of multiples of given number through the given limit (Executor)"() {
        expect:
            MultiplesOfThreeAndFive.calculateSumWithExecutor(limit) == expected

        where:
            limit | expected
            10    | 23
            1000  | 233168
    }

    def "calculate sum of multiples of given number through the given limit (CompletableFuture)"() {
        expect:
            MultiplesOfThreeAndFive.calculateSumWithCompletableFuture(limit) == expected

        where:
            limit | expected
            10    | 23
            1000  | 233168
    }
}