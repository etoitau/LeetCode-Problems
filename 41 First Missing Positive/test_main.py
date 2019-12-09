# -*- coding: utf-8 -*-

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_main(self):
        self.assertEqual(2, 1 + 1, "1 + 1 != 2??")


if __name__ == '__main__':
    unittest.main()