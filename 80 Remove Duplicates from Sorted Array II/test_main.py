#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_removeDuplicates(self):
        sol = main.Solution()

        # ex 1
        nums = [1,1,1,2,2,3]
        expn = [1,1,2,2,3,3]
        expk = 5
        gotk = sol.removeDuplicates(nums)
        self.assertEqual(expn, nums)
        self.assertEqual(expk, gotk)

        # ex 2
        nums = [0,0,1,1,1,1,2,3,3]
        expn = [0,0,1,1,2,3,3,3,3]
        expk = 7
        gotk = sol.removeDuplicates(nums)
        self.assertEqual(expn, nums)
        self.assertEqual(expk, gotk)

        # all dupes
        nums = [0,0,0,0]
        expn = [0,0,0,0]
        expk = 2
        gotk = sol.removeDuplicates(nums)
        self.assertEqual(expn, nums)
        self.assertEqual(expk, gotk)

        # no dupes
        nums = [1,3,5,7]
        expn = [1,3,5,7]
        expk = 4
        gotk = sol.removeDuplicates(nums)
        self.assertEqual(expn, nums)
        self.assertEqual(expk, gotk)
        


if __name__ == '__main__':
    unittest.main()
