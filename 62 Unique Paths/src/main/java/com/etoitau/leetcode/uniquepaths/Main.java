package com.etoitau.leetcode.uniquepaths;


public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.uniquePaths(3, 4));
    }
}


class Solution {
    private static int[][] memo = new int[101][101];

    public int uniquePaths(int m, int n) {
        // From a given square, the number of possible paths is the sum of the possible paths from each square you
        // could move to. This is a dynamic programing situation.
        // Since the space of m and n is not very big, just create a matrix of that size and initilize it will
        // solutions, so each call to this function is just a lookup.
        if (memo[1][1] != 1) {
            init();
        }
        return memo[m][n];
    }

    private static void init() {
        for (int i = 0; i < memo.length; i++) {
            memo[1][i] = 1;
            memo[i][1] = 1;
        }
        for (int i = 2; i < memo.length; i++) {
            for (int j = i; j < memo.length; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                memo[j][i] = memo[i][j];
            }
        }
    }
}
