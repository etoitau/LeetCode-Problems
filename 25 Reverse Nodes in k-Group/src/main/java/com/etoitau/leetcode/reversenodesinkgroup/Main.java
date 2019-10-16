package com.etoitau.leetcode.reversenodesinkgroup;

import java.util.List;

/**
 * LeetCode Problem 25 - Reverse Nodes in k-Group
 *
 * Result:
 * Runtime: 2 ms, faster than 8.60%
 * Memory Usage: 38.5 MB, less than 24.14%
 *
 * Description:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
 * a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // trivial case, no swaps
        if (k < 2) return head;
        // if k is odd, there's a middle element that doesn't swap
        boolean isEven = (k % 2 == 0);
        // insert a node before head since swap takes node before to be swapped
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // set up pointers to before first to last element of first k block
        ListNode preBlock = preHead;
        ListNode endBlock = crawl(head, k - 1);
        // find nodes before the first two nodes to swap
        ListNode bOne, bTwo;
        bOne = crawl(preBlock, k / 2 - 1);
        bTwo = crawl(bOne, (isEven)? 1: 2);
        while (endBlock != null) {
            // reverse block from inside out
            int i = k / 2 - 2;
            while (i + 2 > 0) {
                bTwo = swapNodes(bOne, bTwo);
                bOne = crawl(preBlock, i);
                i--;
            }

            // move block pointers
            preBlock = bTwo;
            endBlock = crawl(preBlock.next, k - 1);
            bOne = crawl(preBlock, k / 2 - 1);
            bTwo = crawl(bOne, (isEven)? 1: 2);
        }
        return preHead.next;
    }

    /**
     * swap nodes
     * @param bOne - node before first node to swap
     * @param bTwo - node before second node to swap
     * @return - first node, now at two's initial position
     */
    public ListNode swapNodes(ListNode bOne, ListNode bTwo) {


        ListNode
                one = bOne.next,
                two = bTwo.next,
                oneN = one.next,
                twoN = two.next;

        if (one == bTwo) {
            bOne.next = two;
            two.next = one;
            one.next = twoN;
        } else {
            bOne.next = two;
            two.next = oneN;
            bTwo.next = one;
            one.next = twoN;
        }
        return one;
    }

    /**
     * get ListNode at position
     * @param from - starting node
     * @param steps - how many nodes down from start
     * @return - null if invalid steps, or the desired node
     */
    public ListNode crawl(ListNode from, int steps) {
        if (from == null || steps < 1) return from;
        if (steps == 1) return from.next;
        if (from.next == null) return null;

        ListNode cursor = from.next;
        steps--;

        while (cursor.next != null && steps > 0) {
            cursor = cursor.next;
            steps--;
        }

        if (steps > 0) {
            return null;
        } else {
            return cursor;
        }
    }
}