package com.etoitau.leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // check trivial cases
        if (nums.length < 4) {
            return result;
        } else if (nums.length == 4) {
            if (target == IntStream.of(nums).sum()) {
                List<Integer> four = new ArrayList<>(4);
                for (int i : nums) four.add(i);
                result.add(four);
                return result;
            } else {
                return result;
            }
        }

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, l, r, min, max, sumij, sum;

        while (i < nums.length - 3) {
            // once smallest possible sum is greater than target, don't need to check more
            min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (target < min) { break; }
            // reset j
            j = nums.length - 1;
            while (j > i + 2) {
                sumij = nums[i] + nums[j];

                // once largest possible sum is smaller than target, done with this j
                max = sumij + nums[j - 1] + nums[j - 2];
                if (target > max) { break; }

                l = i + 1;
                r = j - 1;

                while (l < r) {
                    sum = sumij + nums[l] + nums[r];
                    if (target > sum) {
                        l++;
                        // skip duplicates
                        while (nums[l] == nums[l - 1] && l < r) { l++; }
                    } else if (target < sum) {
                        r--;
                        // skip duplicates
                        while (nums[r] == nums[r + 1] && l < r) { r--; }
                    } else {
                        // it's a match
                        addToResult(result, nums[i], nums[l], nums[r], nums[j]);
                        // and go to next
                        l++;
                        // skip duplicates
                        while (nums[l] == nums[l - 1] && l + 1 < r) { l++; }
                        // and go to next
                        r--;
                        // skip duplicates
                        while (nums[r] == nums[r + 1] && l + 1 < r) { r--; }
                    }
                } // end l r loop
                // next j
                j--;
                // skip duplicates
                while (nums[j] == nums[j + 1] && j > i + 2) { j--; }

            } // end j loop
            // next i
            i++;
            // skip duplicates but don't overstep
            while (nums[i] == nums[i - 1] && i < nums.length - 3) { i++; }
        } // end i loop

        return result;
    }

    private void addToResult(List<List<Integer>> result, int i, int j, int k, int l) {
        result.add(Arrays.asList(i, j, k, l));
    }

}
