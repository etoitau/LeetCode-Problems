package com.etoitau.leetcode.sqrtx;

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

        assertEquals(solver.mySqrt(2147395599), 46339);
        assertEquals(solver.mySqrt(4), 2);
        assertEquals(solver.mySqrt(8), 2);

        for (int n = 0; n < 100; n++) {
            int expected = (int) Math.floor(Math.sqrt(n));
            int result = solver.mySqrt(n);
            assertEquals(result, expected, String.format("Error for n: %d. Expected %d, got %d", n, expected, result));
        }
    }

}