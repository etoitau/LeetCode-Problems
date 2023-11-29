package com.etoitau.leetcode.plusone;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] digits = new int[]{9, 8};
        System.out.println(Arrays.toString(solver.plusOne(digits)));
    }
}


class Solution {
    public int[] plusOne(int[] digits) {
        if (allNines(digits)) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        }
        for (int i = digits.length - 1; i > -1; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                break;
            }
        }
        return digits;
    }

    private boolean allNines(int[] digits) {
        for (int i : digits) {
            if (i != 9) {
                return false;
            }
        }
        return true;
    }
}
