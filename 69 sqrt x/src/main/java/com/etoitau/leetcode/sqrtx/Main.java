package com.etoitau.leetcode.sqrtx;



public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.mySqrt(2147395599));
    }
}


class Solution {
    public int mySqrt(int x) {
        // Using babylonian square root algorithm
        if (x == 1) {
            return 1;
        }
        double guess = x / 2;
        int ones = (int) Math.floor(guess);
        int prevOnes = x;
        // Iterate until the one's place does not change
        while (prevOnes != ones) {
            prevOnes = ones;
            guess = (guess + x / guess) / 2;
            ones = (int) Math.floor(guess);
        }
        return ones;
    }
}
