#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):

    def test_find_partition(self):
        sol = main.Solution()

        nums = [1,2,3,4]
        expected = 0
        result = sol.find_partition(nums)
        self.assertEqual(result, expected)

        nums = [4,1,2,3,4]
        expected = 1
        result = sol.find_partition(nums)
        self.assertEqual(result, expected)

        nums = [1,1,1,1]
        expected = 0
        result = sol.find_partition(nums)
        self.assertEqual(result, expected)

        nums = [1,1,0,1,1,1]
        expected = 2
        result = sol.find_partition(nums)
        self.assertEqual(result, expected)

        nums = [4,4,4,1,1,1]
        expected = 3
        result = sol.find_partition(nums)
        self.assertEqual(result, expected)

    def test_search(self):
        sol = main.Solution()

        # ex 1
        nums = [2,5,6,0,0,1,2]
        target = 0
        expected = True
        result = sol.search(nums, target)
        self.assertEqual(result, expected)

        # ex 2
        nums = [2,5,6,0,0,1,2]
        target = 3
        expected = False
        result = sol.search(nums, target)
        self.assertEqual(result, expected)

        # all dupes
        nums = [5,5,5,5,5]
        target = 6
        expected = False
        result = sol.search(nums, target)
        self.assertEqual(result, expected)

        # all dupes
        nums = [5,5,5,5,5]
        target = 4
        expected = False
        result = sol.search(nums, target)
        self.assertEqual(result, expected)

        # all dupes
        nums = [5,5,5,5,5]
        target = 5
        expected = True
        result = sol.search(nums, target)
        self.assertEqual(result, expected)

        # target and partition to left left
        nums = [6,7,0,0,1,1,1,2,2,2,3,3,4]
        target = 7
        expected = True
        result = sol.search(nums, target)
        self.assertEqual(result, expected)

        # target and partition to left left
        nums = [1,0,1,1,1]
        target = 0
        expected = True
        result = sol.search(nums, target)
        self.assertEqual(result, expected)
        


if __name__ == '__main__':
    unittest.main()
