package com.etoitau.leetcode.integertoroman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solution() {
        Solution sol = new Solution();
        int input;
        String expected;

        input = 3;
        expected = "III";
        assertEquals(expected, sol.intToRoman(input));

        input = 4;
        expected = "IV";
        assertEquals(expected, sol.intToRoman(input));

        input = 9;
        expected = "IX";
        assertEquals(expected, sol.intToRoman(input));

        input = 58;
        expected = "LVIII";
        assertEquals(expected, sol.intToRoman(input));

        input = 1994;
        expected = "MCMXCIV";
        assertEquals(expected, sol.intToRoman(input));
    }
}