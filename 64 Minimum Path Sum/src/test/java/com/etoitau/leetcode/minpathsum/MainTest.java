package com.etoitau.leetcode.minpathsum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution solver = new Solution();
        int[][] grid;
        int ans;

        grid = new int[][]{{1, 1, 1}, {1, 7, 1}};
        ans = 4;
        assertEquals(ans, solver.minPathSum(grid));

        grid = new int[][]{{1}, {2}};
        ans = 3;
        assertEquals(ans, solver.minPathSum(grid));

        grid = new int[][]{{1, 2}};
        ans = 3;
        assertEquals(ans, solver.minPathSum(grid));

        grid = new int[][]{{4}};
        ans = 4;
        assertEquals(ans, solver.minPathSum(grid));

        grid = new int[][]{{1, 2, 3}, {4, 5, 6}};
        ans = 12;
        assertEquals(ans, solver.minPathSum(grid));

        grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        ans = 7;
        assertEquals(ans, solver.minPathSum(grid));
    }

}