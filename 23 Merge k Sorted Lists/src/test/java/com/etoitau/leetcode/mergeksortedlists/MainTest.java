package com.etoitau.leetcode.mergeksortedlists;

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
    void mergeKTest() {
        List<Integer> l1, l2, l3, l4, holder;
        ListNode n1, n2, n3, n4, result, nExpected;
        ListNode[] lists;
        String sExpected, sResult;
        Solution sol = new Solution();

        // example
        l1 = Arrays.asList(1, 4, 5); // set values
        l2 = Arrays.asList(1, 3, 4);
        l3 = Arrays.asList(2, 6);
        n1 = ListHelp.makeList(l1);
        n2 = ListHelp.makeList(l2);
        n3 = ListHelp.makeList(l3);
        lists = new ListNode[]{n1, n2, n3}; // add to array
        result = sol.mergeKLists(lists);
        sResult = ListHelp.printList(result);
        holder = new ArrayList<>();
        holder.addAll(l1); // add to list
        holder.addAll(l2);
        holder.addAll(l3);
        Collections.sort(holder);
        sExpected = ListHelp.printList(ListHelp.makeList(holder));
        assertEquals(sExpected, sResult);

        // one list
        l1 = Arrays.asList(1, 4, 5); // set values
        n1 = ListHelp.makeList(l1);
        lists = new ListNode[]{n1}; // add to array
        result = sol.mergeKLists(lists);
        sResult = ListHelp.printList(result);
        holder = new ArrayList<>(l1); // add to array
        Collections.sort(holder);
        sExpected = ListHelp.printList(ListHelp.makeList(holder));
        assertEquals(sExpected, sResult);

        // four lists
        l1 = Arrays.asList(1, 4, 5); // set values
        l2 = Arrays.asList(1, 3, 4);
        l3 = Arrays.asList(2, 6);
        l4 = Arrays.asList(3, 3, 3, 3, 3, 3);
        n1 = ListHelp.makeList(l1);
        n2 = ListHelp.makeList(l2);
        n3 = ListHelp.makeList(l3);
        n4 = ListHelp.makeList(l4);
        lists = new ListNode[]{n1, n2, n3, n4}; // add to array
        result = sol.mergeKLists(lists);
        sResult = ListHelp.printList(result);
        holder = new ArrayList<>();
        holder.addAll(l1); // add to list
        holder.addAll(l2);
        holder.addAll(l3);
        holder.addAll(l4);
        Collections.sort(holder);
        sExpected = ListHelp.printList(ListHelp.makeList(holder));
        assertEquals(sExpected, sResult);

        // list with one element
        l1 = Arrays.asList(1, 4, 5); // set values
        l2 = Arrays.asList(3);
        l3 = Arrays.asList(2, 6);
        n1 = ListHelp.makeList(l1);
        n2 = ListHelp.makeList(l2);
        n3 = ListHelp.makeList(l3);
        lists = new ListNode[]{n1, n2, n3}; // add to array
        result = sol.mergeKLists(lists);
        sResult = ListHelp.printList(result);
        holder = new ArrayList<>();
        holder.addAll(l1); // add to list
        holder.addAll(l2);
        holder.addAll(l3);
        Collections.sort(holder);
        sExpected = ListHelp.printList(ListHelp.makeList(holder));
        assertEquals(sExpected, sResult);


    }
}