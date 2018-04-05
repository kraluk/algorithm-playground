package com.kraluk.playground.algorithm.rpn.solver

import com.kraluk.playground.algorithm.common.exception.PlaygroundException
import spock.lang.Specification
import spock.lang.Unroll

class JsEquationSolverSpec extends Specification {

    @Unroll
    def "should evaluate #expression and get result #expected"() {
        given:
        def solver = new JsEquationSolver()

        when:
        def result = solver.solve(expression)

        then:
        Double.parseDouble(result) == expected.doubleValue()

        where:
        expression || expected
        "2+2"      || 4.0
        "5*5"      || 25.0
        "3/3"      || 1.0
        "4-3"      || 1.0
    }

    def "should thrown an exception when the expression is not parsable"() {
        given:
        def solver = new JsEquationSolver()
        def expression = "foobarfoobar"

        when:
        solver.solve(expression)

        then:
        thrown(PlaygroundException)
    }
}
