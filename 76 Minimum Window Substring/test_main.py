#!/usr/bin/env python3

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_sortColors(self):
        sol = main.Solution()

        # ex 1
        s = "ADOBECODEBANC"
        t = "ABC"
        expected = "BANC"
        self.assertEqual(expected, sol.minWindow(s, t))

        # ex 2
        s = "a"
        t = "a"
        expected = "a"
        self.assertEqual(expected, sol.minWindow(s, t))

        # ex 3
        s = "a"
        t = "aa"
        expected = ""
        self.assertEqual(expected, sol.minWindow(s, t))

        


if __name__ == '__main__':
    unittest.main()
