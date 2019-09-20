package com.etoitau.leetcode.six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void convert() {
        String testString, testOut;
        int testRows = 0;
        Solution sol = new Solution();

        testString = "PAYPALISHIRING";
        testRows = 3;
        testOut = "PAHNAPLSIIGYIR";
        assertEquals(testOut, sol.convert(testString, testRows));

        testString = "PAYPALISHIRING";
        testRows = 4;
        testOut = "PINALSIGYAHRPI";
        assertEquals(testOut, sol.convert(testString, testRows));

        testString = "abcdefghijk";
        testRows = 1;
        testOut = "abcdefghijk";
        assertEquals(testOut, sol.convert(testString, testRows));

        testString = "abcdefghijk";
        testRows = 2;
        testOut = "acegikbdfhj";
        assertEquals(testOut, sol.convert(testString, testRows));

        testString = "abcdefghijk";
        testRows = 3;
        testOut = "aeibdfhjcgk";
        assertEquals(testOut, sol.convert(testString, testRows));

        testString = "abcdefghijk";
        testRows = 4;
        testOut = "agbfhceikdj";
        assertEquals(testOut, sol.convert(testString, testRows));
    }
}