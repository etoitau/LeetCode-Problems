#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_exist(self):
        sol = main.Solution()

        # ex 1
        board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        word = "ABCCED"
        expected = True
        self.assertEqual(expected, sol.exist(board, word))

        # ex 2
        board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        word = "SEE"
        expected = True
        self.assertEqual(expected, sol.exist(board, word))

        # ex 3
        board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        word = "ABCB"
        expected = False
        self.assertEqual(expected, sol.exist(board, word))

        # one row
        board = [["A","B","C","E"]]
        word = "CB"
        expected = True
        self.assertEqual(expected, sol.exist(board, word))

        # one col
        board = [["A"],["B"],["C"],["E"]]
        word = "CB"
        expected = True
        self.assertEqual(expected, sol.exist(board, word))

        # no reuse
        board = [["A"],["B"]]
        word = "ABA"
        expected = False
        self.assertEqual(expected, sol.exist(board, word))

        


if __name__ == '__main__':
    unittest.main()
