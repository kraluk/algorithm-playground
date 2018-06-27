package com.kraluk.playground.algorithm.util

import spock.lang.Specification
import spock.lang.Unroll

import static com.kraluk.playground.algorithm.util.SizeUnit.*
import static com.kraluk.playground.algorithm.util.UnitType.BINARY
import static com.kraluk.playground.algorithm.util.UnitType.SI

class SizeUnitSpec extends Specification {

    @Unroll
    def "should get #expected.getUnitString() unit for base #base and digit group #digitGroup"() {
        when:
        def result = SizeUnit.get(base, digitGroup)

        then:
        result == expected

        where:
        base   || digitGroup || expected
        SI     || 0          || BYTE
        SI     || 1          || KILO_BYTE
        SI     || 2          || MEGA_BYTE
        SI     || 3          || GIGA_BYTE
        BINARY || 0          || BYTE
        BINARY || 1          || KIBI_BYTE
        BINARY || 2          || MEBI_BYTE
        BINARY || 3          || GIBI_BYTE
    }

    @Unroll
    def "should throw an exception when not proper base #base or digit group #digitGroup is used"() {
        when:
        SizeUnit.get(base, digitGroup)

        then:
        thrown(IllegalArgumentException)

        where:
        base   || digitGroup
        BINARY || Integer.MAX_VALUE
        SI     || Integer.MIN_VALUE
        null   || Integer.MIN_VALUE
    }
}
