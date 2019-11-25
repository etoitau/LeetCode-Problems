# -*- coding: utf-8 -*-

import main

import unittest
from typing import List


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_solution(self):
        sol = main.Solution()
        candidates = list()
        expected = list()
        result = list()
        target = 0

        candidates = list([10, 1, 2, 7, 6, 1, 5])
        target = 8
        expected = list([
            list([1, 7]), 
            list([1, 2, 5]),
            list([2, 6]),
            list([1, 1, 6]),
            ])
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

        candidates = list([2, 5, 2, 1, 2])
        target = 5
        expected = list([
            list([1, 2, 2]), 
            list([5])
            ])
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

        candidates = list([2, 3, 5])
        target = 1
        expected = list()
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

        candidates = list([2, 3, 5])
        target = 3
        expected = list([
            list([3]), 
            ])
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

        candidates = list([2, 3, 5])
        target = 11
        expected = list()
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

        candidates = list([2, 3, 5])
        target = 4
        expected = list()
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

        candidates = list([2, 2, 2, 2])
        target = 6
        expected = list([
            list([2, 2, 2])
            ])
        result = sol.combinationSum(candidates, target)
        self.assertTrue(list_compare_no_order(expected, result))

def list_compare_no_order(list1: List[List[int]], list2: List[List[int]]):
    if len(list1) != len(list2):
        return False
    for list_to_find in list1:
        found = False
        for maybe_this in list2:
            if list_to_find == maybe_this:
                found = True
                break
        if not found:
            return False
    return True


if __name__ == '__main__':
    unittest.main()