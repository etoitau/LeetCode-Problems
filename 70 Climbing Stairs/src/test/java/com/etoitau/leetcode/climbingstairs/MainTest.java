package com.etoitau.leetcode.climbingstairs;

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
        assertEquals(solver.climbStairs(2), 2);
        assertEquals(solver.climbStairs(3), 3);
    }

}