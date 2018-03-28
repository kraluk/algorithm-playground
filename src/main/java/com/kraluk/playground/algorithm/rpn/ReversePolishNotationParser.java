package com.kraluk.playground.algorithm.rpn;

import com.kraluk.playground.algorithm.rpn.solver.EquationSolver;
import com.kraluk.playground.algorithm.rpn.solver.EquationSolver.SolverType;

import lombok.extern.log4j.Log4j2;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reverse Polish Notation Parser
 * <br/>
 * More algorithm-related details can be found <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">here</a>.
 *
 * @author lukasz
 */
@Log4j2
public final class ReversePolishNotationParser {

    private static final String DELIMITER = " ";
    private static final String TWO_ARG_EXPRESSION_FORMAT = "%s%s%s";

    private static final String EXPRESSION_REGEX = "[0-9\\s+-/*.]*";
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(EXPRESSION_REGEX);

    private final Deque<String> stack;

    private final EquationSolver equationSolver;

    public ReversePolishNotationParser() {
        this.stack = new ArrayDeque<>();
        this.equationSolver = EquationSolver.get(SolverType.EXP4J);
    }

    public double parse(final String expression) {
        checkArgument(expression);

        log.debug("Attempting to evaluate expression '{}' with '{}'", expression,
            equationSolver.getClass().getSimpleName());

        final StringTokenizer tokenizer = new StringTokenizer(expression, DELIMITER);

        while (tokenizer.hasMoreTokens()) {
            final String token = tokenizer.nextToken();

            if (NumberUtils.isCreatable(token)) {
                stack.push(token);
            } else {
                solveSimpleEquation(token);
            }

            log.debug("Stack state: '{}'", Arrays.toString(stack.toArray()));
        }

        String result = stack.pop();
        log.debug("Got result '{}'", result);
        return Double.parseDouble(result);
    }

    private void solveSimpleEquation(final String operator) {
        // If not a digit, therefore in *this* case have to be an operator

        String a = stack.pop();
        String b = stack.pop();

        String evaluated =
            equationSolver.solve(String.format(TWO_ARG_EXPRESSION_FORMAT, b, operator, a));

        stack.push(evaluated);
    }

    private static void checkArgument(final String expression) {
        if (Objects.isNull(expression)) {
            throw new IllegalArgumentException("Given expression cannot be nullified!");
        }

        final Matcher matcher = EXPRESSION_PATTERN.matcher(expression);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                "Given expression is not a valid Polish Reverse Notation expression!");
        }
    }
}
