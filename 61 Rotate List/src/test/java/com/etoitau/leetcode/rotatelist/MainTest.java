package com.etoitau.leetcode.rotatelist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution sol = new Solution();

        // provided examples
        rotationTest(sol, List.of(1, 2, 3, 4, 5), 2, List.of(4, 5, 1, 2, 3));
        rotationTest(sol, List.of(0, 1, 2), 4, List.of(2, 0, 1));
        // simple
        rotationTest(sol, List.of(1, 2, 3, 4), 2, List.of(3, 4, 1, 2));
        // noop
        rotationTest(sol, List.of(1, 2, 3, 4), 0, List.of(1, 2, 3, 4));
        // k > len
        rotationTest(sol, List.of(1, 2, 3, 4), 10, List.of(3, 4, 1, 2));
        // same value
        rotationTest(sol, List.of(1, 1, 1), 10, List.of(1, 1, 1));
        // random cases
        rotationTest(sol, List.of(9, 1, 6), 0, List.of(9, 1, 6));
        rotationTest(sol, List.of(5, 2, 6, 4), 4, List.of(5, 2, 6, 4));
        rotationTest(sol, List.of(4, 0, 1, 4, 3), 4, List.of(0, 1, 4, 3, 4));
    }

    void rotationTest(Solution solver, List<Integer> start, int k, List<Integer> expected) {
        assertTrue(
                Solution.listNodeEquals(
                        solver.rotateRight(Solution.fromList(start), k),
                        Solution.fromList(expected)
                )
        );
    }

    @Test
    void bruteTest() {
        Solution solver = new Solution();
        // Randomly generate a bunch of tests and check both methods give the same result
        int numLists = 10;
        int maxSize = 6;
        Random rand = new Random();
        for (int i = 0; i < numLists; i++) {
            List<Integer> source = randomList(rand.nextInt(maxSize));
            for (int k = 0; k < source.size() * 3; k++) {
                bruteHelper(solver, source, k);
            }
        }
    }

    List<Integer> randomList(int size) {
        Random rand = new Random();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ret.add(rand.nextInt(10));
        }
        return ret;
    }

    void bruteHelper(Solution solver, List<Integer> source, int k) {
        if (! Solution.listNodeEquals(
                solver.rotateRight(Solution.fromList(source), k),
                solver.rotateRightNaive(Solution.fromList(source), k)
        )) {
            System.out.println(source.toString());
            System.out.println(k);
            fail();
        }
    }


    @Test
    void listEqualTest() {
        ListNode small = Solution.fromList(List.of(1, 2));
        ListNode large = Solution.fromList(List.of(1, 2, 3, 4));
        ListNode same = Solution.fromList(List.of(1, 2));
        assertTrue(Solution.listNodeEquals(small, same));
        assertTrue(Solution.listNodeEquals(same, small));
        assertTrue(Solution.listNodeEquals(large, large));
        assertFalse(Solution.listNodeEquals(small, large));
        assertFalse(Solution.listNodeEquals(large, small));
        // check loop
        ListNode oneLoop = new ListNode(1);
        ListNode toOne = new ListNode(2, oneLoop);
        oneLoop.next = toOne;
        ListNode two = new ListNode(2);
        ListNode oneTwo = new ListNode(1, two);
        assertTrue(Solution.listNodeEquals(small, oneTwo));
        assertFalse(Solution.listNodeEquals(oneLoop, oneTwo));
        assertFalse(Solution.listNodeEquals(oneTwo, oneLoop));
        assertFalse(Solution.listNodeEquals(oneLoop, small));
        assertFalse(Solution.listNodeEquals(toOne, two));
        assertTrue(Solution.listNodeEquals(small.next, two));
    }
}