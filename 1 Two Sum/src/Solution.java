/**
 * LeetCode Problem:
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 */

import sun.jvm.hotspot.utilities.IntArray;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{ i, j };
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{ 1, 2, 3, 4 };
        int target = 7;
        int[] result = Solution.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}

