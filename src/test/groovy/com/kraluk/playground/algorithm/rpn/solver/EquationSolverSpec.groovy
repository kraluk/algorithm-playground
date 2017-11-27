package com.kraluk.playground.algorithm.rpn.solver

import spock.lang.Specification
import spock.lang.Unroll

class EquationSolverSpec extends Specification {

    @Unroll
    def "should get #expected for type #type"() {
        when:
        def result = EquationSolver.get(type)

        then:
        result.class == expected

        where:
        type                                  || expected
        EquationSolver.SolverType.EXP4J       || Exp4jEquationSolver.class
        EquationSolver.SolverType.JAVA_SCRIPT || JsEquationSolver.class
    }
}
