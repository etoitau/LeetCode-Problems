package com.etoitau.leetcode.addbinary;

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
        Solution solver = new Solution();

        String a;
        String b;
        String expected;

        a = "11";
        b = "0";
        expected = "11";
        assertEquals(expected, solver.addBinary(a, b));

        a = "0";
        b = "0";
        expected = "0";
        assertEquals(expected, solver.addBinary(a, b));

        // Examples
        a = "11";
        b = "1";
        expected = "100";
        assertEquals(expected, solver.addBinary(a, b));

        a = "1010";
        b = "1011";
        expected = "10101";
        assertEquals(expected, solver.addBinary(a, b));

    }

}