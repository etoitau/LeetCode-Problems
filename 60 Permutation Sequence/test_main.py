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
        n = 3
        k = 3
        expected = "213"
        result = sol.getPermutation(n, k)
        self.assertEqual(expected, result)

        # ex 2
        n = 4
        k = 9
        expected = "2314"
        result = sol.getPermutation(n, k)
        self.assertEqual(expected, result)

        # ex 3
        n = 3
        k = 1
        expected = "123"
        result = sol.getPermutation(n, k)
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()
