package com.etoitau.leetcode.searchinsertposition;

/**
 * LeetCode Problem 35 - Search Insert Position
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 39.1 MB, less than 100.00%
 *
 * Description:
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // trivial cases
        if (nums == null) { return 0; }
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if (target <= nums[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        // nums is at least two long


        // binary search
        int high = nums.length, low = 0, mid = (high + low) / 2;

        while(low < high) {
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                return mid;
            }
            mid = (high + low) / 2;
        }

        if (mid > nums.length - 1) {
            return nums.length;
        } else if (nums[mid] >= target) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}
