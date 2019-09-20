package com.etoitau.leetcode.seven;

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * LeetCode Problem 7 - Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Runtime: 2 ms, faster than 23.52%
 * Memory Usage: 33.8 MB, less than 11.11%
 */
class Solution {
    public int reverse(int x) {
        if (x > -10 && x < 10) { return x; }

        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= sign;
        }

        StringBuilder sb = new StringBuilder();
        try {
            x = Integer.parseInt(sb.append(x).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return x * sign;
    }
}