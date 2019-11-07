package com.etoitau.leetcode.substringwithconcatenationofallwords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * junit5
 */
class MainTest {

    @Test
    void main() {
        Solution sol = new Solution();
        String s;
        String[] words;
        List<Integer> expected, result;

        s = "barfoothefoobarman";
        words = new String[]{"foo","bar"};
        expected = Arrays.asList(0,9);
        assertTrue(listsMatch(expected, sol.findSubstring(s, words)));

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word","good","best","word"};
        expected = Arrays.asList();
        result = sol.findSubstring(s, words);
        assertTrue(listsMatch(expected, result));

        s = "aaaaaa";
        words = new String[]{"a", "a"};
        expected = Arrays.asList(0, 1, 2, 3, 4);
        result = sol.findSubstring(s, words);
        assertTrue(listsMatch(expected, result));

        s = "wordgoodgoodgoodbestwordword";
        words = new String[]{"word","good","best","word"};
        expected = Arrays.asList(12);
        result = sol.findSubstring(s, words);
        assertTrue(listsMatch(expected, result));

        s = "";
        words = new String[]{};
        expected = Arrays.asList();
        result = sol.findSubstring(s, words);
        assertTrue(listsMatch(expected, result));

        s = "";
        words = new String[]{"word"};
        expected = Arrays.asList();
        result = sol.findSubstring(s, words);
        assertTrue(listsMatch(expected, result));

        s = "word";
        words = new String[]{};
        expected = Arrays.asList();
        result = sol.findSubstring(s, words);
        assertTrue(listsMatch(expected, result));

    }

    @Test
    void listsMatchTest() {
        List<Integer> one, two;

        one = Arrays.asList(1, 2, 3);
        two = Arrays.asList(1, 2, 3);
        assertTrue(listsMatch(one, two));

        one = Arrays.asList(1, 2, 3);
        two = Arrays.asList(1, 3, 2);
        assertTrue(listsMatch(one, two));

        one = Arrays.asList(1, 2, 2);
        two = Arrays.asList(2, 2, 1);
        assertTrue(listsMatch(one, two));

        one = Arrays.asList(1, 1, 1);
        two = Arrays.asList(1, 1, 1);
        assertTrue(listsMatch(one, two));

        one = Arrays.asList(1, 1, 1);
        two = Arrays.asList(1, 1);
        assertFalse(listsMatch(one, two));

        one = Arrays.asList(1, 2, 1);
        two = Arrays.asList(1, 2, 2);
        assertFalse(listsMatch(one, two));
    }

    private boolean listsMatch(List<Integer> one, List<Integer> two) {
        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }
}