package com.etoitau.leetcode.nextpermutation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        int[] input;
        int[] expected;
        Solution sol = new Solution();

        input = new int[]{1, 2, 3};
        expected = new int[]{1, 3, 2};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{3, 2, 1};
        expected = new int[]{1, 2, 3};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1, 1, 5};
        expected = new int[]{1, 5, 1};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1, 2, 3, 4};
        expected = new int[]{1, 2, 4, 3};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1, 2, 4, 3};
        expected = new int[]{1, 3, 2, 4};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1, 4, 3, 2};
        expected = new int[]{2, 1, 3, 4};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{};
        expected = new int[]{};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1};
        expected = new int[]{1};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1, 4};
        expected = new int[]{4, 1};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));

        input = new int[]{1, 1};
        expected = new int[]{1, 1};
        sol.nextPermutation(input);
        assertTrue(Arrays.equals(expected, input));
    }
}