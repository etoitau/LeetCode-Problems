# -*- coding: utf-8 -*-

import main

import unittest

class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_solution(self):
        sol = main.Solution()
        nums = list()
        expected = len(nums)
        result = expected

        # example 1
        nums = list([1, 2, 0])
        expected = 3
        result = sol.firstMissingPositive(nums)
        self.assertEqual(expected, result)

        # example 2
        nums = list([3, 4, -1, 1])
        expected = 2
        result = sol.firstMissingPositive(nums)
        self.assertEqual(expected, result)

        # example 3
        nums = list([7, 8, 9, 11, 12])
        expected = 1
        result = sol.firstMissingPositive(nums)
        self.assertEqual(expected, result)

        # all neg
        nums = list([-4, -8, -1, 0])
        expected = 1
        result = sol.firstMissingPositive(nums)
        self.assertEqual(expected, result)

        # repeats
        nums = list([1, 1, 1, 1])
        expected = 2
        result = sol.firstMissingPositive(nums)
        self.assertEqual(expected, result)

        # repeats
        nums = list([1, 1, 2, 1, 4])
        expected = 3
        result = sol.firstMissingPositive(nums)
        self.assertEqual(expected, result)



if __name__ == '__main__':
    unittest.main()