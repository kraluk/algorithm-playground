package com.kraluk.playground.algorithm.euler

import spock.lang.Ignore
import spock.lang.Specification

class LargestPalindromeProductSpec extends Specification {

    def "find the largest palindrome made from the product of two given-digit numbers"() {

        expect:
        LargestPalindromeProduct.calculate(digits) == expected

        where:
        digits | expected
        2      | 9009
        3      | 906609
        //4      | 99000099
    }

    @Ignore
    def "find the largest palindrome made from the product of two given-digit numbers (basic)"() {

        expect:
        LargestPalindromeProduct.calculateBasic(digits) == expected

        where:
        digits | expected
        2      | 9009
        3      | 906609
        4      | 99000099
    }

    @Ignore
    def "find the largest palindrome made from the product of two given-digit numbers (improved)"() {

        expect:
        LargestPalindromeProduct.calculateImproved(digits) == expected

        where:
        digits | expected
        2      | 9009
        3      | 906609
        4      | 99000099
    }

    @Ignore
    def "find the largest palindrome made from the product of two given-digit numbers (optimized)"() {

        expect:
        LargestPalindromeProduct.calculateOptimized(digits) == expected

        where:
        digits | expected
        2      | 9009
        3      | 906609
        4      | 99000099
    }
}