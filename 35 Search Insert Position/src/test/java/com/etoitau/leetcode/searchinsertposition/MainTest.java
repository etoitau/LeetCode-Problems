package com.etoitau.leetcode.searchinsertposition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        int[] nums;
        int target;
        int expected;
        int result;

        nums = new int[]{1, 3, 5, 6};
        target = 0;
        expected = 0;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 5, 6};
        target = 1;
        expected = 0;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 5, 6};
        target = 2;
        expected = 1;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 5, 6};
        target = 5;
        expected = 2;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 5, 6};
        target = 6;
        expected = 3;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 5, 6};
        target = 7;
        expected = 4;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{};
        target = 7;
        expected = 0;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1};
        target = 7;
        expected = 1;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1};
        target = 1;
        expected = 0;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);

        nums = new int[]{1};
        target = -1;
        expected = 0;
        result = sol.searchInsert(nums, target);
        assertEquals(expected, result);
    }
}