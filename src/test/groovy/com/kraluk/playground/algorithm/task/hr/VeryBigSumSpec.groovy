package com.kraluk.playground.algorithm.task.hr

import spock.lang.Specification

class VeryBigSumSpec extends Specification {

    def "should calculate a sum of integers based on the input string"() {

        when:
        def actual = VeryBigSum.calculate(input)

        then:
        expected == actual

        where:
        size || input                                                               || expected
        5    || "1000000001 1000000002 1000000003 1000000004 1000000005"            || 5000000015l
        6    || "2000000001 2000000002 2000000003 2000000004 2000000005 2000000005" || 12000000020l
    }

    def "should run by invoking main method"() {
        given:
        def inStream = new ByteArrayInputStream(input.getBytes())
        System.setIn(inStream)

        def outStream = new ByteArrayOutputStream()
        System.setOut(new PrintStream(outStream))

        when:
        VeryBigSum.main()

        then:
        output == outStream.toString()

        where:
        input                                                                    || output  // output also contains new line char
        "5\n1000000001 1000000002 1000000003 1000000004 1000000005\n"            || "5000000015\n"
        "6\n2000000001 2000000002 2000000003 2000000004 2000000005 2000000005\n" || "12000000020\n"
    }
}