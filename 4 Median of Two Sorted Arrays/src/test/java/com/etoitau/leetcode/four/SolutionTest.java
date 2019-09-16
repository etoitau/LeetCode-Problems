package com.etoitau.leetcode.four;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMedianSortedArrays() {
        int[] A = new int[]{1, 3};
        int[] B = new int[]{2};
        double ans = 2;
        double got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1, 2};
        B = new int[]{3, 4};
        ans = 2.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{};
        B = new int[]{3, 4};
        ans = 3.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1};
        B = new int[]{};
        ans = 1;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{0, 0, 4, 4};
        B = new int[]{0, 3, 3, 4};
        ans = 3;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{0, 0, 0, 0, 5, 5};
        B = new int[]{4, 4, 4, 4, 4, 4};
        ans = 4;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{4, 5, 6, 7, 8};
        B = new int[]{0, 0};
        ans = 5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1, 2, 3};
        B = new int[]{4, 5, 6};
        ans = 3.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1, 2};
        B = new int[]{-1, 3};
        ans = 1.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1, 2};
        B = new int[]{1, 2};
        ans = 1.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1};
        B = new int[]{2, 3, 4};
        ans = 2.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1, 1, 3, 3};
        B = new int[]{1, 1, 3, 3};
        ans = 2;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{3};
        B = new int[]{1, 2, 4};
        ans = 2.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{1, 5, 9, 10};
        B = new int[]{2, 3, 4, 6, 7, 8};
        ans = 5.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);

        A = new int[]{4};
        B = new int[]{1, 2, 3, 5, 6};
        ans = 3.5;
        got = Solution.findMedianSortedArrays(A, B);
        assertEquals(ans, got, 0.1);
    }


}