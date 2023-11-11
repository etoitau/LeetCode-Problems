package com.etoitau.leetcode.uniquepathsII;

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
        int[][] obstacles = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int answer = 2;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0, 1}, {0, 0}};
        answer = 1;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0}};
        answer = 1;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0, 1, 0}, {0, 0, 0}};
        answer = 1;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0, 0, 0}};
        answer = 1;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0}, {0}, {0}};
        answer = 1;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        answer = 0;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        answer = 3;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);

        obstacles = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 1, 0}};
        answer = 3;
        assertEquals(solver.uniquePathsWithObstacles(obstacles), answer);
    }

}