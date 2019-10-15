package com.etoitau.leetcode.mergeksortedlists;

import java.util.List;

/**
 * LeetCode Problem 23 - Merge K Sorted Lists
 *
 * Result:
 * Runtime: 2 ms, faster than 99.21%
 * Memory Usage: 42 MB, less than 32.79%
 *
 * Description:
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { return null; }
        // pass to recursive function
        return mergeKLists(lists, 0, lists.length);
    }

    /**
     * approach is divide and conquer similar to merge sort.
     * divide down until two lists, merge the two, then merge those...
     */
    private ListNode mergeKLists(ListNode[] lists, int start, int endX) {
        switch (endX - start) {
            case 0:
            case 1:
                return lists[start];
            case 2:
                return mergeTwoLists(lists[start], lists[endX - 1]);
            default:
                int mid = (start + endX) / 2;
                ListNode l1 = mergeKLists(lists, start, mid);
                ListNode l2 = mergeKLists(lists, mid, endX);
                return mergeTwoLists(l1, l2);
        }
    }


    /**
     * merge two sorted linked lists. This was Problem 21
     */
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