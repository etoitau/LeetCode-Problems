# -*- coding: utf-8 -*-

import main

import unittest

class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_solution(self):
        sol = main.Solution()
        heights = list()
        expected = 6
        result = expected

        # example 1
        heights = [0,1,0,2,1,0,1,3,2,1,2,1]
        expected = 6
        result = sol.trap(heights)
        self.assertEqual(expected, result)

        # plataeu
        heights = [0,0,2,2,2,2,2,0,0,0]
        expected = 0
        result = sol.trap(heights)
        self.assertEqual(expected, result)

        # peak at end
        heights = [10,0,2,2,2,2,2,0,0,0]
        expected = 2
        result = sol.trap(heights)
        self.assertEqual(expected, result)

        # peak at end
        heights = [0,0,2,2,2,2,2,0,0,10]
        expected = 4
        result = sol.trap(heights)
        self.assertEqual(expected, result)

        # empty
        heights = []
        expected = 0
        result = sol.trap(heights)
        self.assertEqual(expected, result)

        



if __name__ == '__main__':
    unittest.main()