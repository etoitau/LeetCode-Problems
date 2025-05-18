# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_simplify_path(self):
        sol = main.Solution()

        # ex 1
        input_path = "/home/"
        expected = "/home"
        result = sol.simplify_path(input_path)
        self.assertEqual(expected, result)

        # ex 2
        input_path = "/home//foo/"
        expected = "/home/foo"
        result = sol.simplify_path(input_path)
        self.assertEqual(expected, result)

        # ex 3
        input_path = "/home/user/Documents/../Pictures"
        expected = "/home/user/Pictures"
        result = sol.simplify_path(input_path)
        self.assertEqual(expected, result)

        # ex 4
        input_path = "/../"
        expected = "/"
        result = sol.simplify_path(input_path)
        self.assertEqual(expected, result)

        # ex 5
        input_path = "/.../a/../b/c/../d/./"
        expected = "/.../b/d"
        result = sol.simplify_path(input_path)
        self.assertEqual(expected, result)

        # consecutive up directory
        input_path = "/a/b/c/../../"
        expected = "/a"
        result = sol.simplify_path(input_path)
        self.assertEqual(expected, result)



if __name__ == '__main__':
    unittest.main()
