package com.etoitau.leetcode.countandsay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void solutionTest() {
        Solution sol = new Solution();
        int n;
        String expected, result;

        n = 1;
        expected = "1";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 4;
        expected = "1211";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 5;
        expected = "111221";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 15;
        expected = "311311222113111231131112132112311321322112111312211312111322212311322113212221";
        result = sol.countAndSay(n);
        assertEquals(expected, result);

        n = 30;
        expected = "";
        try {
            sol.countAndSay(n);
        } catch (Exception e) {
            fail();
        }

    }
}