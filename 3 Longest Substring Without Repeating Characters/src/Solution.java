/**
 * LeetCode Problem:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 */

import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> hasChar = new HashMap<>();
        int first = 0, last = 0;
        int maxLength = 0;

        while (last < s.length()) {
            // is last a repeat?
            if (hasChar.containsKey(s.charAt(last)) && hasChar.get(s.charAt(last))) {
                hasChar.put(s.charAt(first), false);
                first++;
            } else {
                maxLength = Math.max(maxLength, last - first + 1);
                hasChar.put(s.charAt(last), true);
                last++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdadb"));
    }
}
