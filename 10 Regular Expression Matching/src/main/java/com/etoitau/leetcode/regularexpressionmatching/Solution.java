package com.etoitau.leetcode.regularexpressionmatching;

import java.util.*;

/**
 * LeetCode Problem 10 - Regular Expression Matching
 *
 * Result:
 * Runtime: 6 ms, faster than 35.72%
 * Memory Usage: 37.6 MB, less than 59.60%
 *
 * Description:
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
class Solution {

    // object to represent a pattern character, allows us to combine * into char it operates on
    class PatternChar {
        private char c;
        private boolean repeats;

        public PatternChar(char c, boolean repeats) {
            this.c = c;
            this.repeats = repeats;
        }

        public char getChar() {
            return c;
        }

        public boolean repeats() {
            return repeats;
        }

        boolean matches(char c) {
            return (this.c == '.' || this.c == c);
        }

        public String toString() {
            String s = "" + c;
            s += (repeats)? "*": "";
            return s;
        }
    }

    /**
     * Cache for memoization
     * remember result for this si and pi position
     */
    class Cache {
        Map<Integer, Map<Integer, Boolean>> cache;

        public Cache() {
            cache = new HashMap<>();
        }

        public boolean put(int si, int pi, boolean match) {
            if (!cache.containsKey(si)) {
                Map<Integer, Boolean> m = new HashMap<>();
                m.put(pi, match);
                cache.put(si, m);
            } else {
                if (!cache.get(si).containsKey(pi)) {
                    cache.get(si).put(pi, match);
                }
            }
            return match;
        }

        public boolean contains(int si, int pi) {
            if (cache.containsKey(si)) {
                return cache.get(si).containsKey(pi);
            }
            return false;
        }

        public boolean get(int si, int pi) {
            return cache.get(si).get(pi);
        }
    }


    public boolean isMatch(String s, String ps) {
        // check some trivial cases
        if (ps.equals(".*"))
            return true;
        if (s.equals(ps))
            return true;
        if (ps.isEmpty())
            return false;

        // set up cache for memoization
        Cache cache = new Cache();

        // process regex string into PatternChar objects
        List<PatternChar> p = new ArrayList<>();
        int i = 0;
        while (i < ps.length()) {
            if (i < ps.length() - 1 && ps.charAt(i + 1) == '*') {
                p.add(new PatternChar(ps.charAt(i), true));
                i += 2;
            } else {
                p.add(new PatternChar(ps.charAt(i), false));
                i++;
            }
        }

        // return result of recursive analysis
        return matchChar(s, p, 0, 0, cache);
    }

    boolean matchChar(String s, List<PatternChar> p, int si, int pi, Cache cache) {
        if (cache.contains(si, pi))
            return cache.get(si, pi);

        if (pi >= p.size())
            // if past end of pattern, no good
            return cache.put(si, pi, false);;

        if(si >= s.length()) {
            // if past end of source, only maybe okay if rest of pattern is repeaters
            for (int i = pi; i < p.size(); i++) {
                if (!p.get(i).repeats()) {
                    return cache.put(si, pi, false);
                }
            }
            return true;
        }

        char sChar = s.charAt(si);
        PatternChar pChar = p.get(pi);

        if (si == s.length() - 1 && pi == p.size() - 1) {
            // if at end of pattern and source, chars need to match
            return cache.put(si, pi, (pChar.matches(sChar)));
        }

        if (!pChar.matches(sChar)) {
            // if current characters don't match
            if (pChar.repeats()) {
                // if current pattern has *, can say zero, consider next pattern char
                return cache.put(si, pi, matchChar(s, p, si, pi + 1, cache));
            } else {
                return cache.put(si, pi, false);
            }
        } else {
            // if current characters do match
            if (pChar.repeats()) {
                // three possibilities to check:
                // we say yes this pattern char matches and how about another?
                boolean opt1 = matchChar(s, p, si + 1, pi, cache);
                // we say yes this pattern char matches, but let's move on to next
                boolean opt2 = matchChar(s, p, si + 1, pi + 1, cache);
                // we say no let's say there are zero of this and consider next pattern char
                boolean opt3 = matchChar(s, p, si, pi + 1, cache);
                // if any successfully made it to end and exact match, great
                return cache.put(si, pi, (opt1 || opt2 || opt3));
            } else {
                // if current chars do match and don't repeat, move to next of each
                return cache.put(si, pi, matchChar(s, p, si + 1, pi + 1, cache));
            }
        }
    }
}
