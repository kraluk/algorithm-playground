package com.kraluk.playground.algorithm.util

import spock.lang.Specification

class MultiplesSpec extends Specification {

    def "get multiples of the given number through the given limit"() {
        expect:
        Multiples.getMultiples(number, limit) == expected

        where:
        number | limit | expected
        3      | 10    | [3, 6, 9] as Set<Long>
        5      | 10    | [5] as Set<Long>
    }

    def "illegal limit for calculating multiples"() {

        when:
        Multiples.getMultiples(6, Multiples.MAX_LIMIT)

        then:
        thrown IllegalArgumentException
    }
}