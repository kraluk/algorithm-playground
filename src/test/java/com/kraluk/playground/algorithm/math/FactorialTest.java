package com.kraluk.playground.algorithm.math;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void iterativeTest() {

        long result = Factorial.iterative(4);

        Assert.assertEquals(24, result);
    }

    @Test
    public void zeroIterativeTest() {

        long result = Factorial.iterative(0);

        Assert.assertEquals(1, result);
    }

    @Test
    public void oneIterativeTest() {

        long result = Factorial.iterative(1);

        Assert.assertEquals(1, result);
    }

    @Test
    public void recursiveTest() {

        long result = Factorial.recursive(4);

        Assert.assertEquals(24, result);
    }

    @Test
    public void zeroRecursiveTest() {

        long result = Factorial.recursive(0);

        Assert.assertEquals(1, result);
    }

    @Test
    public void oneRecursiveTest() {

        long result = Factorial.recursive(1);

        Assert.assertEquals(1, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionRecursiveTest() {
        long result = Factorial.recursive(-1);
    }
}