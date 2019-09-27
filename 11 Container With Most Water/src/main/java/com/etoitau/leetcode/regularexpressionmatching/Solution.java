package com.etoitau.leetcode.regularexpressionmatching;

import java.util.Random;

/**
 * LeetCode Problem 11 - Container With Most Water
 *
 * Result:
 * Runtime: 1 ms, faster than 100.00%
 * Memory Usage: 39.8 MB, less than 94.87%
 *
 * Description:
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2
 */
class Solution {
    /**
     * The method submitted
     * @param ht  - array of heights per problem statement
     * @return - returns greatest area found per problem above
     */
    public int maxArea(int[] ht) {
        // trivial case
        if (ht.length == 2) { return Math.min(ht[0], ht[1]); }

        int cli = 0, cri = ht.length - 1;
        int bestArea;
        boolean moveRight = true;
        int minH;

        // figure out which end should move to look for higher value
        if (ht[cli] < ht[cri]) {
            moveRight = false;
            minH = ht[cli];
        } else {
            minH = ht[cri];
        }

        bestArea = (cri - cli) * minH;

        while (cri > cli) {
            if (moveRight) {
                // if right end is smaller
                // look at next right
                cri--;
                if (ht[cri] > minH) {
                    // if this right is higher than current
                    minH = ht[cri];
                    if (minH > ht[cli]) {
                        // if this right is higher than left
                        minH = ht[cli];
                        moveRight = false;
                    }
                    // update area if needed
                    bestArea = Math.max(bestArea, (cri - cli) * minH);
                }
            } else {
                // if left end is smaller
                // look at next
                cli++;
                if (ht[cli] > minH) {
                    // if this right is higher than current
                    minH = ht[cli];
                    if (minH > ht[cri]) {
                        // if this left is higher than right
                        minH = ht[cri];
                        moveRight = true;
                    }
                    // update area if needed
                    bestArea = Math.max(bestArea, (cri - cli) * minH);
                }
            }

        }
        return bestArea;
    }

    /**
     * Naive solution used for checking real solution
     * @param ht
     * @return
     */
    public int naive(int[] ht) {
        int bestArea = 0;
        for (int i = 0; i < ht.length - 1; i++) {
            for (int j = i + 1; j < ht.length; j++) {
                bestArea = Math.max(bestArea, (j - i) * Math.min(ht[i], ht[j]));
            }
        }
        return bestArea;
    }

    /**
     * helper function for generating a random array
     * @param maxN - Max number of elements
     * @param maxH - Max size of any one element
     * @return - returns generated array
     */
    public int[] getArray(int maxN, int maxH) {
        Random rand = new Random();
        int [] out = new int[1 + rand.nextInt(maxN - 1)];
        for (int i = 0; i < out.length; i++) {
            out[i] = rand.nextInt(maxH);
        }
        return out;
    }


    /**
     * Running ad hoc tests and stress tests here
     *
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input;

        // one test
//        input = new int[]{9, 1, 9, 7, 3, 4, 2};
//        System.out.println(sol.maxArea(input));

        // stress test

        int count = 0;
        while (true) {
            input = sol.getArray(10, 10);
//            System.out.println("Trying: " + prettyPrint(input));
            int naive = sol.naive(input);
            int actual = sol.maxArea(input);
            if (naive != actual) {
                System.out.println("Error on input:");
                System.out.println(prettyPrint(input));
                System.out.println("Naive : " + naive);
                System.out.println("Actual: " + actual);
                break;
            } else if (count % 100 == 0) {
                System.out.println("trial " + count + " ok");
            }
            count++;

        }
    }

    // better array toString
    public static String prettyPrint(int[] as) {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(as[0]);
        for (int i = 1; i < as.length; i++) {
            sb.append(", ").append(as[i]);
        }
        return sb.append("}").toString();
    }
}