package com.etoitau.leetcode.stringtoint;

import java.util.*;

/**
 * LeetCode Problem 8 - String to Integer (atoi)
 *
 * Results:
 * Runtime: 4 ms, faster than 16.52%
 * Memory Usage: 36.2 MB, less than 100.00%
 *
 * Problem Description:
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have
 * no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned.
 *
 */

public class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty())
            return 0;

        int startIndex = 0;
        int sign = 1;

        char[] ca = str.toCharArray();
        Character[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Set<Character> numSet = new HashSet<>(Arrays.asList(nums));

        // consume all whitespace
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ')
                break;
            startIndex++;
        }

        // if was all whitespace
        if (startIndex > ca.length - 1)
            return 0;

        // consume one sign if exists
        if (ca[startIndex] == '+') {
            startIndex++;
        } else if (ca[startIndex] == '-') {
            startIndex++;
            sign = -1;
        }

        // consume starting 0s
        for (int i = startIndex; i < ca.length; i++) {
            if (ca[i] != '0')
                break;
            startIndex++;
        }

        //if was all zeros
        if (startIndex > ca.length - 1)
            return 0;

        // check next char is a number
        if (!numSet.contains(ca[startIndex]))
            return 0;

        // get number of digits
        int digits = 0;
        final int MAX_DIGITS = 10;

        for (int i = startIndex + 1; i < ca.length; i++) {
            if (numSet.contains(ca[i])) {
                // if have valid digit
                digits ++;
                if (digits == MAX_DIGITS){
                    // if too many digits
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                // stop if we find invalid digit
                break;
            }
        }

        // https://stackoverflow.com/a/46983874/11517662
        final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

        // start building result with first number we already confirmed
        long result = Character.getNumericValue(ca[startIndex]) * (long) POWERS_OF_10[digits];
        int digit = digits - 1;

        // for each digit found, add to result
        for (int i = startIndex + 1; i <= startIndex + digits; i++) {
            result += Character.getNumericValue(ca[i]) * POWERS_OF_10[digit];
            digit--;
        }

        // apply sign if one was found
        result *= sign;

        // check overflow
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
