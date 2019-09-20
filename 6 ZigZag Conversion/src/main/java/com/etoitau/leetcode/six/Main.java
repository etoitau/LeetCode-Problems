package com.etoitau.leetcode.six;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

}

/**
 * LeetCode Problem 6 - ZigZagConversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * Result:
 * Runtime: 9 ms, faster than 41.05%
 * Memory Usage: 39 MB, less than 75.53%
 */
class Solution {
    public String convert(String s, int numRows) {

        // intercept trivial cases
        if (numRows < 2 || s.length() < 2) {
            return s;
        }

        // will sort the characters into lines, give each line a StringBuilder
        List<StringBuilder> builders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            builders.add(new StringBuilder());
        }

        // which line are we on
        int line = 0;
        // are we zigging or zagging
        Boolean isDownstroke = true;

        // line bouces down and up telling us where to sort each character
        for (Character c: s.toCharArray()) {
            builders.get(line).append(c);
            if (isDownstroke) {
                if (line == builders.size() - 1) {
                    isDownstroke = false;
                    line--;
                } else {
                    line++;
                }
            } else {
                if (line == 0) {
                    isDownstroke = true;
                    line ++;
                } else {
                    line--;
                }
            }
        }

        // put all the builders together into the first one
        for (int i = 1; i < builders.size(); i++) {
            builders.get(0).append(builders.get(i));
        }

        return builders.get(0).toString();
    }
}