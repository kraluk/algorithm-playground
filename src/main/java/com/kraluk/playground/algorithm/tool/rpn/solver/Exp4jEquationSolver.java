package com.kraluk.playground.algorithm.tool.rpn.solver;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Simple equation solver based on the {@code exp4j} library
 */
final class Exp4jEquationSolver implements EquationSolver {

    @Override
    public String solve(final String expression) {
        Expression buildExpression = new ExpressionBuilder(expression).build();
        return String.valueOf(buildExpression.evaluate());
    }
}
