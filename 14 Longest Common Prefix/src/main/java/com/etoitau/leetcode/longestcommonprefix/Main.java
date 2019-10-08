package com.etoitau.leetcode.longestcommonprefix;

/**
 * LeetCode Problem 14 - Longest Common Prefix
 *
 * Result:
 * Runtime: 1 ms, faster than 74.25%
 * Memory Usage: 37.4 MB, less than 96.49%
 *
 * Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }

        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) { minLen = strs[i].length(); }
        }
        int i = 0;
        char c;
        // each char
        charLoop:
        while (i < minLen) {
            c = strs[0].charAt(i);
            // each string
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) { break charLoop; }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}