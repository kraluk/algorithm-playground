package com.kraluk.playground.algorithm.hr

import spock.lang.Specification

class CompareTheTripletsSpec extends Specification {

    def "solve triplets with Bob's and Alice's scores"() {
        when:
        def actual = CompareTheTriplets.solve(alices, bobs)

        then:
        expected == actual

        where:
        alices             || bobs                || expected
        [5, 6, 7] as int[] || [3, 6, 10] as int[] || "1 1"
        [1, 1, 1] as int[] || [1, 1, 1] as int[]  || "0 0"
    }

    def "should return a result to the SOUT"() {
        given:
        def inStream = new ByteArrayInputStream("1\n2\n1\n2\n1\n2\n".getBytes());
        System.setIn(inStream);

        def outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));

        when:
        CompareTheTriplets.main()

        then:
        outStream.toString().matches("\\d+ \\d+\n")
    }
}