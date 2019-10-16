package com.etoitau.leetcode.removeduplicatesfromsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void removeDuplicatesTest() {
        Solution sol = new Solution();
        int[] input, output;
        int count;

        input = new int[]{1, 1, 2};
        count = 2;
        output = new int[]{1, 2};
        assertEquals(count, sol.removeDuplicates(input));
        assertTrue(sameArray(input, output, count));

        input = new int[]{1, 2};
        count = 2;
        output = new int[]{1, 2};
        assertEquals(count, sol.removeDuplicates(input));
        assertTrue(sameArray(input, output, count));

        input = new int[]{};
        count = 0;
        output = new int[]{};
        assertEquals(count, sol.removeDuplicates(input));
        assertTrue(sameArray(input, output, count));

        input = new int[]{-1, 0, 0};
        count = 2;
        output = new int[]{-1, 0};
        assertEquals(count, sol.removeDuplicates(input));
        assertTrue(sameArray(input, output, count));
    }

    boolean sameArray(int[] one, int[] two, int count) {
        for (int i = 0; i < count; i++) {
            if (one[i] != two[i]) return false;
        }
        return true;
    }
}