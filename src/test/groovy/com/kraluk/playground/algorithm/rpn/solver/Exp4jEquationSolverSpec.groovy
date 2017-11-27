package com.kraluk.playground.algorithm.rpn.solver

import spock.lang.Specification
import spock.lang.Unroll

class Exp4jEquationSolverSpec extends Specification {

    @Unroll
    def "should evaluate #expression and get result #expected"() {
        given:
        def solver = new Exp4jEquationSolver()

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
}
