package com.etoitau.leetcode.climbingstairs;


public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.climbStairs(5));
    }
}


class Solution {
    static private int[] memo = new int[46];
    static {
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i < 46; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
    }

    public int climbStairs(int n) {
        // This can be solved with dynamic programming
        // Since we can only step by 1 or 2, to step to the nth step we must have stepped
        // from the n - 1 or n - 2 step. So the total number of ways to get to the nth step
        // is the sum of the solutions for n - 1 and n - 2.
        // Note a series where each term is the sum of the two previous terms is the
        // Fibonacci series.
        return memo[n];
    }
}
