# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_spiralOrder(self):
        sol = main.Solution()

        n = [2,3,1,1,4]
        expected = True
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [3,2,1,0,4]
        expected = False
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [1, 0, 2, 3]
        expected = False
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [3, 0, 1, 2]
        expected = True
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [1, 1, 1, 1]
        expected = True
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [2, 1, 0, 1]
        expected = False
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [10,9,8,7,6,5,4,3,2,1,1,0,0]
        expected = False
        result = sol.canJump(n)
        self.assertEqual(expected, result)

        n = [2,5,0,0]
        expected = True
        result = sol.canJump(n)
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()
