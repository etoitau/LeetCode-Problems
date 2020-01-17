# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_stress(self):
        enabled = True

        if not enabled:
            return

        sol = main.Solution()

        min_x = -100
        max_x = 100
        min_n = pow(-2, 31)
        max_n = pow(2, 31) - 1
        n_checks = 10000

        test_set = list()

        # build test sets
        for i in range(n_checks):
            x = random.random() * (max_n - min_n) + min_n
            n = random.randint(min_n, max_n)
            test_set.append((x, n))

        print("built " + str(len(test_set)) + " sets")

        for i in range(n_checks):
            r1 = sol.myPow(test_set[i][0], test_set[i][1])
            r2 = sol.built_in_pow(test_set[i][0], test_set[i][1])
            if r2:
                self.assertAlmostEqual(r1, r2)

        print("tested correct")

        print("time test")
        print("mine:")
        start = time.time()
        for pair in test_set:
            sol.myPow(pair[0], pair[1])
        end = time.time()
        print(str(end - start))

        print("built in:")
        start = time.time()
        for pair in test_set:
            sol.built_in_pow(pair[0], pair[1])
        end = time.time()
        print(str(end - start))

    def test_naive_pow(self):
        sol = main.Solution()

        x = 2
        n = 10
        expected = 1024
        result = sol.naive_pow(x, n)
        self.assertAlmostEqual(expected, result)

        x = 2.1
        n = 3
        expected = 9.261
        result = sol.naive_pow(x, n)
        self.assertAlmostEqual(expected, result)

        x = 2
        n = -2
        expected = 0.25
        result = sol.naive_pow(x, n)
        self.assertAlmostEqual(expected, result)

    def test_myPow(self):
        sol = main.Solution()

        x = 2
        n = 10
        expected = 1024
        result = sol.myPow(x, n)
        self.assertAlmostEqual(expected, result)

        x = 2.1
        n = 3
        expected = 9.261
        result = sol.myPow(x, n)
        self.assertAlmostEqual(expected, result)

        x = 2
        n = -2
        expected = 0.25
        result = sol.myPow(x, n)
        self.assertAlmostEqual(expected, result)

    def test_main(self):
        self.assertEqual(2, 1 + 1, "1 + 1 != 2??")


if __name__ == '__main__':
    unittest.main()