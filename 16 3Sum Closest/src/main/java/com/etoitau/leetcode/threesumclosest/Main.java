package com.etoitau.leetcode.threesumclosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * LeetCode Problem 3Sum Closest
 *
 * Result:
 * Runtime: 2 ms, faster than 99.83%
 * Memory Usage: 36.1 MB, less than 100.00%
 *
 * Description:
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // if trivial set
        if (nums.length == 3) { return nums[0] + nums[1] + nums[2]; }

        Arrays.sort(nums);

        int first3 = nums[0] + nums[1] + nums[2];
        int last3 = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        int closestVal = first3;

        // if v small target
        if (first3 >= target) { return first3; }

        // if v large target
        if (last3 < target) { return last3; }

        int k, minDif = target - closestVal, rem, diff;

        // i starts at left end, j starts at right, binary search between
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }

            // if i too big
            first3 = nums[i] + nums[i + 1] + nums[i + 2];
            if (first3 >= target) {
                if (first3 - target < minDif) {
                    return first3;
                } else {
                    return closestVal;
                }
            }

            for (int j = nums.length - 1; j > i; j--) {
                // skip duplicates
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) { continue; }

                // get index of number at or above the one we're looking for
                rem = target - nums[i] - nums[j];
                k = binSearch(nums, i + 1, j, rem);

                if (k == j) {
                    // if nothing between i and j is big enough, then no point in further decreasing j, check, then skip to next i
                    diff = rem - nums[k - 1];
                    if (diff < minDif) {
                        minDif = diff;
                        closestVal = target - minDif;
                    }
                    break;
                }

                // normally search will give nums[k] > target and nums[k - 1] < target, need to check both
                diff = nums[k] - rem;
                if (diff > 0) {
                    if (diff < minDif) {
                        minDif = diff;
                        closestVal = target + minDif;
                    }
                    if (k > i + 1) {
                        diff = rem - nums[k - 1];
                        if (diff < minDif) {
                            minDif = diff;
                            closestVal = target - minDif;
                        }
                    }
                } else {
                    // if diff is not > 0, must be == 0. Can only be < 0 if k == j and that's checked above
                    return target;
                }
            }
        }
        return closestVal;
    }

    /**
     * binary search
     * @param nums - array of integers to search in
     * @param low - lower bound of search, inclusive
     * @param highEx - upper bound of search, exclusive
     * @param target - value searching for
     * @return index of element that is closest to and greater than target or equal to target
     */
    int binSearch(int[] nums, int low, int highEx, int target) {
        if (low == highEx) { return highEx; }
        int mid = (low + highEx) / 2;

        if (target > nums[mid]) {
            return binSearch(nums, mid + 1, highEx, target);
        } else if (target < nums[mid]) {
            return binSearch(nums, low, mid, target);
        } else {
            return mid;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        int length = rand.nextInt(7) + 3;
        for (int i = 0; i < length; i++) {
            list.add(rand.nextInt(20) - 10);
        }
        System.out.println(list.toString());
    }
}
