# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_spiralOrder(self):
        sol = main.Solution()

        n = [[1,3],[2,6],[8,10],[15,18]]
        expected = [[1,6],[8,10],[15,18]]
        result = sol.merge(n)
        self.assertEqual(expected, result)

        n = [[1,4],[4,5]]
        expected = [[1,5]]
        result = sol.merge(n)
        self.assertEqual(expected, result)

        n = [[1, 20], [2, 3], [5, 6]]
        expected = [[1, 20]]
        result = sol.merge(n)
        self.assertEqual(expected, result)

        n = [[1, 20], [2, 3], [5, 6], [22, 23]]
        expected = [[1, 20], [22, 23]]
        result = sol.merge(n)
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()
