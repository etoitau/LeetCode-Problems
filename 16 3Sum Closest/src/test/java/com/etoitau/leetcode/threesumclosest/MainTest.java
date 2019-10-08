package com.etoitau.leetcode.threesumclosest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {
    static int[][] numSets = {
            {-1, 2, 1, -4}, // 0
            {1, 1, 1, 1, 1},
            {1, 2, 3},
            {-2, -8, 1},
            {2, 8, 7, 4, -5},
            {6, -3, -2, -5, -8, -3, -6, -5}, // 5
            {9, -6, -1, 9, 6, -7, 7, -4},
            {-10, -8, -9, -10, -1, 0, -2},
            {1, -1, 4},
            {9, 4, -8, 7, -2, 3},
            {6, -1, 7, -2, -10, -5}, // 10
            {0, 2, 1, -3},
            {1, 6, 9, 14, 16, 70}
    };


    @Test
    void threeSumClosest() {
        Solution sol = new Solution();
        int[] set;
        int target;
        int expected;

        set = numSets[0];
        target = 1;
        expected = 2;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = 20;
        expected = 2;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = -20;
        expected = -4;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = -3;
        expected = -3;
        assertEquals(expected, sol.threeSumClosest(set, target));

        set = numSets[1];
        target = 1;
        expected = 3;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = 5;
        expected = 3;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = 3;
        expected = 3;
        assertEquals(expected, sol.threeSumClosest(set, target));

        set = numSets[2];
        target = 1;
        expected = 6;
        assertEquals(expected, sol.threeSumClosest(set, target));

        set = numSets[5];
        target = -13;
        expected = -13;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = -15;
        expected = -15;
        assertEquals(expected, sol.threeSumClosest(set, target));
        target = -2;
        expected = -2;
        assertEquals(expected, sol.threeSumClosest(set, target));

        set = numSets[11];
        target = 1;
        expected = 0;
        assertEquals(expected, sol.threeSumClosest(set, target));

        set = numSets[12];
        target = 81;
        expected = 80;
        assertEquals(expected, sol.threeSumClosest(set, target));
    }


    @Test
    void binSearch() {
        Solution sol = new Solution();
        int[] set;
        int target;
        int expected;

        set = numSets[0];
        Arrays.sort(set);
        target = 1;
        expected = 2;
        assertEquals(expected, sol.binSearch(set, 0, set.length, target));
        target = 3;
        expected = set.length;
        assertEquals(expected, sol.binSearch(set, 0, set.length, target));
        target = -3;
        expected = 1;
        assertEquals(expected, sol.binSearch(set, 0, set.length, target));
    }
}