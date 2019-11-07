package com.etoitau.leetcode.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Problem 30 - Substring With Concatenation of All Words
 *
 * Result:
 * Runtime: 282 ms, faster than 12.26%
 * Memory Usage: 43.4 MB, less than 21.43%
 *
 * Description:
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices
 * of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) { return new ArrayList<>(); }

        List<Integer> result = new ArrayList<>();
        int wordSize = words[0].length();
        Arrays.sort(words);

        for (int i = 0; i < s.length() - words.length * wordSize + 1; i++) {
            String[] sParts = new String[words.length];
            for (int j = 0; j < words.length; j++) {
                sParts[j] = s.substring(i + j * wordSize, i + (j + 1) * wordSize);
            }
            Arrays.sort(sParts);
            if(Arrays.equals(words, sParts)) {
                result.add(i);
            }
        }
        return result;
    }
}
