/**
 * LeetCode Problem:
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int rem = sum % 10;
        int carry = (sum - rem) / 10;

        ListNode head = new ListNode(rem);
        ListNode current = head;

        ListNode zero = new ListNode(0);
        zero.next = zero;

        while (true) {
            l1 = (l1.next != null)? l1.next: zero;
            l2 = (l2.next != null)? l2.next: zero;
            if (l1 == zero && l2 == zero)
                break;
            sum = carry + l1.val + l2.val;
            rem = sum % 10;
            carry = (sum - rem) / 10;
            current.next = new ListNode(rem);
            current = current.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return head;
    }
}
