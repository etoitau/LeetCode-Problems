package com.etoitau.leetcode.generateparentheses;

import java.util.*;

/**
 * LeetCode Problem 22 - Generate Parentheses
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00% (tied with 6.5% in 0ms bin)
 * Memory Usage: 36 MB, less than 100.00%
 *
 * Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        int solSize = solutionSize(n);
        List<String> parens = new ArrayList<>(solSize);
        char[] start = new char[2 * n];
        start[0] = '(';
        fillArray(parens, start, 1, n - 1);
        return parens;
    }

    private void fillArray(List<String> parens, char[] base, int index, int oLeft) {
        int cLeft = base.length - index - oLeft;
        if (oLeft > 0) {
            // if haven't used all open parens yet,
            if (cLeft > oLeft) {
                // fork one with and keep base without
                char[] oCase = base.clone();
                oCase[index] = '(';
                fillArray(parens, oCase, index + 1, oLeft - 1);
                base[index] = ')';
                fillArray(parens, base, index + 1, oLeft);
            } else {
                base[index] = '(';
                fillArray(parens, base, index + 1, oLeft - 1);
            }
        } else if (oLeft == 0) {
            // if no opens left, fill in rest with closed and add
            for (int i = index; i < base.length; i++) {
                base[i] = ')';
            }
            parens.add(new String(base));
        }
    }

    /**
     * Solution size is the nth Catalan number
     */
    private int solutionSize(int n) {
        long f = factorial(2 * n) / (factorial(n + 1) * factorial(n));
        if (f > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) f;
        }

    }

    private long factorial(int num) {
        long fact = 1;
        for (long i = 2; i <= (long) num; i++) {
            fact = fact * i;
        }
        return fact;
    }
}

