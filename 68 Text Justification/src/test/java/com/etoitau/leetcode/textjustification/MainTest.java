package com.etoitau.leetcode.textjustification;

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

        String[] words;
        List<String> expectedLines;
        int maxWidth;

        words = new String[]{"This", "this", "this"};
        maxWidth = 5;
        expectedLines = List.of(
                "This ",
                "this ",
                "this "
        );
        assertLinesMatch(expectedLines, solver.fullJustify(words, maxWidth));

        words = new String[]{"One"};
        maxWidth = 5;
        expectedLines = List.of(
                "One  "
        );
        assertLinesMatch(expectedLines, solver.fullJustify(words, maxWidth));

        // Provided examples
        words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        maxWidth = 16;
        expectedLines = List.of(
                "This    is    an",
                "example  of text",
                "justification.  "
        );
        assertLinesMatch(expectedLines, solver.fullJustify(words, maxWidth));

        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        expectedLines = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );
        assertLinesMatch(expectedLines, solver.fullJustify(words, maxWidth));

        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a",
                "computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        expectedLines = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );
        assertLinesMatch(expectedLines, solver.fullJustify(words, maxWidth));
    }

}