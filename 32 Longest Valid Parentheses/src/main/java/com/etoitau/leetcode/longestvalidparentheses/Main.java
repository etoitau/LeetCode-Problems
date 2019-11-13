package com.etoitau.leetcode.longestvalidparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 32 - Longest Valid Parentheses
 *
 * Result:
 * Runtime: 16 ms, faster than 6.77%
 * Memory Usage: 36.8 MB, less than 100.00%
 *
 * Description:
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 */
class SolutionOld {
    public int longestValidParentheses(String s) {
        int[] graph = new int[s.length()];
        if (s.length() < 2) {
            return 0;
        } else if (s.length() == 2) {
            return (s.equals("()"))? 2: 0;
        }


        int prev = 0;

        // graph count of open - closed as function of position, reset if it goes negative
        for (int i = 0; i < s.length(); i++) {
            if (prev == -1) {
                prev = 0;
            }
            if (s.charAt(i) == '(') {
                graph[i] = prev + 1;
                prev++;
            } else {
                graph[i] = prev - 1;
                prev--;
            }
        }

        // find peaks of graph
        List<Integer> peaks = new ArrayList<>();
        if (graph[0] == 1 && graph[1] == 0) {
            peaks.add(0);
        }
        for (int i = 1; i < graph.length - 1; i++) {
            if (graph[i - 1] < graph[i] && graph[i] > graph[i + 1]) {
                peaks.add(i);
            }
        }

        int left, right, leftMin, rightMin, bestRight = 0, maxLen = 0;
        for (int peak: peaks) {
            if (peak < bestRight) { continue; }

            left = peak;
            right = peak + 1;
            leftMin = left;
            rightMin = right;
            while (true) {
                // scan left index left until it hits start of string or -1
                // note the lowest valley encountered
                left--;
                if (graph[left + 1] <= graph[leftMin]) {
                    leftMin = left + 1;
                }
                if (!(left > -1 && graph[left] != -1)) {
                  break;
                }
            }
            while (true) {
                // similar with right index
                if (graph[right] <= graph[rightMin]) {
                    rightMin = right;
                }
                if (right + 1 > graph.length - 1) {
                    break;
                }
                if (graph[right + 1] != -1) {
                    right++;
                } else {
                    break;
                }
            }

            // level base of peak
            int mtnBaseVal = Math.max(graph[leftMin] - 1, graph[rightMin]);


            left = peak;
            int leftLocal = -1;
            right = peak + 1;
            int rightLocal = -1;
            while (true) {
                // scan left index left until it hits start of string or is less than or == mtnBaseVal
                left--;
                if (left < 0) { break; }

                if (graph[left] < mtnBaseVal) { break; }

                if (graph[left] == mtnBaseVal) {
                    leftLocal = left;
                    if (left == 0) {
                        break;
                    }
                    if (graph[left - 1] < graph[left]) { break; }
                }
            }
            if (leftLocal > -1) {
                left = leftLocal;
            }
            while (true) {
                // similar with right index
                if (right > graph.length - 1) {
                    break;
                }
                if (graph[right] == mtnBaseVal) {
                    rightLocal = right;
                    if (right == graph.length - 1) {
                        break;
                    }
                    if (right + 1 < graph.length && graph[right + 1] < graph[right]) { break; }
                }
                right++;
            }
            if (rightLocal > -1) {
                right = rightLocal;
            }

            // check if new best
            if (right - left > maxLen) {
                bestRight = right;
                maxLen = right - left;
            }
        }

        return maxLen;
    }
}
