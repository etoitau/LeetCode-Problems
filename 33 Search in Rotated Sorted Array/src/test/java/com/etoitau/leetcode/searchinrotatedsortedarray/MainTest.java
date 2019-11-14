package com.etoitau.leetcode.searchinrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void adapterTest() {
        Adapter a;
        int[] nums;
        int input;
        int expected;

        nums = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
        a = new Adapter(nums);
        input = 2;
        expected = 5;
        assertEquals(expected, a.adaptTo(input));

        nums = new int[]{0, 5, 8};
        a = new Adapter(nums);
        input = 0;
        expected = 0;
        assertEquals(expected, a.adaptTo(input));
        input = 2;
        expected = 2;
        assertEquals(expected, a.adaptTo(input));

        nums = new int[]{5};
        a = new Adapter(nums);
        input = 0;
        expected = 0;
        assertEquals(expected, a.adaptTo(input));

        nums = new int[]{7, 0, 1, 2, 3, 4};
        a = new Adapter(nums);
        input = 2;
        expected = 3;
        assertEquals(expected, a.adaptTo(input));

        nums = new int[]{2, 3, 4, 1};
        a = new Adapter(nums);
        input = 1;
        expected = 0;
        assertEquals(expected, a.adaptTo(input));
    }

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        int[] nums;
        int target, expected, result;

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        expected = 4;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{};
        target = 3;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4};
        target = 3;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4};
        target = 4;
        expected = 0;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 0};
        target = 4;
        expected = 0;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 0};
        target = 0;
        expected = 1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 0};
        target = 2;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 0};
        target = 8;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 0};
        target = -1;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 5, 6, 7};
        target = 7;
        expected = 3;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 5, 6, 7};
        target = 4;
        expected = 0;
        result = sol.search(nums, target);
        assertEquals(expected, result);

        nums = new int[]{4, 5, 6, 7};
        target = 8;
        expected = -1;
        result = sol.search(nums, target);
        assertEquals(expected, result);
    }
}