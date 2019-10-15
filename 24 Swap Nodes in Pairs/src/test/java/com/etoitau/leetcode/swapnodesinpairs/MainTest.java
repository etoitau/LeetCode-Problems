package com.etoitau.leetcode.swapnodesinpairs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void swapTest() {
        Solution sol = new Solution();
        ListNode list;
        String expected;
        String got;

        list = ListHelp.makeList(Arrays.asList(1, 2, 3, 4));
        expected = "2 1 4 3";
        got = ListHelp.printList(sol.swapPairs(list));
        assertEquals(expected, got);

        list = ListHelp.makeList(Arrays.asList(2));
        expected = "2";
        got = ListHelp.printList(sol.swapPairs(list));
        assertEquals(expected, got);

        list = ListHelp.makeList(Arrays.asList(1, 2, 3));
        expected = "2 1 3";
        got = ListHelp.printList(sol.swapPairs(list));
        assertEquals(expected, got);

        assertNull(sol.swapPairs(null));

    }
}