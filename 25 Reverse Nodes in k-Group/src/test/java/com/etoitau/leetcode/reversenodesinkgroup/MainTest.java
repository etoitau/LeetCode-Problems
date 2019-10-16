package com.etoitau.leetcode.reversenodesinkgroup;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void crawlTest() {
        Solution sol = new Solution();
        ListNode input, result;
        List<Integer> nums;
        int k;

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 2;
        result = sol.crawl(input, k);
        assertEquals(3, result.val);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 0;
        result = sol.crawl(input, k);
        assertEquals(1, result.val);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 4;
        result = sol.crawl(input, k);
        assertEquals(5, result.val);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 5;
        result = sol.crawl(input, k);
        assertNull(result);
    }

    @Test
    void swapNodesTest() {
        Solution sol = new Solution();
        ListNode
                one = new ListNode(1),
                two = new ListNode(2),
                three = new ListNode(3),
                four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        sol.swapNodes(one, two); // swap 2 and 3
        assertEquals(one.next, three);
        assertEquals(two.next, four);
        assertEquals(three.next, two);
        assertEquals(four.next, null);

        one.next = two;
        two.next = three;
        three.next = four;
        sol.swapNodes(one, three); // swap 2 and 4
        assertEquals(one.next, four);
        assertEquals(two.next, null);
        assertEquals(three.next, two);
        assertEquals(four.next, three);
    }

    @Test
    void reversekTest() {
        Solution sol = new Solution();
        String result, expected;
        List<Integer> nums;
        ListNode input;
        int k;

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 2;
        expected = "2 1 4 3 5";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 3;
        expected = "3 2 1 4 5";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        input = ListHelp.makeList(nums);
        k = 3;
        expected = "3 2 1 6 5 4";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2);
        input = ListHelp.makeList(nums);
        k = 2;
        expected = "2 1";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        input = ListHelp.makeList(nums);
        k = 6;
        expected = "6 5 4 3 2 1";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 1;
        expected = "1 2 3 4 5";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 0;
        expected = "1 2 3 4 5";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1);
        input = ListHelp.makeList(nums);
        k = 1;
        expected = "1";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);

        nums = Arrays.asList(1, 2, 3, 4, 5);
        input = ListHelp.makeList(nums);
        k = 5;
        expected = "5 4 3 2 1";
        result = ListHelp.printList(sol.reverseKGroup(input, k));
        assertEquals(expected, result);
    }
}