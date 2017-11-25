package com.kraluk.playground.algorithm.hr

import spock.lang.Specification

class PlusMinusSpec extends Specification {

    def "parses a String input to the 1D integer array"() {
        given:
        def input = "11 2 4"
        def expected = [11, 2, 4] as int[]

        when:
        def actual = PlusMinus.parseInput(input)

        then:
        actual == expected
    }

    def "calculates plus/minus/zero's ratios"() {
        when:
        def actual = PlusMinus.calculate(size, input)

        then:
        actual == expected

        where:
        size || input                         || expected
        6    || [-4, 3, -9, 0, 4, 1] as int[] || [0.5, 0.3333333333333333, 0.16666666666666666] as double[]

    }

    def "should run by invoking main method"() {
        given:
        def inStream = new ByteArrayInputStream(input.getBytes())
        System.setIn(inStream)

        def outStream = new ByteArrayOutputStream()
        System.setOut(new PrintStream(outStream))

        when:
        PlusMinus.main()

        then:
        output == outStream.toString()

        where:
        input                || output  // output also contains new line char
        "6\n-4 3 -9 0 4 1\n" || "0.500000\n0.333333\n0.166667\n"
    }
}