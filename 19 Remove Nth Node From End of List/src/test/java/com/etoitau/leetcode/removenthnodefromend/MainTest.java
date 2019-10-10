package com.etoitau.leetcode.removenthnodefromend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution sol = new Solution();

        int len, n;
        ListNode list;
        List<Integer> expectedVals;

        len = 5;
        n = 2;
        expectedVals = Arrays.asList(1, 2, 3, 5);
        list = ListNode.makeList(len);
        list = sol.removeNthFromEnd(list, n);
        assertTrue(checkList(expectedVals, list));

        len = 5;
        n = 1;
        expectedVals = Arrays.asList(1, 2, 3, 4);
        list = ListNode.makeList(len);
        list = sol.removeNthFromEnd(list, n);
        assertTrue(checkList(expectedVals, list));

        len = 5;
        n = 5;
        expectedVals = Arrays.asList(2, 3, 4, 5);
        list = ListNode.makeList(len);
        list = sol.removeNthFromEnd(list, n);
        assertTrue(checkList(expectedVals, list));


    }

    // checks if provided linked list represented by head ln has same sequence of values as provided List expectedVals
    boolean checkList(List<Integer> expectedVals, ListNode ln) {
        for (int val: expectedVals) {
            if (val != ln.val)
                return false;
            ln = ln.next;
        }
        return ln == null;
    }



}