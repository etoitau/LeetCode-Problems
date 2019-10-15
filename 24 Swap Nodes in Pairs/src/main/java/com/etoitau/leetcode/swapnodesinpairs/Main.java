package com.etoitau.leetcode.swapnodesinpairs;

import java.util.List;

/**
 * LeetCode Problem 24 - Swap Nodes in Pairs
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.5 MB, less than 100.00%
 *
 * Description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

// Definition for singly-linked list. Provided
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * some helper functions for testing
 */
class ListHelp {
    public static ListNode makeList(List<Integer> nums) {
        if (nums.isEmpty()) { return null; }
        ListNode head = new ListNode(nums.get(0));
        ListNode current = head;
        for (int i = 1; i < nums.size(); i++) {
            current.next = new ListNode(nums.get(i));
            current = current.next;
        }
        return head;
    }

    public static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        return sb.toString().trim();
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { return head; }

        ListNode current = head.next;
        head.next = current.next;
        current.next = head;
        head = current;
        current = head.next;

        while (current != null)
            current = trySwapNext(current);

        return head;
    }

    private ListNode trySwapNext(ListNode prev) {
        ListNode one = prev.next;
        if (one == null) return null;
        ListNode two = one.next;
        if (two == null) return null;
        swapNodes(prev, one, two);
        return one;
    }

    private void swapNodes(ListNode prev, ListNode one, ListNode two) {
        prev.next = two;
        one.next = two.next;
        two.next = one;
    }
}