package com.kraluk.playground.algorithm.string;

import com.kraluk.playground.algorithm.enums.CaseType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void reverseTest() {
        String input = "Trash";
        CharSequence output = Strings.reverse(input);

        assertEquals("hsarT", output);
    }

    @Test
    public void reverseTwoTest() {
        String input = "BuBa";
        CharSequence output = Strings.reverse(input);

        assertEquals("aBuB", output);
    }

    @Test
    public void isCapitalTest() {
        String input = "Warum";
        boolean result = Strings.isCapital(input);

        assertEquals(true, result);
    }

    @Test
    public void isCapitalTwoTest() {
        String input = "wARUM";
        boolean result = Strings.isCapital(input);

        assertEquals(false, result);
    }

    @Test
    public void isCapitalThreeTest() {
        String input = "888yyyUUU";
        boolean result = Strings.isCapital(input);

        assertEquals(false, result);
    }

    @Test
    public void isCapitalFourTest() {
        String input = "&^^%^&%^&%*(&&(";
        boolean result = Strings.isCapital(input);

        assertEquals(false, result);
    }

    @Test
    public void isUpperOrLowerTest() {
        String input = "Warum";
        CaseType result = Strings.isUpperOrLower(input);

        assertEquals(CaseType.UPPER, result);
    }

    @Test
    public void isUpperOrLowerTwoTest() {
        String input = "wARUM";
        CaseType result = Strings.isUpperOrLower(input);

        assertEquals(CaseType.LOWER, result);
    }

    @Test
    public void isUpperOrLowerThreeTest() {
        String input = "888yyyUUU";
        CaseType result = Strings.isUpperOrLower(input);

        assertEquals(CaseType.NA, result);
    }

    @Test
    public void isUpperOrLowerFourTest() {
        String input = "&^^%^&%^&%*(&&(";
        CaseType result = Strings.isUpperOrLower(input);

        assertEquals(CaseType.NA, result);
    }

    @Test
    public void changeFirstCharacterTest() {
        String input = "Warum";
        String result = Strings.changeFirstCharacter(input);

        assertEquals("warum", result);
    }

    @Test
    public void changeFirstCharacterTwoTest() {
        String input = "wARUM";
        String result = Strings.changeFirstCharacter(input);

        assertEquals("WARUM", result);
    }

    @Test
    public void changeFirstCharacterThreeTest() {
        String input = "888yyyUUU";
        String result = Strings.changeFirstCharacter(input);

        assertEquals("", result);
    }

    @Test
    public void justifyLeftTest() {
        String input = "TERRA";
        String result = Strings.justifyLeft(input, 10);

        assertEquals("     TERRA", result);
    }

    @Test
    public void justifyLeftTwoTest() {
        String input = "TERRA";
        String result = Strings.justifyLeft(input, 2);

        assertEquals("TERRA", result);
    }

    @Test
    public void justifyRightTest() {
        String input = "TERRA";
        String result = Strings.justifyRight(input, 10);

        assertEquals("TERRA     ", result);
    }

    @Test
    public void justifyRightTwoTest() {
        String input = "TERRA";
        String result = Strings.justifyRight(input, 2);

        assertEquals("TERRA", result);
    }
}