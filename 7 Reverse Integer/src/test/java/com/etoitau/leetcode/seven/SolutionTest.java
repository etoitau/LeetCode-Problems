package com.etoitau.leetcode.seven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverse() {
        int in = 0;
        int out = 0;
        Solution sol = new Solution();

        in = 123;
        out = 321;
        assertEquals(out, sol.reverse(in));

        in = -123;
        out = -321;
        assertEquals(out, sol.reverse(in));

        in = 120;
        out = 21;
        assertEquals(out, sol.reverse(in));

        in = -120;
        out = -21;
        assertEquals(out, sol.reverse(in));

        in = 1200;
        out = 21;
        assertEquals(out, sol.reverse(in));

        in = -1200;
        out = -21;
        assertEquals(out, sol.reverse(in));

        in = 0;
        out = 0;
        assertEquals(out, sol.reverse(in));

        in = Integer.MAX_VALUE;
        out = 0;
        assertEquals(out, sol.reverse(in));

        in = Integer.MIN_VALUE;
        out = 0;
        assertEquals(out, sol.reverse(in));
    }
}