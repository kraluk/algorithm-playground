package com.kraluk.playground.algorithm.math;

import org.junit.Assert;
import org.junit.Test;

public class CircleTest {

    @Test
    public void calculateAreaTest() {
        double area = Circle.calculateArea(6);
        double expected = 6 * 6 * Math.PI;

        Assert.assertEquals(expected, area, 0);
    }
}