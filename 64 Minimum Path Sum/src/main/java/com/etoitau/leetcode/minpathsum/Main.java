package com.etoitau.leetcode.minpathsum;


public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solver.minPathSum(grid));
    }
}


class Solution {

    public int minPathSum(int[][] grid) {
        int colLen = grid.length;
        int rowLen = grid[0].length;
        // Leetcode performance would be better if we did this in-place in grid
        // but I'd consider that bad practice unless the documented purpose of the function
        // is to modify the input.
        int[][] memo = new int[colLen][rowLen];
        memo[colLen - 1][rowLen - 1] = grid[colLen - 1][rowLen - 1];
        // Fill in last row
        for (int i = rowLen - 2; i >= 0; i--) {
            memo[colLen - 1][i] = grid[colLen - 1][i] + memo[colLen - 1][i + 1];
        }
        // Fill in last column
        for (int i = colLen - 2; i >= 0; i--) {
            memo[i][rowLen - 1] = grid[i][rowLen - 1] + memo[i + 1][rowLen - 1];
        }
        // Fill in the middle
        for (int i = colLen - 2; i >= 0; i--) {
            for (int j = rowLen - 2; j >= 0; j--) {
                memo[i][j] = Math.min(memo[i + 1][j], + memo[i][j + 1]) + grid[i][j];
            }
        }
        return memo[0][0];
    }
}
