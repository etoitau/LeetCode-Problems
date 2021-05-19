# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_spiralOrder(self):
        sol = main.Solution()

        n = 1
        expected = [[1]]
        result = sol.generateMatrix(n)
        self.assertEqual(expected, result)

        n = 2
        expected = [[1, 2], [4, 3]]
        result = sol.generateMatrix(n)
        self.assertEqual(expected, result)

        n = 3
        expected = [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
        result = sol.generateMatrix(n)
        self.assertEqual(expected, result)

        n = 4
        expected = [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
        result = sol.generateMatrix(n)
        self.assertEqual(expected, result)

        


if __name__ == '__main__':
    unittest.main()
