package com.etoitau.leetcode.dividetwointegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void main() {
        Solution sol = new Solution();

        int divisor;
        int dividend;
        int expected;

        dividend = 10;
        divisor = 3;
        expected = 3;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = 7;
        divisor = 3;
        expected = 2;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = 7;
        divisor = -3;
        expected = -2;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = 1;
        divisor = 1;
        expected = 1;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = -2147483648;
        divisor = -1;
        expected = 2147483647;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = 2147483647;
        divisor = 1;
        expected = 2147483647;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = 2147483647;
        divisor = 2;
        expected = 1073741823;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = -2147483648;
        divisor = 2;
        expected = -1073741824;
        assertEquals(expected, sol.divide(dividend, divisor));

        dividend = 20;
        divisor = 200;
        expected = 0;
        assertEquals(expected, sol.divide(dividend, divisor));
    }
}