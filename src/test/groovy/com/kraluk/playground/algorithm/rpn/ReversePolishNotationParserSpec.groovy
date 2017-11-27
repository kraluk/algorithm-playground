package com.kraluk.playground.algorithm.rpn

import spock.lang.Specification
import spock.lang.Unroll

class ReversePolishNotationParserSpec extends Specification {

    def parser

    def setup() {
        parser = new ReversePolishNotationParser()
    }

    @Unroll
    def "should parse '#expression' and get result value #expected"() {
        when:
        def result = parser.parse(expression)

        then:
        result == expected

        where:
        expression                   || expected
        "2.4 5.1 +"                  || 7.5
        "12 2 3 4 * 10 5 / + * +"    || 40
        "2 7 + 3 / 14 3 - 4 * + 2 /" || 23.5
    }

    def "should throw an exception when the input expression is not valid or nullified"() {
        when:
        parser.parse(expression)

        then:
        thrown(IllegalArgumentException)

        where:
        expression << [null, "sdfsfd sfsdf"]
    }
}
