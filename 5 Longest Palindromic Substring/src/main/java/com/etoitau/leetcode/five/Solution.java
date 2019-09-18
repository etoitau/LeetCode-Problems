package com.etoitau.leetcode.five;

import java.util.*;

public class Solution {
    // brute force approach for stress testing
    // for reference:
    // runtime 1043 ms
    // memory use 36.8 MB beats 99%
    public String longestPalindromeBrute(String s) {
        int maxLength = 0;
        String maxPal = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String testString = s.substring(i, j + 1);
                if (checkPalindrome(testString) && testString.length() > maxLength) {
                    maxLength = testString.length();
                    maxPal = testString;
                }
            }
        }
        return maxPal;
    }

    // confirms a string is a palindrome
    public Boolean checkPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // what I came up with
    // runtime 365 ms beats 8.5%
    // memory use 96.5 MB
    public String longestPalindromeMyIdea(String s) {
        if (s.length() < 2) {
            return s;
        }

        int bestStart = 0, bestLength = 1;

        Set<Pair> memo = new HashSet<>();

        // loop over characters from beginning to end
        // exclude last character bc we already have length 1 candidate
        for (int i = 0; i < s.length() - 1; i++) {
            // is it possible to construct a new best from this start?
            if (i > s.length() - bestLength - 1) {
                break;
            }
            // loop over characters from end to beginning
            // exclude first char as trivial
            for (int j = s.length() - 1; j > i; j--) {
                // is it possible to construct a new best from this start?
                if (j < bestLength) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    // found start and end of candidate
                    Pair pair = new Pair(i, j);

                    if (memo.add(pair)) {
                        // add this match to set, if it's a new match then see if it continues
                        int count = 1;
                        // new pair with i++ and j-- (next indices from here to compare)
                        pair = pair.inc();
                        while ( pair.getI() < s.length() && pair.getJ() >= 0 && s.charAt(pair.getI()) == s.charAt(pair.getJ()) ) {
                            // while valid indices and matching
                            if (pair.getI() == pair.getJ()) {
                                // if we hit middle of odd length string, we know the rest also matches and we have palindrome
                                count = count * 2 + 1;
                                if (count > bestLength) {
                                    bestLength = count;
                                    bestStart = i;
                                }
                                break;
                            } else if (pair.getI() > pair.getJ()) {
                                // if cross middle of even length string, we know the rest matches and we have palindrome
                                count = count * 2;
                                if (count > bestLength) {
                                    bestLength = count;
                                    bestStart = i;
                                }
                                break;
                            }
                            // increment, add to set, update best so far
                            count++;
                            memo.add(pair);
                            pair = pair.inc();
                        }
                    }
                }
            }
        }
        return s.substring(bestStart, bestStart + bestLength);
    }

    public final class Pair {
        private final int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public Pair inc() {
            return new Pair(this.i + 1, this.j - 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    // what I came up with after looking at average submitted solution
    // runtime 11 ms beats 61%
    // memory use 35.9 MB beats 100%
    public String longestPalindrome(String s) {
        // this algorithm works by picking an index and seeing what is the biggest palindrome that has that index
        // as it's center. Once a large palindrome is found it eliminates a lot of the search space, and the large
        // palindromes are centered near the center of the string, so we start at the center and work our way out
        // upward toward the end and downward toward the beginning

        // check the trivial case
        if (s.length() < 2) {
            return s;
        }

        // start with the first character as the best and try to beat it
        int bestLen = 1;
        String bestPal = s.substring(0, bestLen);

        // these are the max and min starting indices that could result in a new best
        // they're updated whenever the current best is
        int minI = bestLen / 2;
        int maxI = s.length() - 1 - (bestLen +1) / 2;

        // two indices for where to start the search, one will work up to end of string and one down to start
        int startIDn = (s.length() - 1) / 2;
        int startIUp = Math.min(maxI, startIDn + 1);

        // boolean to alternate which index we're checking this loop
        Boolean isUp = false;

        // each loop starts from an index and checks largest palindrome centered there
        // have to treat differently if we assume it will be an even or odd length
        while (startIUp <= maxI || startIDn >= minI) {
            // start and end point of the palindrome we've found so far
            int start, end;

            // check odd len palindrome
            // alternate around middle point
            start = (isUp)? startIUp: startIDn;
            end = start;
            while ( start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            }
            if (end + 1 - start > bestLen) {
                bestPal = s.substring(start, end + 1);
                bestLen = end + 1 - start;
                minI = bestLen / 2;
                maxI = s.length() - 1 - (bestLen +1) / 2;
            }

            // check even length pal
            // alternate around middle point
            start = (isUp)? startIUp + 1: startIDn + 1;
            end = start - 1;
            while ( start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            }
            if (end + 1 - start > bestLen) {
                bestPal = s.substring(start, end + 1);
                bestLen = end + 1 - start;
                minI = bestLen / 2;
                maxI = s.length() - 1 - (bestLen +1) / 2;
            }

            // alternate for next round
            if (isUp) {
                startIUp++;
            } else {
                startIDn--;
            }
            isUp = !isUp;
        }
        return bestPal;
    }
}
