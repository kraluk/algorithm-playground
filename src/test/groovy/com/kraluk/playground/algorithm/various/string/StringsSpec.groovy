package com.kraluk.playground.algorithm.various.string

import com.kraluk.playground.algorithm.enums.CaseType
import com.kraluk.playground.algorithm.various.string.Strings
import spock.lang.Specification

class StringsSpec extends Specification {

    def "reverse a given string"() {

        expect:
            Strings.reverse(input) == expected

        where:
            input   | expected
            "Trash" | "hsarT"
            "BuBa"  | "aBuB"
    }

    def "is first letter a capital one?"() {

        expect:
            Strings.isCapital(input) == expected

        where:
            input             | expected
            "Warum"           | true
            "wARUM"           | false
            "888yyyUUU"       | false
            "&^^%^&%^&%*(&&(" | false
    }

    def "is first letter lowercase or uppercase?"() {

        expect:
            Strings.isUpperOrLower(input) == expected

        where:
            input             | expected
            "Warum"           | CaseType.UPPER
            "wARUM"           | CaseType.LOWER
            "888yyyUUU"       | CaseType.NA
            "&^^%^&%^&%*(&&(" | CaseType.NA
    }

    def "change first letter"() {
        expect:
            Strings.changeFirstCharacter(input) == expected

        where:
            input             | expected
            "Warum"           | "warum"
            "wARUM"           | "WARUM"
            "888yyyUUU"       | ""
            "&^^%^&%^&%*(&&(" | ""
    }

    def "justify to left"() {
        expect:
            Strings.justifyLeft(input, lenght) == expected

        where:
            input   | lenght | expected
            "TERRA" | 10     | "     TERRA"
            "TERRA" | 2      | "TERRA"
    }

    def "justify to right"() {
        expect:
            Strings.justifyRight(input, lenght) == expected

        where:
            input   | lenght | expected
            "TERRA" | 10     | "TERRA     "
            "TERRA" | 2      | "TERRA"
    }
}