#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_combine(self):
        sol = main.Solution()

        # ex 1
        n = 4
        k = 2
        expected = [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        self.assertEqual(expected, sol.combine(n, k))

        # ex 2
        n = 1
        k = 1
        expected = [[1]]
        self.assertEqual(expected, sol.combine(n, k))

        # all
        n = 2
        k = 2
        expected = [[1, 2]]
        self.assertEqual(expected, sol.combine(n, k))

        


if __name__ == '__main__':
    unittest.main()
