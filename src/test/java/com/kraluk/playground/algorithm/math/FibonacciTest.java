package com.kraluk.playground.algorithm.math;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void iterativeTest() {
        long result = Fibonacci.iterative(10);

        Assert.assertEquals(55, result);
    }

    @Test
    public void iterativeTwoTest() {
        long result = Fibonacci.iterative(19);

        Assert.assertEquals(4181, result);
    }

    @Test
    public void recursiveTest() {
        long result = Fibonacci.recursive(10);

        Assert.assertEquals(55, result);
    }

    @Test
    public void recursiveTwoTest() {
        long result = Fibonacci.recursive(19);

        Assert.assertEquals(4181, result);
    }
}