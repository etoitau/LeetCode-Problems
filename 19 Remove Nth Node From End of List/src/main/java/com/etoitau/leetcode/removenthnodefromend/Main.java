package com.etoitau.leetcode.removenthnodefromend;


/**
 * LeetCode Problem 19 - Remove Nth Node From End of List
 *
 * Result:
 * Runtime: 0 ms, faster than 100.00%
 * Memory Usage: 34.7 MB, less than 100.00%
 *
 * Description:
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 */
class Solution {
    // This is submitted method
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // want deep to probe to end, with nBack lagging behind
        ListNode deep = head, nBack = head;
        // put deep n ahead
        for (int i = 0; i < n; i++) {
            deep = deep.next;
        }

        // if deep has gone through whole list, then we're just removing first element
        if (deep == null) {
            return head.next;
        }

        // move them both down together until deep gets to end
        while (deep.next != null) {
            deep = deep.next;
            nBack = nBack.next;
        }

        // cut node out of list
        nBack.next = nBack.next.next;
        return head;
    }
}

// Definition for singly-linked list provided by LeetCode
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode makeList(int n) {
        ListNode head = new ListNode(1);
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(i + 1);
            current = current.next;
        }

        return head;
    }

    /**
     * Utility function added by me for testing
     * @param node - starting point in list
     * @param n - nth node from start (base 1 counting)
     * @return value at nth node
     */
    public static int getNode(ListNode node, int n) {
        for (int i = 1; i < n; i++) {
            if (node.next == null) { return 0; }
            node = node.next;
        }
        return node.val;
    }

    /**
     * Utility function added by me for testing
     * @param node - head of list to print to screen
     */
    public static void printList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        node = node.next;
        while (true) {
            if (node == null) { break; }
            sb.append(" -> ").append(node.val);
            node = node.next;
        }
        System.out.println(sb.toString());
    }
}

class Main {
    public static void main(String[] args) {
        // demo
        ListNode head = ListNode.makeList(5);
        ListNode.printList(head);
        System.out.println(ListNode.getNode(head, 4));
        Solution sol = new Solution();
        sol.removeNthFromEnd(head, 2);
        ListNode.printList(head);
    }
}