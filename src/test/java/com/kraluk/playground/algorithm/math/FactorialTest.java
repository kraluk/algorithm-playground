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
    public void recursiveTest() {

        long result = Factorial.recursive(4);

        Assert.assertEquals(24, result);
    }
}