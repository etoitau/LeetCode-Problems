package com.etoitau.leetcode.longestvalidparentheses;

/**
 * LeetCode Problem 32 - Longest Valid Parenthesis - Alternate Solution
 *
 * Result:
 * Runtime: 101 ms, faster than 5.01%
 * Memory Usage: 36.8 MB, less than 100.00%
 *
 * Description:
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        } else if (s.length() == 2) {
            return (s.equals("()"))? 2: 0;
        }

        int[] graph = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                graph[i] = 1;
            } else {
                graph[i] = -1;
            }
        }

        int local, end, sum, longest = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            // find longest valid substring that starts at i
            if (graph[i] == -1) {
                // if substring starts with ), skip
                continue;
            } else {
                sum = 1;
            }

            local = -1;
            end = i + 1;

            while (end < graph.length) {
                // scan forward until end of s or sum goes negative (more close paren than open)
                // if sum hits 0 it's a valid substring, note location in local
                sum += graph[end];
                if (sum < 0) {
                    break;
                } else if (sum == 0) {
                    local = end;
                }
                end++;
            }

            if (local > -1) {
                // if found a valid substring, check if it's new longest
                if (local - i + 1 > longest) {
                    longest = local - i + 1;
                }
            }

            // if won't be able to find longer solution because too close to end of s
            if (i + longest > s.length() - 1) { break; }

            // if sum reached -1, no point in trying other i's before that, they'll all hit -1 there or earlier
            // and can't be new longest, so skip ahead.
            if (sum < 0) {
                i = end;
            }
        }
        return longest;
    }
}
