#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):

    def test_largest_rectangle_area(self):
        sol = main.Solution()

        nums = [2,1,5,6,2,3]
        expected = 10
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [2,4]
        expected = 4
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [2]
        expected = 2
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [2,2]
        expected = 4
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [4,2,1]
        expected = 4
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [2,0]
        expected = 2
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [0,2]
        expected = 2
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [0, 0]
        expected = 0
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [0]
        expected = 0
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)

        nums = [2, 1, 2]
        expected = 3
        result = sol.largestRectangleArea(nums)
        self.assertEqual(result, expected)


        
        


if __name__ == '__main__':
    unittest.main()
