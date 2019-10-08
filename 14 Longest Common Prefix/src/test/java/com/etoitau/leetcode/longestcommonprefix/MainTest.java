package com.etoitau.leetcode.longestcommonprefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solution() {
        Solution sol = new Solution();
        String[] strs;
        String expected;

        strs = new String[]{"flower","flow","flight"};
        expected = "fl";
        assertEquals(expected, sol.longestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        expected = "";
        assertEquals(expected, sol.longestCommonPrefix(strs));

        strs = new String[]{"test", "tester", "tested"};
        expected = "test";
        assertEquals(expected, sol.longestCommonPrefix(strs));

        strs = new String[]{"test", "", "tested"};
        expected = "";
        assertEquals(expected, sol.longestCommonPrefix(strs));

        strs = new String[]{"test"};
        expected = "test";
        assertEquals(expected, sol.longestCommonPrefix(strs));

        strs = null;
        expected = "";
        assertEquals(expected, sol.longestCommonPrefix(strs));

        strs = new String[]{};
        expected = "";
        assertEquals(expected, sol.longestCommonPrefix(strs));
    }
}