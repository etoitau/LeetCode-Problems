package com.etoitau.leetcode.four;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem:
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 */

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // m is length of larger array, n is length of smaller
        int m = Math.max(nums1.length, nums2.length), n = Math.min(nums1.length, nums2.length);

        // initialize pointers to large and small arrays, and assign
        int[] lg, sm;
        if (nums2.length == m) {
            lg = nums2;
            sm = nums1;
        } else {
            lg = nums1;
            sm = nums2;
        }

        // if one of the arrays is empty, return trivial answer
        if (n == 0) {
            if (m % 2 == 0) {
                return (lg[m / 2 - 1] + lg[m / 2]) / 2.0;
            } else {
                return lg[m / 2];
            }
        }

        // check trivial case n and m are both 1
        if (n + m == 2) {
            return (nums1[0] + nums2[0]) / 2.0;
        }

        // how many elements do we want on left side? (half, or half + 1)
        // in odd case, target element will be max value on left side
        int targetLeft = (n + m + 1) / 2;

        // initialize binary search
        int iLow = 0, iHigh = n;
        int iLg, iSm;
        // start iSm in middle of sm
        iSm = iHigh / 2;
        // set iLg such that we get our target number of elements to left
        iLg = targetLeft - iSm;

        // loop to find array indexes where half of values are to left of those indexes
        // and max of left is less than or equal to min of right
        while (true) {
            int maxLeftLg = Integer.MIN_VALUE, maxLeftSm = Integer.MIN_VALUE,
                    minRightLg = Integer.MAX_VALUE, minRightSm = Integer.MAX_VALUE,
                    maxLeft, minRight;
            maxLeftLg = (iLg != 0) ? Math.max(maxLeftLg, lg[iLg - 1]): maxLeftLg;
            maxLeftSm = (iSm != 0) ? Math.max(maxLeftSm, sm[iSm - 1]): maxLeftSm;
            minRightLg = (iLg != m) ? Math.min(minRightLg, lg[iLg]): minRightLg;
            minRightSm = (iSm != n) ? Math.min(minRightSm, sm[iSm]): minRightSm;
            maxLeft = Math.max(maxLeftLg, maxLeftSm);
            minRight = Math.min(minRightLg, minRightSm);
            if (minRightLg >= maxLeftSm) {
                if (minRightSm >= maxLeftLg) {
                    if ((m + n) % 2 == 0){
                        // if even
                        return (maxLeft + minRight) / 2.0;
                    } else {
                        // if odd
                        return maxLeft;
                    }
                } else {
                    // increase iSm
                    iLow = iSm + 1;
                }
            } else {
                // decrease iSm
                iHigh = iSm;
            }
            iSm = (iLow + iHigh) / 2;
            iLg = targetLeft - iSm;
        }
    }
}
