package com.kraluk.playground.algorithm.rpn.solver;

import com.kraluk.playground.algorithm.common.exception.PlaygroundException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Simple String-based equation solver, which uses JavaScript {@link ScriptEngine}
 */
final class JsEquationSolver implements EquationSolver {

    private static final String JS_ENGINE = "js";

    private final ScriptEngineManager manager;
    private final ScriptEngine engine;

    JsEquationSolver() {
        manager = new ScriptEngineManager();
        engine = manager.getEngineByName(JS_ENGINE);
    }

    public String solve(final String expression) {
        try {
            return String.valueOf(engine.eval(expression));
        } catch (ScriptException e) {
            throw new PlaygroundException(
                String.format("Unable to evaluate following expression '%s'!", expression), e);
        }
    }
}
