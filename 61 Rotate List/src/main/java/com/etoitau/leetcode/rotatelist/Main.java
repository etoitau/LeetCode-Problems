package com.etoitau.leetcode.rotatelist;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// get the array of entries for use in the solution
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode ln = Solution.fromList(List.of(1, 2, 3, 4));
        int k = 2;
        System.out.println(solution.rotateRight(ln, k).val);
    }
}


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        // Loop to get size and link end to head
        Iterator<ListNode> itt = new ListNodeIterator(head);
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        int size = 0;
        ListNode ln = head;
        while (itt.hasNext()) {
            size++;
            ln = itt.next();
        }
        // k mod size to get rid of unnecessary loops
        k = k % size;
        if (k == 0) {
            return head;
        }
        // Link tail to head
        ln.next = head;

        // Much easier to traverse k times forward through linked list
        // Note moving x times left through the list is the same as
        // moving size - x times to the right.
        k = size - k;

        // iterate to the new tail, which we'll need to cut
        itt = new ListNodeIterator(head);
        for (int i = 0; i < k - 1; i++) {
            itt.next();
        }
        itt.next().next = null;
        // Next node is the new head
        return itt.next();
    }

    private static class ListNodeIterator implements Iterator<ListNode> {
        ListNode next;

        private ListNodeIterator(ListNode head) {
            next = head;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public ListNode next() {
            if (next == null) {
                return null;
            }
            ListNode ret = next;
            next = next.next;
            return ret;
        }
    }

    // Below here is just for testing and not submitted

    /**
     * Do it a second way to have something to check against. Doesn't need to be fast.
     */
    ListNode rotateRightNaive(ListNode head, int k) {
        // Turn it into a list
        List<ListNode> asList = new ArrayList<>();
        ListNodeIterator itt = new ListNodeIterator(head);
        itt.forEachRemaining(asList::add);
        // Link end to beginning
        asList.get(asList.size() - 1).next = asList.get(0);

        // Rotating right is the same as moving the head left
        // Find new head by moving head index left k times
        int headIndex = 0;
        for (int i = 0; i < k; i++) {
            headIndex--;
            if (headIndex < 0) {
                headIndex = asList.size() - 1;
            }
        }

        // Cut behind head
        int tailIndex = headIndex > 0 ? headIndex - 1 : asList.size() - 1;
        asList.get(tailIndex).next = null;

        // Return new head
        return asList.get(headIndex);
    }

    /**
     * Helper for testing
     * @param sourceList a list of integers from which to create a linked list
     * @return the head of the resulting linked list
     */
    public static ListNode fromList(List<Integer> sourceList) {
        if (sourceList == null || sourceList.size() < 1) {
            throw new IllegalArgumentException();
        }
        ListNode head = null;
        ListNode prev = null;
        for (int val : sourceList) {
            if (head == null) {
                head = new ListNode(val);
                prev = head;
                continue;
            }
            prev.next = new ListNode(val);
            prev = prev.next;
        }
        return head;
    }


    /**
     * For a linked list node to be equal to another is equivelent to saying the list from that node on is equal.
     */
    public static boolean listNodeEquals(ListNode one, ListNode two) {
        if (one == two) {
            // Same object
            return true;
        }
        if (one == null || two == null) {
            // If one is false and the previous check was not true, only one is null, so !=
            return false;
        }
        Iterator<ListNode> oneIterator = new ListNodeIterator(one);
        Iterator<ListNode> twoIterator = new ListNodeIterator(two);

        while (oneIterator.hasNext() && twoIterator.hasNext()) {
            // Check same values
            if (oneIterator.next().val != twoIterator.next().val) {
                return false;
            }
        }
        // Check same length
        return oneIterator.hasNext() == twoIterator.hasNext();
    }
}

/**
 * Provided by Leetcode
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

