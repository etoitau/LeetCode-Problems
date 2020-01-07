package com.etoitau.leetcode.countandsay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void get() {
        CountSaySeries css;
        int input;
        String expected, result;

        css = new CountSaySeries();
        input = 3;
        expected = "21";
        result = css.get(input);
        assertEquals(expected, result);

        input = 6;
        expected = "312211";
        result = css.get(input);
        assertEquals(expected, result);

        input = 4;
        expected = "1211";
        result = css.get(input);
        assertEquals(expected, result);

        input = 1;
        expected = "1";
        result = css.get(input);
        assertEquals(expected, result);

        input = 0;
        expected = null;
        result = css.get(input);
        assertEquals(expected, result);

        input = -3;
        expected = null;
        result = css.get(input);
        assertEquals(expected, result);

        css = new CountSaySeries(10);
        input = 4;
        expected = "1211";
        result = css.get(input);
        assertEquals(expected, result);
    }

    @Test
    void toString1() {
        CountSaySeries css = new CountSaySeries();

        String expected, result;

        expected = "1. 1";
        result = css.toString();
        assertEquals(expected, result);

        css.get(3);
        expected = "1. 1\n" +
                "2. 11\n" +
                "3. 21";
        result = css.toString();
        assertEquals(expected, result);
    }

    @Test
    void toCode() {
        CountSaySeries css = new CountSaySeries();

        String expected, result;

        expected = "String[] sequence = new String[] {\n" +
                "    \"1\"\n" +
                "};";
        result = css.toCode();
        assertEquals(expected, result);

        css.get(3);
        expected = "String[] sequence = new String[] {\n" +
                "    \"1\",\n" +
                "    \"11\",\n" +
                "    \"21\"\n" +
                "};";
        result = css.toCode();
        assertEquals(expected, result);
    }

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        int n;
        String expected, result;

        n = 1;
        expected = "1";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 4;
        expected = "1211";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 5;
        expected = "111221";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 15;
        expected = "311311222113111231131112132112311321322112111312211312111322212311322113212221";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 30;
        try {
            sol.countAndSay(n);
        } catch (Exception e) {
            fail();
        }
    }
}