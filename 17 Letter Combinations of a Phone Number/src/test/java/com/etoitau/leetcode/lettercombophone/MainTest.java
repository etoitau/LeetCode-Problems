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
    }

    @Test
    void inc3Test() {
        Solution sol = new Solution();
        int[] in;
        int[] out;


        in = new int[]{0, 0, 0};
        sol.inc3(in);
        sol.inc3(in);
        sol.inc3(in);
        out = new int[]{0, 1, 0};
        assertTrue(Arrays.equals(in, out));

    }
}