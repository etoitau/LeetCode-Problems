# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_spiralOrder(self):
        sol = main.Solution()

        n = [[1,2,3],[4,5,6],[7,8,9]]
        expected = [1,2,3,6,9,8,7,4,5]
        result = sol.spiralOrder(n)
        self.assertEqual(expected, result)

        n = [[1, 2, 3, 4]]
        expected = [1, 2, 3, 4]
        result = sol.spiralOrder(n)
        self.assertEqual(expected, result)

        n = [[1], [2], [3], [4]]
        expected = [1, 2, 3, 4]
        result = sol.spiralOrder(n)
        self.assertEqual(expected, result)

        n = [[1, 2], [3, 4], [5, 6]]
        expected = [1, 2, 4, 6, 5, 3]
        result = sol.spiralOrder(n)
        self.assertEqual(expected, result)

        n = [[1, 2, 3], [4, 5, 6]]
        expected = [1, 2, 3, 6, 5, 4]
        result = sol.spiralOrder(n)
        self.assertEqual(expected, result)

        n = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12]]
        expected = [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]
        result = sol.spiralOrder(n)
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()
