# -*- coding: utf-8 -*-

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_minDistance(self):
        sol = main.Solution()

        # ex 1
        word1 = "horse"
        word2 = "ros"
        expected = 3
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)

        # ex 2
        word1 = "intention"
        word2 = "execution"
        expected = 5
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)

        # match
        word1 = "horse"
        word2 = "horse"
        expected = 0
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)

        # reversed
        word1 = "horse"
        word2 = "ros"
        expected = 3
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)

        # empty input
        word1 = ""
        word2 = ""
        expected = 0
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)

        # one empty
        word1 = ""
        word2 = "word"
        expected = 4
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)

        # time limit exceeded
        # previous solution was O(3^N). Add memoization to get O(N^2)
        word1 = "dinitrophenylhydrazine"
        word2 = "acetylphenylhydrazine"
        expected = 6
        result = sol.minDistance(word1, word2)
        self.assertEqual(expected, result)





if __name__ == '__main__':
    unittest.main()
