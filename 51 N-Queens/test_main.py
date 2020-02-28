# -*- coding: utf-8 -*-

import main

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_stress(self):
        enabled = False

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

    def test_solveNQueens(self):
        sol = main.Solution()

        n = 0
        expected = []
        result = sol.solveNQueens(n)
        self.assertEqual(expected, result)

        n = 1
        expected = [
            ["Q"]
        ]
        result = sol.solveNQueens(n)
        self.assertEqual(expected, result)

        n = 2
        expected = []
        result = sol.solveNQueens(n)
        self.assertEqual(expected, result)

        n = 3
        expected = []
        result = sol.solveNQueens(n)
        self.assertEqual(expected, result)

        n = 4
        expected = [
            [".Q..",  # Solution 1
             "...Q",
             "Q...",
             "..Q."],

            ["..Q.",  # Solution 2
             "Q...",
             "...Q",
             ".Q.."]
        ]
        result = sol.solveNQueens(n)
        self.assertEqual(expected, result)

        n = 5
        expected = [
            ["...Q.",  # Solution 1
             ".Q...",
             "....Q",
             "..Q..",
             "Q...."],

            [".Q...",  # Solution 2
             "...Q.",
             "Q....",
             "..Q..",
             "....Q"],

            ["Q....",  # Solution 3
             "..Q..",
             "....Q",
             ".Q...",
             "...Q."],

            ["Q....",  # Solution 4
             "...Q.",
             ".Q...",
             "....Q",
             "..Q.."],

            ["....Q",  # Solution 5
             "..Q..",
             "Q....",
             "...Q.",
             ".Q..."],

            ["..Q..",  # Solution 6
             "Q....",
             "...Q.",
             ".Q...",
             "....Q"],

            ["..Q..",  # Solution 7
             "....Q",
             ".Q...",
             "...Q.",
             "Q...."],

            ["....Q",  # Solution 8
             ".Q...",
             "...Q.",
             "Q....",
             "..Q.."],

            [".Q...",  # Solution 9
             "....Q",
             "..Q..",
             "Q....",
             "...Q."],

            ["...Q.",  # Solution 10
             "Q....",
             "..Q..",
             "....Q",
             ".Q..."]
        ]
        expected.sort()
        result = sol.solveNQueens(n)
        result.sort()
        self.assertEqual(expected, result)


    def test_main(self):
        self.assertEqual(2, 1 + 1, "1 + 1 != 2??")


if __name__ == '__main__':
    unittest.main()
