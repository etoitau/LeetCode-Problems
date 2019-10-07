package com.etoitau.leetcode.romantointeger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solution() {
        Solution sol = new Solution();
        String input;
        int expected;

        expected = 3;
        input = "III";
        assertEquals(expected, sol.romanToInt(input));

        expected = 4;
        input = "IV";
        assertEquals(expected, sol.romanToInt(input));

        expected = 9;
        input = "IX";
        assertEquals(expected, sol.romanToInt(input));

        expected = 58;
        input = "LVIII";
        assertEquals(expected, sol.romanToInt(input));

        expected = 1994;
        input = "MCMXCIV";
        assertEquals(expected, sol.romanToInt(input));
    }
}