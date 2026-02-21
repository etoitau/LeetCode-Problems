#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):

    def test_delete_duplicates(self):
        sol = main.Solution()

        nums = [1,2,3,3,4,4,5]
        expected = [1,2,5]
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = [1,1,1,2,3]
        expected = [2, 3]
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = [1,1,1,2,2]
        expected = []
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = []
        expected = []
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = [1, 5, 9]
        expected = [1, 5, 9]
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = [1, 1, 1]
        expected = []
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = [0, 0, 0, 0, 0]
        expected = []
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)

        nums = [1, 2, 2]
        expected = [1]
        result = main.fromLinkedList(sol.deleteDuplicates(main.toLinkedList(nums)))
        self.assertListEqual(result, expected)


        
        


if __name__ == '__main__':
    unittest.main()
