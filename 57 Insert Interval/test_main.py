# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_spiralOrder(self):
        sol = main.Solution()

        # ex 1
        n = [[1,3],[6,9]]
        m = [2,5]
        expected = [[1,5],[6,9]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        # ex 2
        n = [[1,2],[3,5],[6,7],[8,10],[12,16]]
        m = [4,8]
        expected = [[1,2],[3,10],[12,16]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        # ex 3
        n = []
        m = [5,7]
        expected = [[5,7]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        # ex 4
        n = [[1,5]]
        m = [2,3]
        expected = [[1,5]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        # ex 5
        n = [[1,5]]
        m = [2,7]
        expected = [[1,7]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        n = [[4, 6], [7, 10]]
        m = [0, 1]
        expected = [[0, 1], [4, 6], [7, 10]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        n = [[4, 6], [7, 10]]
        m = [11, 12]
        expected = [[4, 6], [7, 10], [11, 12]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        n = [[2,4],[5,7],[8,10],[11,13]]
        m = [3,6]
        expected = [[2,7],[8,10],[11,13]]
        result = sol.insert(n, m)
        self.assertEqual(expected, result)

        


if __name__ == '__main__':
    unittest.main()
