package com.kraluk.playground.algorithm.common

import com.kraluk.playground.algorithm.common.UnitType
import spock.lang.Specification
import spock.lang.Unroll

import static com.kraluk.playground.algorithm.common.UnitType.BINARY
import static com.kraluk.playground.algorithm.common.UnitType.SI

class UnitTypeSpec extends Specification {

    @Unroll
    def "should get #expected type for base #base"() {
        when:
        def result = UnitType.get(base)

        then:
        result == expected

        where:
        base  || expected
        1_000 || SI
        1_024 || BINARY
    }

    @Unroll
    def "should throw an exception when not proper base #base is used"() {
        when:
        UnitType.get(base)

        then:
        thrown(IllegalArgumentException)

        where:
        base << [Integer.MAX_VALUE, Integer.MIN_VALUE]
    }
}
