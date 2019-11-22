# -*- coding: utf-8 -*-

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_solution(self):
        sol = main.Solution()
        candidates = list()
        expected = list()
        result = list()
        target = 0

        candidates = list([6, 3, 2, 7])
        target = 7
        expected = list([
            list([2, 2, 3]), 
            list([7])
            ])
        result = sol.combinationSum(candidates, target)
        self.assertEqual(expected, result)

        candidates = list([2, 3, 5])
        target = 8
        expected = list([
            list([2, 2, 2, 2]), 
            list([2, 3, 3]),
            list([3, 5])
            ])
        result = sol.combinationSum(candidates, target)
        self.assertEqual(expected, result)

        candidates = list([2, 3, 5])
        target = 1
        expected = list()
        result = sol.combinationSum(candidates, target)
        self.assertEqual(expected, result)

        candidates = list([2, 3, 5])
        target = 3
        expected = list([
            list([3]), 
            ])
        result = sol.combinationSum(candidates, target)
        self.assertEqual(expected, result)


if __name__ == '__main__':
    unittest.main()