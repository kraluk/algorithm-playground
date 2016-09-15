package com.kraluk.playground.algorithm.math;

import org.junit.Assert;
import org.junit.Test;

public class PowerOfTwoTest {

    @Test
    public void bruteForceTest() {
        boolean result = PowerOfTwo.bruteForce(1111);

        Assert.assertEquals(false, result);
    }

    @Test
    public void bruteForceTwoTest() {
        boolean result = PowerOfTwo.bruteForce(1024);

        Assert.assertEquals(true, result);
    }

    @Test
    public void bruteForceThreeTest() {
        boolean result = PowerOfTwo.bruteForce(1024 * 2 * 2);

        Assert.assertEquals(true, result);
    }

    @Test
    public void logTest() {
        boolean result = PowerOfTwo.logarithm(1111);

        Assert.assertEquals(false, result);
    }

    @Test
    public void logTwoTest() {
        boolean result = PowerOfTwo.logarithm(1024);

        Assert.assertEquals(true, result);
    }

    @Test
    public void logThreeTest() {
        boolean result = PowerOfTwo.logarithm(1024 * 2 * 2);

        Assert.assertEquals(true, result);
    }

    @Test
    public void bitTest() {
        boolean result = PowerOfTwo.bitwise(1111);

        Assert.assertEquals(false, result);
    }

    @Test
    public void bitTwoTest() {
        boolean result = PowerOfTwo.bitwise(1024);

        Assert.assertEquals(true, result);
    }

    @Test
    public void bitThreeTest() {
        boolean result = PowerOfTwo.bitwise(1024 * 2 * 2);

        Assert.assertEquals(true, result);
    }

    @Test
    public void bitT2est() {
        boolean result = PowerOfTwo.bitwiseOtherApproach(1111);

        Assert.assertEquals(false, result);
    }

    @Test
    public void bit2TwoTest() {
        boolean result = PowerOfTwo.bitwiseOtherApproach(1024);

        Assert.assertEquals(true, result);
    }

    @Test
    public void bit2ThreeTest() {
        boolean result = PowerOfTwo.bitwiseOtherApproach(1024 * 2 * 2);

        Assert.assertEquals(true, result);
    }
}