package com.etoitau.leetcode.implementstrstr;

/**
 * LeetCode Problem 28 - Implement strStr()
 *
 * Result:
 * Runtime: 2 ms, faster than 53.58%
 * Memory Usage: 37.6 MB, less than 68.70%
 *
 * Description:
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty() ) return 0;
        haystackLoop:
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) continue haystackLoop;
            }
            return i;
        }
        return -1;
    }
}