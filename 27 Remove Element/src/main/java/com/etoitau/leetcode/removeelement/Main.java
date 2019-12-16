package com.etoitau.leetcode.removeelement;

/**
 * LeetCode Problem 27 - Remove Element
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 36.1 MB, less than 100.00%
 *
 * Description:
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        // catch trivial case
        if (nums == null || nums.length == 0) return 0;

        // scan once to a. find first index that is invalid and b. get count of valid entries
        int indexInvalid = -1;
        int valid = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (indexInvalid < 0) {
                    indexInvalid = i;
                }
                valid--;
            }
        }
        // if all valid, done
        if (valid == nums.length) return valid;

        // scan again, moving last valid value to first invalid
        int index = nums.length - 1;
        while (indexInvalid < index) {
            if (nums[index] != val) {
                nums[indexInvalid] = nums[index];
                index--;
                while (nums[++indexInvalid] != val && indexInvalid < index);
            } else {
                index--;
            }
        }
        return valid;
    }
}