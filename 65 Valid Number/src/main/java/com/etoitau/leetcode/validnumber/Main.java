package com.etoitau.leetcode.validnumber;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.isNumber("3.4e5"));
    }
}


class Solution {

    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("[eE]");
        Matcher matcher = pattern.matcher(s);
        int eAt = -1;
        if (matcher.find()) {
            // has some e
            eAt = matcher.start();
            if (matcher.find()) {
                // has more than one e, NG
                return false;
            }
        }
        if (eAt > -1) {
            // Has one e
            if ((eAt == 0) || (eAt == s.length() - 1)) {
                // e is at start or end, NG
                return false;
            }
            return isDecimal(s.substring(0, eAt)) && isInteger(s.substring(eAt + 1));
        }
        // No e
        return isDecimal(s);
    }

    private boolean isDecimal(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() == 1) {
                // It's only a sign
                return false;
            }
            // consume a sign
            s = s.substring(1);
        }
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            // has some dot
            if (s.length() == 1) {
                // it's only a dot
                return false;
            }
            int dotAt = matcher.start();
            if (matcher.find()) {
                // has more than one dot
                return false;
            }
            if (dotAt == 0) {
                // dot at the start
                return isDigits(s.substring(1));
            }
            if (dotAt == s.length() - 1) {
                // dot at the end
                return isDigits(s.substring(0, s.length() - 1));
            }
            // dot in the middle
            return isDigits(s.substring(0, dotAt)) && isDigits(s.substring(dotAt + 1));
        }
        // no dot
        return isDigits(s);
    }

    private boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.length() == 1) {
                // only a sign
                return false;
            }
            return isDigits(s.substring(1));
        }
        return isDigits(s);
    }

    /**
     * String has no characters but digits 0 to 9
     */
    private boolean isDigits(String s) {
        return s.matches("[0-9]*");
    }
}
