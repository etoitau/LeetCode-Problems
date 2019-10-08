package com.etoitau.leetcode.lettercombophone;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 17 Letter Combinations of a Phone Number
 *
 * Result:
 * Runtime: 1 ms, faster than 64.29%
 * Memory Usage: 36.1 MB, less than 98.63%
 *
 * Description:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map
 * to any letters.
 *
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        PhoneNumber phoneNumber = new PhoneNumber();

        // build phone number from input string
        for (int i = 0; i < digits.length(); i++) {
            phoneNumber.add(new PhoneDigit(digits.charAt(i)));
        }

        // number of strings in result
        int size = phoneNumber.numberStrings();

        // list for result
        List<String> out = new ArrayList<>(size);

        // add initial string
        out.add(phoneNumber.toString());

        // increment phoneNumber to get next string and add it to output
        for (int i = 1; i < size; i++) {
            phoneNumber.inc();
            out.add(phoneNumber.toString());
        }

        return out;
    }

    /**
     * Object to represent a phone number and get strings from number values
     */
    class PhoneNumber {
        List<PhoneDigit> digits = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // add a digit
        void add(PhoneDigit d) {
            digits.add(d);
            sb.append(d.get());
        }

        /**
         * increment to next possible string, works like incrementing a number where each digit has it's own base
         * we increment the digit and see if we need to carry and increment the next
         * keep the string builder current
         */
        void inc() {
            boolean carry;
            for (int i = digits.size() - 1; i >= 0; i--) {
                carry = digits.get(i).inc();
                sb.setCharAt(i, digits.get(i).get());
                if (!carry) { break; }
            }
        }

        // return total number of possible strings from this PhoneNumber
        int numberStrings() {
            int n = digits.get(0).vals.size();
            for (int i = 1; i < digits.size(); i++) {
                n *= digits.get(i).vals.size();
            }
            return n;
        }

        // get string of current state of PhoneNumber
        @Override
        public String toString() {
            return sb.toString();
        }
    }

    /**
     * Object to represent a phone digit and it's possible character values
     */
    class PhoneDigit {
        // possible values this digit can take
        List<Character> vals;
        // current state of digit
        int index = 0;

        /**
         * values for most possible digits can be calculated directly, but there are some special cases
         * @param c - character representing phone number digit 2-9
         */
        PhoneDigit(char c) {
            vals = new ArrayList<>();
            if (c == '7') {
                vals.add('p');
                vals.add('q');
                vals.add('r');
                vals.add('s');
            } else if (c == '8') {
                vals.add('t');
                vals.add('u');
                vals.add('v');
            } else if (c == '9') {
                vals.add('w');
                vals.add('x');
                vals.add('y');
                vals.add('z');
            } else {
                int base = (char) ((c-50) * 3 + 97);
                vals.add((char) base);
                vals.add((char) (base + 1));
                vals.add((char) (base + 2));
            }
        }

        // go to next possible value of digit, return true if rolling over
        boolean inc() {
            index++;
            if (index == vals.size()) { index = 0; }
            return (index == 0);
        }

        // get current letter value of digit
        char get() {
            return vals.get(index);
        }
    }
}