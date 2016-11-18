package com.kraluk.playground.algorithm.hr

import spock.lang.Specification

class SimpleArraySumSpec extends Specification {

    def "should tokenize given string to list of integers"() {
        given:
            def input = "4 5 6 7 8 9"
            def expected = [4, 5, 6, 7, 8, 9]

        when:
            def actual = SimpleArraySum.Classic.tokenizeInput(input)

        then:
            expected == actual
    }

    def "should sum list of integers"() {
        given:
            def input = [1, 2, 3, 4]
            def expected = 10

        when:
            def actual = SimpleArraySum.Classic.sum(input)

        then:
            expected == actual
    }

    def "should calculate a sum of integers based on the input string"() {

        when:
            def actual = SimpleArraySum.Classic.calculate(input, size)

        then:
            expected == actual

        where:
            size || input           || expected
            6    || "4 5 6 7 8 9"   || 39
            6    || "1 2 3 4 10 11" || 31
    }

    def "should run by invoking main method (classic version)"() {
        given:
            def inStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inStream);

            def outStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outStream));

        when:
            SimpleArraySum.Classic.main()

        then:
            output == outStream.toString()

        where:
            input                || output  // output also contains new line char
            "6\n4 5 6 7 8 9\n"   || "39\n"
            "6\n1 2 3 4 10 11\n" || "31\n"
    }

    def "should calculate a sum of integers based on the input string (compact version)"() {
        given:
            def inStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inStream);

            def outStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outStream));

        when:
            def actual = SimpleArraySum.Compact.calculate(input)

        then:
            expected == actual

        where:
            input           || expected
            "4 5 6 7 8 9"   || 39
            "1 2 3 4 10 11" || 31
    }
}