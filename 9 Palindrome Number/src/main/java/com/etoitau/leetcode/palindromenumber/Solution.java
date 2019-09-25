package com.etoitau.leetcode.palindromenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 9 - Palindrome Number
 *
 * Results:
 * Runtime: 8 ms, faster than 39.85%
 * Memory Usage: 36.8 MB, less than 5.02%
 *
 * Problem Description:
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;

        List<Integer> digits = new ArrayList<>(10);

        while (x > 0) {
            digits.add(x % 10);
            x = x / 10;
        }

        for (int i = 0; i < digits.size() / 2; i++) {
            if (!digits.get(i).equals(digits.get(digits.size() - 1 - i)))
                return false;
        }

        return true;
    }
}
