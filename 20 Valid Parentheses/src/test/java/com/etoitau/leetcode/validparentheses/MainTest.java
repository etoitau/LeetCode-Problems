package com.etoitau.leetcode.validparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void isValidTest() {
        String input;
        boolean expected;
        Solution sol = new Solution();

        input = "";
        expected = true;
        assertEquals(expected, sol.isValid(input));

        input = "()";
        expected = true;
        assertEquals(expected, sol.isValid(input));

        input = "()[]{}";
        expected = true;
        assertEquals(expected, sol.isValid(input));

        input = "(]";
        expected = false;
        assertEquals(expected, sol.isValid(input));

        input = ")(";
        expected = false;
        assertEquals(expected, sol.isValid(input));

        input = "([)]";
        expected = false;
        assertEquals(expected, sol.isValid(input));

        input = "{[]}";
        expected = true;
        assertEquals(expected, sol.isValid(input));

        input = "(a)[b]{c}";
        expected = false;
        assertEquals(expected, sol.isValid(input));
    }
}