package com.etoitau.leetcode.dividetwointegers;

/**
 * LeetCode Problem 29 - Divide Two Integers
 *
 * Result:
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 33.9 MB, less than 6.06%
 *
 * Description:
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */
class Solution {
    public int divide(int dividend, int divisor) {
        // a couple special cases
        if (divisor == 1) { return dividend; }
        if (dividend == Integer.MIN_VALUE && divisor == -1) { return Integer.MAX_VALUE; }

        long result = 0; // build up result here

        // approach will be basically long division in base 2
        // start by shifting divisor over to match scale of dividend. shifts is how many times we have shifted over
        int shifts = 0;
        // place is how much to add to result at current shift
        long place = 1;

        // if answer should be negative, use -1 as base of number to add to result
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) { place = -1; }

        // get rid of sign and put in long variable to avoid overflow issues
        long ldivid = Math.abs( (long) dividend);
        long ldivis = Math.abs( (long) divisor);

        // trivial case
        if (ldivid < ldivis) { return 0; }

        // shift divisor over as far as possible
        while (ldivis < ldivid) {
            ldivis = ldivis << 1;
            place = place << 1;
            shifts++;
        }

        // in each position, subtract from dividend if appropriate and add place to result
        for (int i = 0; i < shifts + 1; i++) {
            if (ldivis <= ldivid) {
                ldivid -= ldivis;
                result += place;
            }
            place = place >> 1;
            ldivis = ldivis >> 1;
        }

        // has to be int, so fix overflows
        if (result < Integer.MIN_VALUE) { return Integer.MIN_VALUE; }
        if (result > Integer.MAX_VALUE) { return Integer.MAX_VALUE; }

        return (int) result;
    }
}
