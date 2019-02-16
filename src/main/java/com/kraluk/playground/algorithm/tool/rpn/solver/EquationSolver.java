package com.kraluk.playground.algorithm.tool.rpn.solver;

@FunctionalInterface
public interface EquationSolver {

    String solve(final String expression);

    static EquationSolver get(SolverType solverType) {
        switch (solverType) {
            case EXP4J:
                return new Exp4jEquationSolver();

            case JAVA_SCRIPT:
                return new JsEquationSolver();

            default:
                throw new UnsupportedOperationException(
                    String.format("Type '%s' is not supported!", solverType));
        }
    }

    enum SolverType {
        JAVA_SCRIPT,
        EXP4J
    }
}
