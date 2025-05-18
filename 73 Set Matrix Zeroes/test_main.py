# -*- coding: utf-8 -*-

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_setZeroes(self):
        sol = main.Solution()

        # ex 1
        in_array = [[1,1,1],[1,0,1],[1,1,1]]
        expected = [[1,0,1],[0,0,0],[1,0,1]]
        sol.setZeroes(in_array)
        self.assertEqual(expected, in_array)

        # ex 2
        in_array = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        expected = [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        sol.setZeroes(in_array)
        self.assertEqual(expected, in_array)

        # 1 dim
        in_array = [[0,1,2,0]]
        expected = [[0,0,0,0]]
        sol.setZeroes(in_array)
        self.assertEqual(expected, in_array)

        # 1 dim
        in_array = [[1],[2],[3],[0]]
        expected = [[0],[0],[0],[0]]
        sol.setZeroes(in_array)
        self.assertEqual(expected, in_array)


if __name__ == '__main__':
    unittest.main()
