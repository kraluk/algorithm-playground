package com.kraluk.playground.algorithm.common

import com.kraluk.playground.algorithm.common.Maths
import spock.lang.Specification

class MathsSpec extends Specification {

    def "checks if the given number is a palindrome"() {

        expect:
        Maths.isPalindrome(number) == expected

        where:
        number  | expected
        9009    | true
        9111    | false
        123321  | true
        4445444 | true
        4449555 | false
    }

    def "checks if the given number is a palindrome (optimized)"() {

        expect:
        Maths.isPalindromeOptimized(number) == expected

        where:
        number  | expected
        9009    | true
        9111    | false
        123321  | true
        4445444 | true
        4449555 | false
    }

    def "reverses given number"() {

        expect:
        Maths.reverse(number) == expected

        where:
        number  | expected
        5678    | 8765
        9111    | 1119
        666999  | 999666
        5556777 | 7776555
        1234567 | 7654321
    }
}