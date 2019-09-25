package com.etoitau.leetcode.palindromenumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class SolutionTest {
    @Test
    void isPalindrome() {
        int input;
        boolean result;
        Solution sol = new Solution();

        input = 0;
        result = true;
        assertEquals(result, sol.isPalindrome(input));

        input = 9;
        result = true;
        assertEquals(result, sol.isPalindrome(input));

        input = -1;
        result = false;
        assertEquals(result, sol.isPalindrome(input));

        input = 11;
        result = true;
        assertEquals(result, sol.isPalindrome(input));

        input = 21;
        result = false;
        assertEquals(result, sol.isPalindrome(input));

        input = 121;
        result = true;
        assertEquals(result, sol.isPalindrome(input));

        input = 1221;
        result = true;
        assertEquals(result, sol.isPalindrome(input));

        input = 1231;
        result = false;
        assertEquals(result, sol.isPalindrome(input));

    }
}