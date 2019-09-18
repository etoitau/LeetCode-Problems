package com.etoitau.leetcode.five;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


/**
 * Tests using junit5
 */
public class SolutionTest {
    static Solution s = new Solution();
    static Map<String,Integer> testStrings = new HashMap<>();

    @BeforeAll
    static void setup() {
        testStrings.put("babad", 3); // bab or aba
        testStrings.put("cbbd", 2); // bb
        testStrings.put("badabab", 5); // badab
        testStrings.put("babadab", 5); // badab
        testStrings.put("abcde", 1);
        testStrings.put("racecar", 7);
        testStrings.put("1!_ +", 1);
        testStrings.put("", 0);
        testStrings.put("cee", 2);
        testStrings.put("egbb", 2);
        testStrings.put("ifgeafi", 1);
    }


    @Test
    void checkPalindrome() {
        List<String> pals = Arrays.asList("racecar", "abba", "a", "", "aaaa", ". .", "12321");
        for (String pal: pals) {
            assertTrue(s.checkPalindrome(pal), "Failed on %s\nShould be true");
        }
        List<String> nots = Arrays.asList("racecare", "abna", "ab a", ".. ", "13321");
        for (String not: nots) {
            assertFalse(s.checkPalindrome(not), "Failed on %s\nShould be false");
        }
    }

    @Test
    void longestPalindromeBrute() {
        String result;
        for (Map.Entry<String, Integer> testString: testStrings.entrySet()) {
            result = s.longestPalindromeBrute(testString.getKey());
            assertEquals(testString.getValue(),
                    result.length(),
                    String.format("Failed on %s\nShould be %d\n      got %s", testString.getKey(), testString.getValue(), result));
        }
    }


    @Test
    void oneTest() {
        String test = "cee";
        int len = 2;
        String result = s.longestPalindrome(test);
        assertEquals(len, result.length());
    }

    @Test
    void listTest() {
        String result;
        for (Map.Entry<String, Integer> testString: testStrings.entrySet()) {
            result = s.longestPalindrome(testString.getKey());
            assertEquals(testString.getValue(),
                    result.length(),
                    String.format("Failed on %s\nShould be %d\n      got %s", testString.getKey(), testString.getValue(), result));
        }
    }

    @Test
    void stressTest() {
        Random rand = new Random();
        String srcChars = "abcdefghijklm";
        StringBuilder sb = new StringBuilder();
        int nTests = 2000, stringSize = 1000;
        for (int i = 0; i < nTests; i++) {
            int thisLen = rand.nextInt(stringSize);
            for (int j = 0; j < thisLen; j++) {
                int index = rand.nextInt(srcChars.length());
                sb.append(srcChars.charAt(index));
            }
            String test = sb.toString();
            int brute = s.longestPalindromeBrute(test).length();
            int opt = s.longestPalindrome(test).length();
            assertEquals(brute, opt, "Failed on " + test);
            sb.setLength(0);
        }
    }
}
