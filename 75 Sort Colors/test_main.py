#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_sortColors(self):
        sol = main.Solution()

        # ex 1
        in_array = [2,0,2,1,1,0]
        expected = [0,0,1,1,2,2]
        sol.sortColors(in_array)
        self.assertEqual(expected, in_array)

        # ex 2
        in_array = [2,0,1]
        expected = [0,1,2]
        sol.sortColors(in_array)
        self.assertEqual(expected, in_array)

        # all 1
        in_array = [1,1,1,1,1,1]
        expected = [1,1,1,1,1,1]
        sol.sortColors(in_array)
        self.assertEqual(expected, in_array)

        # all 2
        in_array = [2,2]
        expected = [2,2]
        sol.sortColors(in_array)
        self.assertEqual(expected, in_array)

        # missing 1
        in_array = [2,0]
        expected = [0,2]
        sol.sortColors(in_array)
        self.assertEqual(expected, in_array)
        


if __name__ == '__main__':
    unittest.main()
