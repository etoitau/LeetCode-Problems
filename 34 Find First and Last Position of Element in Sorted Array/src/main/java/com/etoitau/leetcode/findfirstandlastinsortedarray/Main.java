package com.etoitau.leetcode.findfirstandlastinsortedarray;

/**
 * LeetCode Problem 34 - Find First and Last Position of Element in Sorted Array
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 42.8 MB, less than 100.00%
 *
 * Description:
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1]
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // binary search to find target
        // if not found, -1
        // if found, bin search for start
        // another bin serach for end

        int[] result = new int[]{-1, -1};

        // trivial cases
        if (nums == null || nums.length == 0) {
            return result;
        } else if (nums.length == 1) {
            if (nums[0] != target) {
                return result;
            } else {
                result[0] = 0;
                result[1] = 0;
                return result;
            }
        }

        int start = 0, end = nums.length, mid = (start + end) / 2;

        // if target already found at start or end
        if (nums[start] == target) {
            result[0] = start;
            if (nums[end - 1] == target) {
                result[1] = end - 1;
                return result;
            } else {
                result[1] = findEnd(nums, start, end);
                return result;
            }
        } else if (nums[end - 1] == target) {
            result[0] = findStart(nums, start, end - 1);
            result[1] = end - 1;
            return result;
        }

        // binary search for target
        while (start < end) {
            if (nums[mid] == target) {
                result[0] = findStart(nums, start, mid);
                result[1] = findEnd(nums, mid, end);
                return result;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
                if (start < end && nums[start] == target) {
                    result[0] = start;
                    result[1] = findEnd(nums, start, end);
                    return result;
                }
            }
            mid = (start + end) / 2;
        }

        return result;
    }

    int findStart(int[] nums, int start, int foundAt) {
        // foundAt is on right side of border, start is on left side
        // note we've already checked nums[0]
        int mid = (start + foundAt) / 2;
        while (start < foundAt - 1) {
            if (nums[mid] != nums[foundAt]) {
                start = mid;
            } else {
                foundAt = mid;
            }
            mid = (start + foundAt) / 2;
        }
        return foundAt;
    }

    int findEnd(int[] nums, int foundAt, int end) {
        // foundAt is on left side of border, end is on right side
        // note we've already checked last element of nums
        int mid = (end + foundAt) / 2;
        while (foundAt < end - 1) {
            if (nums[mid] != nums[foundAt]) {
                end = mid;
            } else {
                foundAt = mid;
            }
            mid = (end + foundAt) / 2;
        }
        return foundAt;
    }
}