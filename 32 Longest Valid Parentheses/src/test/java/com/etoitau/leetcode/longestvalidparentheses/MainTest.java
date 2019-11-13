package com.etoitau.leetcode.longestvalidparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        String s;
        int expected, result;

        s = "(()";
        expected = 2;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = ")()())";
        expected = 4;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "()(()))())";
        expected = 6;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "((()";
        expected = 2;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "(())((";
        expected = 4;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "";
        expected = 0;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = ")";
        expected = 0;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = ")(";
        expected = 0;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "()";
        expected = 2;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "(()()))(()";
        expected = 6;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "(()())";
        expected = 6;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "(())()(()((";
        expected = 6;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);

        s = "()()";
        expected = 4;
        result = sol.longestValidParentheses(s);
        assertEquals(expected, result);
    }
}