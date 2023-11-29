package com.etoitau.leetcode.addbinary;


public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.addBinary("11", "11"));
    }
}


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int place = 0;
        int carry = 0;
        while (place < a.length() || place < b.length()) {
            int resBit = bitAt(a, place) + bitAt(b, place) + carry;
            res.append(resBit % 2);
            carry = resBit / 2;
            place++;
        }
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    private int bitAt(String src, int place) {
        if (place < src.length() && (src.charAt(src.length() - 1 - place) == '1')) {
            return 1;
        }
        return 0;
    }
}
