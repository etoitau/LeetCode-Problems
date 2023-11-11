package com.etoitau.leetcode.uniquepathsII;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] obstacles = new int[][]{{0, 0, 0}};
        System.out.println(solver.uniquePathsWithObstacles(obstacles));
    }
}


class Solution {
    private static int[][] memo = new int[101][101];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // From a given square, the number of possible paths is the sum of the possible paths from each square you
        // could move to. This is a dynamic programing situation.
        int colLen = obstacleGrid.length;
        int rowLen = obstacleGrid[0].length;
        int[][] memo = new int[colLen][rowLen];
        // Set last cell
        memo[colLen - 1][rowLen - 1] = (obstacleGrid[colLen - 1][rowLen - 1] == 1) ? 0 : 1;
        // Set last row
        for (int i = rowLen - 2; i >= 0; i--) {
            memo[colLen - 1][i] = (obstacleGrid[colLen - 1][i] == 1) ? 0 : memo[colLen - 1][i + 1];
        }
        // Set last col
        for (int i = colLen - 2; i >= 0; i--) {
            memo[i][rowLen - 1] = (obstacleGrid[i][rowLen - 1] == 1) ? 0 : memo[i + 1][rowLen - 1];
        }
        // Fill in the rest
        for (int i = colLen - 2; i >= 0; i--) {
            for (int j = rowLen - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                    continue;
                }
                memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
            }
        }
        return memo[0][0];
    }
}
