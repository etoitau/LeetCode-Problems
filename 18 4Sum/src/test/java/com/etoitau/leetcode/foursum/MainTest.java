package com.etoitau.leetcode.foursum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void fourSumTest() {
        int[] nums;
        int target, expectedLength;
        List<List<Integer>> result;
        Solution sol = new Solution();

        nums = new int[]{1, 0, -1, 0, -2, 2};
        target = 0;
        expectedLength = 3;
        assertTrue(checkResult(sol.fourSum(nums, target), expectedLength, target));

        nums = new int[]{1};
        target = 1;
        expectedLength = 0;
        assertTrue(checkResult(sol.fourSum(nums, target), expectedLength, target));

        nums = new int[]{1, 1, 1, 1, 1};
        target = 4;
        expectedLength = 1;
        result = sol.fourSum(nums, target);
        assertTrue(checkResult(sol.fourSum(nums, target), expectedLength, target));

        nums = new int[]{-1, -1, 1, 1, 1, 1, 1, 2, 2};
        target = 5;
        // 1, 1, 1, 2
        expectedLength = 1;
        result = sol.fourSum(nums, target);
        assertTrue(checkResult(result, expectedLength, target));

        nums = new int[]{0, 0, 1, 3, 2, 2};
        target = 4;
        expectedLength = 2;
        result = sol.fourSum(nums, target);
        assertTrue(checkResult(result, expectedLength, target));

        nums = new int[]{-3,-2,-1,0,0,1,2,3};
        target = 0;
//        [
//        [-3,-2,2,3],
//        [-3,-1,1,3],
//        [-3,0,0,3],
//        [-3,0,1,2],
//        [-2,-1,0,3],
//        [-2,-1,1,2],
//        [-2,0,0,2],
//        [-1,0,0,1]]
        expectedLength = 8;
        result = sol.fourSum(nums, target);
        assertTrue(checkResult(result, expectedLength, target));

        nums = new int[]{5,5,3,5,1,-5,1,-2};
        target = 4;
//        [
//        [-5, 1, 3, 5],
//        ]
        expectedLength = 1;
        result = sol.fourSum(nums, target);
        assertTrue(checkResult(result, expectedLength, target));

        nums = new int[]{-6,-6,-2,8,1,-3,0,-4,-2,-4,0,-5,-6,6,9,3,9,0};
        // -6, -6, -6, -5, -4, -4, -3, -2, -2, 0, 0, 0, 1, 3, 6, 8, 9, 9
        target = -14;
//        [
//        [-6, -6, -2, 0],
//        ]
        expectedLength = 8;
        result = sol.fourSum(nums, target);
        assertTrue(checkResult(result, expectedLength, target));
    }

    boolean checkResult(List<List<Integer>> result, int expectedLength, int target) {
        if (result.size() != expectedLength) { return false; }
        if (expectedLength == 0) { return true; }
        for (List<Integer> four: result) {
            if (four.size() != 4 || four.get(0) + four.get(1) + four.get(2) + four.get(3) != target) {
                return false;
            }
        }
        return true;
    }
}