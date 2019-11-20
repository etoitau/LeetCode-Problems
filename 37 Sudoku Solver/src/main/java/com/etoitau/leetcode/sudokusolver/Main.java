package com.etoitau.leetcode.sudokusolver;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem 37 - Sudoku Solver
 *
 * Result:
 * Runtime: 5 ms, faster than 85.01%
 * Memory Usage: 34.6 MB, less than 73.68%
 *
 * Description:
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'
 *
 * Note:
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9
 */
class Solution {
    public void solveSudoku(char[][] board) {
        // initialize Board object and Cells
        Board b = new Board();
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                b.addCell(board[i][j], i, j);
            }
        }
        // deduce as many cells as possible before more brute force approach
        b.update();

        // depth-first backtracking algorithm to complete square
        short index = 0;
        while (index < b.getUnknowns().size() && index > -1) {
            if (b.getUnknowns().get(index).tryNext()) {
                index++;
            } else {
                index--;
            }
        }

        // fill in original board
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = b.getCell(i, j).getValue();
                }
            }
        }

    }
}

/**
 * holds cells and updates self to deduce values of some unknown cells
 */
class Board {
    private Cell[][] cells = new Cell[9][9];
    private List<Cell> unknowns = new ArrayList<>(64); // cells with unknown value. note board must have at least 17 clues to be valid
    private ToDoListItterator updateWith = new ToDoListItterator(); // iterator with newly determined cells we can update against

    public Cell getCell(short row, short col) {
        return cells[row][col];
    }

    public List<Cell> getUnknowns() {
        return unknowns;
    }

    public void addCell(char val, short row, short col) {
        cells[row][col] = new Cell(this, val, row, col);
        if (cells[row][col].isKnown()) {
            updateWith.add(cells[row][col]);
        } else {
            unknowns.add(cells[row][col]);
        }
    }

    /**
     * Try to deduce some values to reduce unknowns
     */
    public void update() {
        Cell next, tempCell;
        while (updateWith.hasNext()) {
            next = updateWith.next();
            // rule out for row and column. If causes cell to be determined, add to list
            for (short i = 0; i < 9; i++) {
                // row
                tempCell = cells[next.getRow()][i];
                if (!tempCell.isKnown() && tempCell.notThis(next.getValue())) {
                    updateWith.add(tempCell);
                    unknowns.remove(tempCell);
                }
                // column
                tempCell = cells[i][next.getCol()];
                if (!tempCell.isKnown() && tempCell.notThis(next.getValue())) {
                    updateWith.add(tempCell);
                    unknowns.remove(tempCell);
                }
            }
            // rule out for square
            for (short i = 0; i < 3; i++) {
                for (short j = 0; j < 3; j++) {
                    tempCell = cells[next.getSquareRow() + i][next.getSquareCol() + j];
                    if (!tempCell.isKnown() && tempCell.notThis(next.getValue())) {
                        updateWith.add(tempCell);
                        unknowns.remove(tempCell);
                    }
                }
            }
        }
        // check each set of nine (rows, cols, boxes) to see if any unknown in one of those sets has a possible value
        // that no other unknown in the set has
        List<Cell> localUnknown = new ArrayList<>();
        // check rows
        for (short i = 0; i < 9; i++) {
            // each row
            localUnknown.clear();
            for (short j = 0; j < 9; j++) {
                // if unknown, add to list
                tempCell = cells[i][j];
                if (!tempCell.isKnown()) {
                    localUnknown.add(tempCell);
                }
            }
            checkUniques(localUnknown);
        }
        // check cols
        for (short i = 0; i < 9; i++) {
            localUnknown.clear();
            for (short j = 0; j < 9; j++) {
                tempCell = cells[j][i];
                if (!tempCell.isKnown()) {
                    localUnknown.add(tempCell);
                }
            }
            checkUniques(localUnknown);
        }
        // check boxes
        for (short i = 0; i < 3; i++) {
            for (short j = 0; j < 3; j++) {
                localUnknown.clear();
                for (short k = 0; k < 3; k++) {
                    for (short l = 0; l < 3; l++) {
                        tempCell = cells[i * 3 + k][j * 3 + l];
                        if (!tempCell.isKnown()) {
                            localUnknown.add(tempCell);
                        }
                    }
                }
                checkUniques(localUnknown);
            }
        }
        // if there are new knowns after unique checks, update their status and run update again
        if (updateWith.hasNext()) {
            List<Cell> newlyDetermined = updateWith.getRemaining();
            for (Cell cell: newlyDetermined) {
                cell.setKnown(true);
            }
            update();
        }
    }

    private void checkUniques(List<Cell> localUnknown) {
        Cell tempCell;
        for (short i = 0; i < localUnknown.size(); i++) {
            // for each unknown in the set of nine
            tempCell = localUnknown.get(i);
            cellValues:
            for (char c: tempCell.getCouldBe()) {
                // for each of it's possible values
                for (short j = 0; j < localUnknown.size(); j++) {
                    // for each of the other unknowns in set
                    if (localUnknown.get(j) == tempCell) {
                        // except itself
                        continue;
                    }

                    if (localUnknown.get(j).getCouldBe().contains(c)) {
                        // does it have that value, if so, skip ahead
                        continue cellValues;
                    }
                }
                // if we get here, none of other unknowns have this value, note can't update known status yet
                // or will be overlooked in other checks. update known after this analysis is done
                tempCell.setValue(c);
                tempCell.getCouldBe().clear();
                tempCell.getCouldBe().add(c);
                updateWith.add(tempCell);
                unknowns.remove(tempCell);
                break;
            }
        }
    }

    /**
     * is it valid to put this value in this position?
     * @param val - the value to check
     * @param row - the row where we propose to put it
     * @param col - the column where we propose to put it
     * @param squareRow - the row coordinate of the start of the square it's in
     * @param squareCol - " column ""
     * @return - true if valid, else false
     */
    public boolean validVal(char val, short row, short col, short squareRow, short squareCol) {
        // check row and column
        for (short i = 0; i < 9; i++) {
            // check row
            if (i != col && cells[row][i].getValue() == val) {
                return false;
            }
            // check col
            if (i != row && cells[i][col].getValue() == val) {
                return false;
            }
        }
        // check square
        for (short i = 0; i < 3; i++) {
            for (short j = 0; j < 3; j++) {
                if (squareRow + i == row && squareCol + j == col) {
                    continue;
                }
                if (cells[squareRow + i][squareCol + j].getValue() == val) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(cells[i][j].getValue()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}

/**
 * when we deduce the value of a previously unknown cell, don't want to modify right away bc it can break analysis.
 * This is a to-do list we can add it to and revisit later
 */
class ToDoListItterator {
    List<Cell> toDoList = new ArrayList<>(81);
    short index = 0;

    public void add(Cell toAdd) {
        toDoList.add(toAdd);
    }

    public boolean hasNext() {
        return index < toDoList.size();
    }

    public Cell next() {
        Cell nextCell = toDoList.get(index);
        index++;
        return nextCell;
    }

    public List<Cell> getRemaining() {
        List<Cell> rem = new ArrayList<>();
        if (!hasNext()) {
            return rem;
        }
        for (int i = index; i < toDoList.size(); i++) {
            rem.add(toDoList.get(i));
        }
        return rem;
    }
}

/**
 * Represents a cell of the sudoku board
 */
class Cell {
    private Board board;
    private boolean known;
    private char value;
    private short row, col, trialIndex = -1;
    private List<Character> couldBe; // possible values this could hold from what we know of surroundings

    public Cell(Board board, char c, short row, short col) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.value = c;
        if (c != '.') {
            known = true;
        } else {
            couldBe = getOneToNine();
        }
    }

    public boolean isKnown() {
        return known;
    }

    public char getValue() {
        return value;
    }

    public short getRow() {
        return row;
    }

    public short getCol() {
        return col;
    }

    public short getSquareRow() {
        return (short)(row - row % 3);
    }

    public short getSquareCol() {
        return (short)(col - col % 3);
    }

    public List<Character> getCouldBe() {
        return couldBe;
    }

    public void setValue(char c) {
        value = c;
    }

    /**
     * eliminate a possible value for this cell
     * if cell is left with one possibility, update
     * @param val - possibility to rule out
     * @return - true if cell is now known, else false
     */
    public boolean notThis(char val) {
        if (!known) {
            couldBe.remove(Character.valueOf(val));
            if (couldBe.size() == 1) {
                known = true;
                value = couldBe.get(0);
                return true;
            }
        }
        return false;
    }

    public void setKnown(boolean isKnown) {
        known = isKnown;
    }

    // method used in backtrack search. Advance to the next value this cell could take and return true,
    // or if not possible, reset and return false
    public boolean tryNext() {
        while (trialIndex < couldBe.size() - 1) {
            trialIndex++;
            if (board.validVal(couldBe.get(trialIndex), row, col, getSquareRow(), getSquareCol())) {
                value = couldBe.get(trialIndex);
                return true;
            }
        }
        trialIndex = -1;
        value = '.';
        return false;
    }

    // to initialize list of possible values
    public static List<Character> getOneToNine() {
        return new ArrayList<Character>() {{
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }};
    }
}
