package com.etoitau.leetcode.sudokusolver;

public class SudokuChecker {
    public boolean isValidSudoku(char[][] board) {
        // check trivial case where board is super sparse
        SectionTracker tracker = new SectionTracker();
        boolean ok = true;
        wholeBoard:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tracker.foundNotOK(board[i][j])) {
                    ok = false;
                    break wholeBoard;
                }
            }
        }
        if (ok) { return true; }

        // check rows
        for (int i = 0; i < 9; i++) {
            tracker = new SectionTracker();
            for (int j = 0; j < 9; j++) {
                if (tracker.foundNotOK(board[i][j])) { return false; }
            }
        }

        // check columns
        for (int i = 0; i < 9; i++) {
            tracker = new SectionTracker();
            for (int j = 0; j < 9; j++) {
                if (tracker.foundNotOK(board[j][i])) { return false; }
            }
        }

        // check boxes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tracker = new SectionTracker();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (tracker.foundNotOK(board[i * 3 + k][j * 3 + l])) { return false; }
                    }
                }
            }
        }

        // made it through all checks
        return true;
    }
}

class SectionTracker {
    private boolean[] found = new boolean[9];

    boolean foundNotOK(char c) {
        // 1 is 49, 9 is 57
        int num = c - 49;
        if (num < 0 || num > 8) { return false; }
        if (found[num]) {
            return true;
        } else {
            found[num] = true;
            return false;
        }
    }
}
