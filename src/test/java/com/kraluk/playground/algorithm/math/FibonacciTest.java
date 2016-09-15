package com.kraluk.playground.algorithm.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void iterativeTest() {
        long result = Fibonacci.iterative(10);

        assertEquals(55, result);
    }

    @Test
    public void iterativeTwoTest() {
        long result = Fibonacci.iterative(19);

        assertEquals(4181, result);
    }

    @Test
    public void zeroIterativeTest() {
        long result = Fibonacci.iterative(0);

        assertEquals(0, result);
    }

    @Test
    public void oneIterativeTest() {
        long result = Fibonacci.iterative(1);

        assertEquals(1, result);
    }

    @Test
    public void recursiveTest() {
        long result = Fibonacci.recursive(10);

        assertEquals(55, result);
    }

    @Test
    public void recursiveTwoTest() {
        long result = Fibonacci.recursive(19);

        assertEquals(4181, result);
    }

    @Test
    public void zeroRecursiveTest() {
        long result = Fibonacci.recursive(0);

        assertEquals(0, result);
    }

    @Test
    public void oneRecursiveTest() {
        long result = Fibonacci.recursive(1);

        assertEquals(1, result);
    }
}