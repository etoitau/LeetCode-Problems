package com.etoitau.leetcode.validparentheses;


import java.util.*;

/**
 * LeetCode Problem 20 - Valid Parenthesis
 *
 * Result:
 * Runtime: 2 ms, faster than 60.91%
 * Memory Usage: 34.5 MB, less than 100.00%
 *
 * Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 */
class Solution {
    private Map<Character, Character> parenMap;

    public Solution() {
        parenMap = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) { return true; }
        Stack<Character> stack = new Stack<>();

        // for each character in string
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (parenMap.containsKey(c)) {
                // if c is opening paren of some type, add it's closing paren to stack
                stack.push(parenMap.get(c));
            } else {
                // if c is closing paren or foreign character, check top paren to close matches
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        // if string was balanced, stack will be empty
        return stack.isEmpty();
    }
}