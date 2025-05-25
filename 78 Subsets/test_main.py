#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_combine(self):
        sol = main.Solution()

        # ex 1
        nums = [1,2,3]
        expected = [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        self.assertEqual(expected, sol.subsets(nums))

        # ex 2
        nums = [0]
        expected = [[],[0]]
        self.assertEqual(expected, sol.subsets(nums))

        # not in order
        nums = [2, 1]
        expected = [[],[2],[1],[2,1]]
        self.assertEqual(expected, sol.subsets(nums))

        nums = [0]
        expected = [[],[0]]
        self.assertEqual(expected, sol.subsets(nums))

        


if __name__ == '__main__':
    unittest.main()
