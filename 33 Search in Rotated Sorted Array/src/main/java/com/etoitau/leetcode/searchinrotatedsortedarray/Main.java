package com.etoitau.leetcode.searchinrotatedsortedarray;

/**
 * LeetCode Problem 33 - Search in Rotated Sorted Array
 *
 * Result:
 * Runtime: 1 ms, faster than 11.09%
 * Memory Usage: 39.4 MB, less than 18.24%
 *
 * Description:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        // check trivial cases
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            if (nums[0] == target) { return 0; } else { return -1; }
        }

        // get adapter for rotated array
        Adapter a = new Adapter(nums);

        // do binary-type search to zero in on target from both sides
        int left = 0, right = nums.length - 1, mid;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if (nums[a.adaptTo(mid)] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // see if we found target
        if (nums[a.adaptTo(left)] == target) {
            return a.adaptTo(left);
        } else if (nums[a.adaptTo(right)] == target) {
            return a.adaptTo(right);
        } else {
            return -1;
        }
    }
}

/**
 * Adapter for rotated sorted array
 * initialize with array.
 * It detects degree of rotation and provides a method to translate non-rotated index to rotated.
 */
class Adapter {
    private int offset, len;

    public Adapter(int[] nums) {
        len = nums.length;

        // use binary-type search to find point where non-rotated array would start
        int left = 0, right = len - 1, mid;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (left == 0 && nums[left] < nums[len - 1]) {
            offset = 0;
        } else {
            offset = right;
        }
    }

    public int adaptTo(int i) {
        return (i + offset) % len;
    }

}
