#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_setZeroes(self):
        sol = main.Solution()

        # ex
        in_array = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        target = 3
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 1
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 7
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 8
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 0
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 60
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 61
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))

        # 1d
        in_array = [[1,3,5,7]]
        target = 15
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 1
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 7
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 5
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 0
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 2
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 8
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))

        # 1d
        in_array = [[1],[3],[5],[7]]
        target = 15
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 1
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 7
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 5
        expected = True
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 0
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 2
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))
        target = 8
        expected = False
        self.assertEqual(expected, sol.searchMatrix(in_array, target))


if __name__ == '__main__':
    unittest.main()
