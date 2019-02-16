package com.kraluk.playground.algorithm.tool.rpn

import spock.lang.Specification
import spock.lang.Unroll

import static com.kraluk.playground.algorithm.tool.rpn.solver.EquationSolver.SolverType.EXP4J
import static com.kraluk.playground.algorithm.tool.rpn.solver.EquationSolver.SolverType.JAVA_SCRIPT

class ReversePolishNotationParserSpec extends Specification {

    @Unroll
    def "should parse '#expression' with solver '#solverType' and get result value #expected"() {
        given:
        def parser = new ReversePolishNotationParser(solverType)

        when:
        def result = parser.parse(expression)

        then:
        result == expected

        where:
        solverType  || expression                   || expected
        JAVA_SCRIPT || "2.4 5.1 +"                  || 7.5
        JAVA_SCRIPT || "12 2 3 4 * 10 5 / + * +"    || 40
        JAVA_SCRIPT || "2 7 + 3 / 14 3 - 4 * + 2 /" || 23.5
        EXP4J       || "2.4 5.1 +"                  || 7.5
        EXP4J       || "12 2 3 4 * 10 5 / + * +"    || 40
        EXP4J       || "2 7 + 3 / 14 3 - 4 * + 2 /" || 23.5
    }

    def "should throw an exception when the input expression is not valid or nullified"() {
        given:
        def parser = new ReversePolishNotationParser()

        when:
        parser.parse(expression)

        then:
        thrown(IllegalArgumentException)

        where:
        expression << [null, "sdfsfd sfsdf"]
    }
}
