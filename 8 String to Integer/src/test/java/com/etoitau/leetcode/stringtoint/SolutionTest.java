package com.etoitau.leetcode.stringtoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class SolutionTest {

    @Test
    void myAtoi() {
        Solution sol = new Solution();

        String input;
        int output;

        input = "42";
        output= 42;
        assertEquals(output, sol.myAtoi(input));

        input = "   -42";
        output= -42;
        assertEquals(output, sol.myAtoi(input));

        input = "4193 with words";
        output= 4193;
        assertEquals(output, sol.myAtoi(input));

        input = "words and 987";
        output= 0;
        assertEquals(output, sol.myAtoi(input));

        // out of range so INT_MIN returned
        input = "-91283472332";
        output= -2147483648;
        assertEquals(output, sol.myAtoi(input));

        input = "+1";
        output = 1;
        assertEquals(output, sol.myAtoi(input));

        input = "++1";
        output = 0;
        assertEquals(output, sol.myAtoi(input));

        input = "+-1";
        output = 0;
        assertEquals(output, sol.myAtoi(input));

        input = "-+1";
        output = 0;
        assertEquals(output, sol.myAtoi(input));

        input = "  +1";
        output = 1;
        assertEquals(output, sol.myAtoi(input));

        input = "  +-1";
        output = 0;
        assertEquals(output, sol.myAtoi(input));

        input = Integer.toString(Integer.MAX_VALUE);
        output = Integer.MAX_VALUE;
        assertEquals(output, sol.myAtoi(input));

        input = Integer.toString(Integer.MIN_VALUE);
        output = Integer.MIN_VALUE;
        assertEquals(output, sol.myAtoi(input));

        // max and min are -2,147,483,648 and 2,147,483,647
        input = "2147483648"; // one more
        output = Integer.MAX_VALUE;
        assertEquals(output, sol.myAtoi(input));

        input = "-2147483649";
        output = Integer.MIN_VALUE;
        assertEquals(output, sol.myAtoi(input));

        input = Integer.toString(Integer.MAX_VALUE - 1);
        output = Integer.MAX_VALUE - 1;
        assertEquals(output, sol.myAtoi(input));

        input = Integer.toString(Integer.MIN_VALUE + 1);
        output = Integer.MIN_VALUE + 1;
        assertEquals(output, sol.myAtoi(input));

        input = "  0000000000012345678";
        output = 12345678;
        assertEquals(output, sol.myAtoi(input));

        input = "  -0000000000012345678";
        output = -12345678;
        assertEquals(output, sol.myAtoi(input));

        input = "    0000000000000   ";
        output = 0;
        assertEquals(output, sol.myAtoi(input));

        input = "-6147483648";
        output = -2147483648;
        assertEquals(output, sol.myAtoi(input));

        input = "-   234";
        output = 0;
        assertEquals(output, sol.myAtoi(input));

        input = " ";
        output = 0;
        assertEquals(output, sol.myAtoi(input));
    }
}