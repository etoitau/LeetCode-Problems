package com.etoitau.leetcode.lettercombophone;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) { return new ArrayList<String>(); }

        // source characters
        char[] src = digits.toCharArray();
        for (int i = 0; i < src.length; i++) {
            src[i] = (char) ((src[i] - 50) * 3);
        }

        // number of strings in result
        int size = (int) Math.pow(3, src.length);
        // list for result
        List<String> out = new ArrayList<>(size);
        // array to keep base 3 number representing which permutation we're on
        int seq[] = new int[src.length];

        // init so that first call takes to 0
        seq[seq.length - 1]--;

        StringBuilder sb;
        // for each element in result
        for (int i = 0; i < size; i++) {
            sb = new StringBuilder(src.length);
            // increment base 3 counter
            inc3(seq);
            // build this string
            for (int j = 0; j < src.length; j++) {
                sb.append((char) (src[j] + seq[j] + 97));
            }
            out.add(sb.toString());
        }
        return out;
    }

    void inc3(int[] seq) {
        seq[seq.length - 1]++;
        for (int i = seq.length - 1; i >= 0; i--) {
            if (seq[i] > 2) {
                seq[i] = 0;
                seq[i - 1]++;
            } else {
                break;
            }
        }
    }
}