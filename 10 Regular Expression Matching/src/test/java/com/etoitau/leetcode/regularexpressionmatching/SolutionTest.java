package com.etoitau.leetcode.regularexpressionmatching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class SolutionTest {

    @Test
    void isMatch() {
        Solution sol = new Solution();
        String s, p;
        boolean result;

        s = "aa";
        p = "a";
        result = false;
        assertEquals(result, sol.isMatch(s, p));

        s = "aa";
        p = "a*";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "ab";
        p = ".*";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "aab";
        p = "c*a*b";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "mississippi";
        p = "mis*is*p*.";
        result = false;
        assertEquals(result, sol.isMatch(s, p));

        s = "cellar";
        p = ".el*a.";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "cellar";
        p = ".el*a.b*g*";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "cellar";
        p = "b*cel.*";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "cellar";
        p = "b*c.*rc*";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        s = "clearer";
        p = ".*r";
        result = true;
        assertEquals(result, sol.isMatch(s, p));

        // time limit item
        s = "aaaaaaaaaaaaab";
        p = "a*a*a*a*a*a*a*a*a*a*a*a*b";
        result = true;
        assertEquals(result, sol.isMatch(s, p));
    }
}