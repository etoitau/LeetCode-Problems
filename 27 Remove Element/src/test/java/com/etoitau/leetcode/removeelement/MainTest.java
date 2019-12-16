package com.etoitau.leetcode.removeelement;

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
        int count, element;

        input = new int[]{1, 1, 2};
        element = 2;
        count = 2;
        output = new int[]{1, 1};
        assertEquals(count, sol.removeElement(input, element));
        assertTrue(sameArray(input, output, count));

        input = new int[]{3, 2, 2, 3};
        element = 3;
        count = 2;
        output = new int[]{2, 2};
        assertEquals(count, sol.removeElement(input, element));
        assertTrue(sameArray(input, output, count));

        input = new int[]{0,1,2,2,3,0,4,2};
        element = 2;
        count = 5;
        output = new int[]{0,1,4,0,3,0,4,2};
        assertEquals(count, sol.removeElement(input, element));
        assertTrue(sameArray(input, output, count));
    }

    boolean sameArray(int[] one, int[] two, int count) {
        for (int i = 0; i < count; i++) {
            if (one[i] != two[i]) return false;
        }
        return true;
    }
}