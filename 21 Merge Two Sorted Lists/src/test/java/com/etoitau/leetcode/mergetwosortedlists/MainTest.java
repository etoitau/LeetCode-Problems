package com.etoitau.leetcode.mergetwosortedlists;

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
    void listHelpTests() {
        ListNode head;
        List<Integer> nums;
        String expected = "1 2 3 4 5";
        String result;

        nums = Arrays.asList(1, 2, 3, 4, 5);
        head = ListHelp.makeList(nums);
        result = ListHelp.printList(head);
        assertEquals(expected, result);

    }

    @Test
    void solutionTests() {
        Solution sol = new Solution();
        ListNode l1, l2, le, lr;
        String expected, result;
        List<Integer> nums1, nums2, nums;

        // example
        nums = new ArrayList<>();
        nums1 = Arrays.asList(1, 2, 4);
        nums2 = Arrays.asList(1, 3, 4);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        // all nums 2 < nums1
        nums = new ArrayList<>();
        nums1 = Arrays.asList(81, 112, 114);
        nums2 = Arrays.asList(1, 3, 4);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        // all nums1 < nums2
        nums = new ArrayList<>();
        nums1 = Arrays.asList(1, 1, 1);
        nums2 = Arrays.asList(8, 31, 40);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        // nums1 empty
        nums = new ArrayList<>();
        nums1 = Arrays.asList();
        nums2 = Arrays.asList(1, 3, 4);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        // nums2 empty
        nums = new ArrayList<>();
        nums1 = Arrays.asList(12, 14, 81);
        nums2 = Arrays.asList();
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        // insert all nums2 at once
        nums = new ArrayList<>();
        nums1 = Arrays.asList(1, 12, 32);
        nums2 = Arrays.asList(2, 2, 2, 2);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        //
        nums = new ArrayList<>();
        nums1 = Arrays.asList(81, 111, 111, 141);
        nums2 = Arrays.asList(0, 130, 130, 130);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        //
        nums = new ArrayList<>();
        nums1 = Arrays.asList(1, 1, 1, 1);
        nums2 = Arrays.asList(0, 0, 4, 4);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        //
        nums = new ArrayList<>();
        nums1 = Arrays.asList(0, 0, 4, 4);
        nums2 = Arrays.asList(01, 1, 1);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        //
        nums = new ArrayList<>();
        nums1 = Arrays.asList(81);
        nums2 = Arrays.asList(0, 130, 130, 130);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));

        //
        nums = new ArrayList<>();
        nums1 = Arrays.asList(81, 111, 111, 141);
        nums2 = Arrays.asList(130);
        l1 = ListHelp.makeList(nums1);
        l2 = ListHelp.makeList(nums2);
        nums.addAll(nums1);
        nums.addAll(nums2);
        Collections.sort(nums);
        le = ListHelp.makeList(nums);
        lr = sol.mergeTwoLists(l1, l2);
        assertEquals(ListHelp.printList(le), ListHelp.printList(lr));
    }
}