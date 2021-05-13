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
        n = "Hello world"
        expected = 5
        result = sol.lengthOfLastWord(n)
        self.assertEqual(expected, result)

        # ex 2
        n = " "
        expected = 0
        result = sol.lengthOfLastWord(n)
        self.assertEqual(expected, result)

        n = "Hello"
        expected = 5
        result = sol.lengthOfLastWord(n)
        self.assertEqual(expected, result)

        n = "a "
        expected = 1
        result = sol.lengthOfLastWord(n)
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()
