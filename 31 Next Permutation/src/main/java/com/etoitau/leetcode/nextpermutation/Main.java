package com.etoitau.leetcode.nextpermutation;

import java.util.Arrays;


/**
 * LeetCode Problem 31 - Next Permutation
 *
 * Result:
 * Runtime: 1 ms, faster than 90.55%
 * Memory Usage: 43.3 MB, less than 9.00%
 *
 * Description:
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory
 *
 */
class Solution {
    int temp;

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) { return; }
        if (nums.length == 2 || nums[nums.length - 2] < nums[nums.length - 1]) {
            swap(nums, nums.length - 2, nums.length - 1);
            return;
        }

        // nums is at least three long and second to last > last

        // scan right to left until digit is less than one to right
        for (int i = nums.length - 2; i > -1 ; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i ; j--) {
                    // swap with next higher from digits to right. scan from right until digit is higher
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        // sort digits to right of it
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] array, int index1, int index2) {
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}