package com.etoitau.leetcode.mergetwosortedlists;


import java.util.List;

/**
 * LeetCode Problem 21 - Merge Two Sorted Lists
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 39.7 MB, less than 16.16%
 *
 * Description:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 * the nodes of the first two lists.
 *
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode oneLast = l1, oneNext = l1, twoLast = l2, twoNext = l2;
        // if first element(s) of two are less than first element of one
        // traverse list to find how many
        while (twoNext != null && twoNext.val < oneNext.val) {
            twoNext = twoNext.next;
        }
        // if all elements in two are less than one
        if (twoNext == null) {
            // start of two list is now start of one list
            oneLast = twoLast;
            // put twoLast at end of two list
            while (twoLast.next != null) {
                twoLast = twoLast.next;
            }
            // have end of two list point to start of one
            twoLast.next = oneNext;
            return oneLast;
        }
        // if at least one of two's first elements are less than one's
        if (twoLast.val < oneLast.val) {
            // two last is new start of one
            l1 = twoLast;
            // move twoLast up to last node less than start of one
            while (twoLast.next != twoNext) {
                twoLast = twoLast.next;
            }
            // make last small two point to start of 1
            twoLast.next = oneLast;
            // catch last pointers up
            oneLast = oneNext;
            twoLast = twoNext;
        }

        while (oneNext != null && twoNext != null) {
            if (oneNext.val <= twoNext.val) {
                oneNext = oneNext.next;
            } else {
                // how many of two to insert
                while (twoNext != null && twoNext.val < oneNext.val) {
                    twoNext = twoNext.next;
                }
                // move oneLast to right behind oneNext
                while (oneLast.next != oneNext)
                    oneLast = oneLast.next;
                // twoLast is now next after oneLast and before oneNext
                oneLast.next = twoLast;
                // move twoLast to right behind twoNext
                while (twoLast.next != twoNext) {
                    twoLast = twoLast.next;
                }
                // oneNext is now next after twoLast
                twoLast.next = oneNext;
                // get Lasts back on own list
                oneLast = oneNext;
                twoLast = twoNext;
                // now oneNext is less than twoNext
            }
        }

        if (oneNext == null) {
            while (oneLast.next != null)
                oneLast = oneLast.next;
            oneLast.next = twoNext;
        }
        return l1;
    }
}