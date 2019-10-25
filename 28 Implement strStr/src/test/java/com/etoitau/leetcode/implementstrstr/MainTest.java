package com.etoitau.leetcode.implementstrstr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        String haystack, needle;
        int expected, result;

        haystack = "hello";
        needle = "ll";
        expected = 2;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);

        haystack = "aaaaa";
        needle = "bba";
        expected = -1;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);

        haystack = "aba";
        needle = "";
        expected = 0;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);

        haystack = "aba";
        needle = "ba";
        expected = 1;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);

        haystack = "aba";
        needle = "aba";
        expected = 0;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);

        haystack = "aba";
        needle = "ab";
        expected = 0;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);

        haystack = "";
        needle = "1";
        expected = -1;
        result = sol.strStr(haystack, needle);
        assertEquals(expected, result);
    }
}