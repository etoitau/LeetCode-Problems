package com.etoitau.leetcode.validnumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        Arrays.asList(
                "+3e+3",
                "0",
                // examples
                "2",
                "0089",
                "-0.1",
                "+3.14",
                "4.",
                "-.9",
                "2e10",
                "-90E3",
                "3e+7",
                "+6e-1",
                "53.5e93",
                "-123.456e789"
        ).forEach(s -> assertTrue(solver.isNumber(s), s));
        Arrays.asList(
                "+.e.",
                "+.",
                ".",
                null,
                "3ee3",
                "e",
                "one",
                "",
                // examples
                "abc",
                "1a",
                "1e",
                "e3",
                "99e2.5",
                "--6",
                "-+3",
                "95a54e53"
        ).forEach(s -> assertFalse(solver.isNumber(s), s));
    }

}