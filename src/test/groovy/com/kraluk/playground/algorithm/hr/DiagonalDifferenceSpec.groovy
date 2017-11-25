package com.kraluk.playground.algorithm.hr

import spock.lang.Specification

class DiagonalDifferenceSpec extends Specification {

    def "calculates the difference of diagonals of given matrix"() {
        when:
        def actual = DiagonalDifference.calculate(size, matrix)

        then:
        actual == expected

        where:
        size || matrix                                           || expected
        3    || [[11, 2, 4], [4, 5, 6], [10, 8, -12]] as int[][] || 15

    }

    def "parses a String input to the 2D integer array"() {
        given:
        def input = ["11 2 4", "4 5 6", "10 8 -12"] as String[]
        def expected = [[11, 2, 4], [4, 5, 6], [10, 8, -12]] as int[][]

        when:
        def actual = DiagonalDifference.parseInput(input)

        then:
        actual == expected

    }

    def "should run by invoking main method"() {
        given:
        def inStream = new ByteArrayInputStream(input.getBytes())
        System.setIn(inStream)

        def outStream = new ByteArrayOutputStream()
        System.setOut(new PrintStream(outStream))

        when:
        DiagonalDifference.main()

        then:
        output == outStream.toString()

        where:
        input                          || output  // output also contains new line char
        "3\n11 2 4\n4 5 6\n10 8 -12\n" || "15\n"
    }
}