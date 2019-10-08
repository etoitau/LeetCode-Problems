package com.etoitau.leetcode.lettercombophone;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void letterCombinationsTest() {
        Solution sol = new Solution();
        String in;
        List<String> expected;
        List<String> result;

        in = "23";
        expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        result = sol.letterCombinations(in);
        assertTrue(expected.equals(result));

        in = "7";
        expected = Arrays.asList("p", "q", "r", "s");
        result = sol.letterCombinations(in);
        assertTrue(expected.equals(result));

        in = "89";
        expected = Arrays.asList("tw", "tx", "ty", "tz", "uw", "ux", "uy", "uz", "vw", "vx", "vy", "vz");
        result = sol.letterCombinations(in);
        assertTrue(expected.equals(result));
    }

}