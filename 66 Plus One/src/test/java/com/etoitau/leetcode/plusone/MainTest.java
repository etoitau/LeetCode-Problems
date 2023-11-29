package com.etoitau.leetcode.plusone;

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
        int[] digits;
        int[] expect;

        digits = new int[]{9, 9};
        expect = new int[]{1, 0, 0};
        assertArrayEquals(expect, solver.plusOne(digits));

        digits = new int[]{9, 8};
        expect = new int[]{9, 9};
        assertArrayEquals(expect, solver.plusOne(digits));

        digits = new int[]{1, 9, 9};
        expect = new int[]{2, 0, 0};
        assertArrayEquals(expect, solver.plusOne(digits));

        digits = new int[]{1};
        expect = new int[]{2};
        assertArrayEquals(expect, solver.plusOne(digits));

        // Given examples
        digits = new int[]{1, 2, 3};
        expect = new int[]{1, 2, 4};
        assertArrayEquals(expect, solver.plusOne(digits));

        digits = new int[]{4, 3, 2, 1};
        expect = new int[]{4, 3, 2, 2};
        assertArrayEquals(expect, solver.plusOne(digits));

        digits = new int[]{9};
        expect = new int[]{1, 0};
        assertArrayEquals(expect, solver.plusOne(digits));
    }

}