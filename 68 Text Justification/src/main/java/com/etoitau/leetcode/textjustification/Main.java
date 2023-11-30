package com.etoitau.leetcode.textjustification;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(solver.fullJustify(words, 16));
    }
}


class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // repeatedly determine a range of words that can fit on a line
        // pass charCount to padLine to since we'll need to do it both places?
        int start = 0;
        int end = 0;
        int charCount = 0;
        List<String> lines = new ArrayList<>();
        while (true) {
            // collect a line
            while (end < words.length && charCount + (end - start - 1) + words[end].length() < maxWidth) {
                // while another word fits on line
                end += 1;
                charCount += words[end - 1].length();
            }
            // collect padded line
            if (end < words.length) {
                lines.add(padLine(words, start, end, charCount, maxWidth));
            } else {
                lines.add(padFinalLine(words, start, end, maxWidth));
                return lines;
            }
            start = end;
            charCount = 0;
        }
    }

    private String padLine(String[] words, int start, int end, int charCount, int width) {
        if (end - start == 1) {
            // A line with one word acts the same as a final line
            return padFinalLine(words, start, end, width);
        }
        int spaces = width - charCount;
        int gaps = end - start - 1;
        int spacesPerGap = spaces / gaps;
        int remainder = spaces % gaps;

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + remainder; i++) {
            // remainder spaces get distributed one to each of the first spaces
            sb.append(words[i]);
            addSpaces(sb, spacesPerGap + 1);
        }
        for (int i = start + remainder; i < end - 1; i++) {
            // regular spaces without extra remainder
            sb.append(words[i]);
            addSpaces(sb, spacesPerGap);
        }
        // add the last word with no space
        sb.append(words[end - 1]);
        return sb.toString();
    }

    private String padFinalLine(String[] words, int start, int end, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end - 1; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[end - 1]);
        addSpaces(sb, width - sb.length());
        return sb.toString();
    }

    private StringBuilder addSpaces(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb;
    }
}
