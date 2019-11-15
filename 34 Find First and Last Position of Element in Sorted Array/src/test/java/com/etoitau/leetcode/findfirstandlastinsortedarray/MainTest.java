package com.etoitau.leetcode.findfirstandlastinsortedarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void findStartTest() {
        Solution sol = new Solution();
        int[] nums;
        int start;
        int foundAt;
        int expected, result;

        nums = new int[]{1, 2, 3, 3, 3, 4, 5};
        start = 0;
        foundAt = 3;
        expected = 2;
        result = sol.findStart(nums, start, foundAt);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 4, 5};
        start = 0;
        foundAt = 1;
        expected = 1;
        result = sol.findStart(nums, start, foundAt);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 4, 5};
        start = 1;
        foundAt = 3;
        expected = 3;
        result = sol.findStart(nums, start, foundAt);
        assertEquals(expected, result);
    }

    @Test
    void findEndTest() {
        Solution sol = new Solution();
        int[] nums;
        int end;
        int foundAt;
        int expected, result;

        nums = new int[]{1, 2, 3, 3, 3, 4, 5};
        end = 6;
        foundAt = 3;
        expected = 4;
        result = sol.findEnd(nums, foundAt, end);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 4, 5};
        end = 2;
        foundAt = 1;
        expected = 1;
        result = sol.findEnd(nums, foundAt, end);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 4, 5};
        end = 3;
        foundAt = 0;
        expected = 0;
        result = sol.findEnd(nums, foundAt, end);
        assertEquals(expected, result);

        nums = new int[]{1, 3, 4, 5, 5, 6};
        end = 5;
        foundAt = 3;
        expected = 4;
        result = sol.findEnd(nums, foundAt, end);
        assertEquals(expected, result);
    }

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        int[] nums, expected, result;
        int target;
        expected = new int[]{-1, -1};

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        expected[0] = 3;
        expected[1] = 4;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        expected[0] = -1;
        expected[1] = -1;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{};
        target = 8;
        expected[0] = -1;
        expected[1] = -1;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{1};
        target = 8;
        expected[0] = -1;
        expected[1] = -1;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{8};
        target = 8;
        expected[0] = 0;
        expected[1] = 0;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 10;
        expected[0] = 5;
        expected[1] = 5;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 5;
        expected[0] = 0;
        expected[1] = 0;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{5, 7, 7, 8, 8, 9, 10};
        target = 9;
        expected[0] = 5;
        expected[1] = 5;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{7, 7, 7, 7};
        target = 7;
        expected[0] = 0;
        expected[1] = 3;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{7, 7, 7, 7};
        target = 4;
        expected[0] = -1;
        expected[1] = -1;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{5, 5, 7, 7, 8, 8, 10};
        target = 5;
        expected[0] = 0;
        expected[1] = 1;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{5, 5, 7, 7, 8, 8, 10, 10};
        target = 10;
        expected[0] = 6;
        expected[1] = 7;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{0,0,1,1,1,2,4,4,4,4,5,5,5,6,8,8,9,9,10,10,10};
        target = 8;
        expected[0] = 14;
        expected[1] = 15;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);

        nums = new int[]{2, 2};
        target = 3;
        expected[0] = -1;
        expected[1] = -1;
        result = sol.searchRange(nums, target);
        assertArrayEquals(expected, result);
    }
}