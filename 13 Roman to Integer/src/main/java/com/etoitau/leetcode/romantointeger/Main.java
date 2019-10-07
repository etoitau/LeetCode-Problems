package com.etoitau.leetcode.romantointeger;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LeetCode Problem 13 - Roman to Integer
 *
 * Result:
 * Runtime: 42 ms, faster than 5.24%
 * Memory Usage: 36.4 MB, less than 100.00%
 *
 * Description:
 *
 */
class Solution {
    private static Map<Character, Integer> map;
    static {
        map = Stream.of(new Object[][]{
                {'I', 1},
                {'V', 5},
                {'X', 10},
                {'L', 50},
                {'C', 100},
                {'D', 500},
                {'M', 1000}
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));
    }

    int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int current = map.get(s.charAt(0));
        if (s.length() == 1) {
            return current;
        }


        int next, result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            next = map.get(s.charAt(i + 1));
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
            current = next;
        }

        return result + current;
    }
}
