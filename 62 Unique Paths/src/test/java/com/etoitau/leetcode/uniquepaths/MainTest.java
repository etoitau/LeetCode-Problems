package com.etoitau.leetcode.uniquepaths;

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
        assertEquals(solver.uniquePaths(3, 7), 28);
        assertEquals(solver.uniquePaths(3, 2), 3);
        assertEquals(solver.uniquePaths(6, 4), 56);
    }

}