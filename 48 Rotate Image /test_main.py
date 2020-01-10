# -*- coding: utf-8 -*-

import unittest
import itertools
import random
import time
import main
import copy

class BasicTestSuite(unittest.TestCase):

    def test_stress(self):
        enabled = True

        if not enabled:
            return

        sol = main.Solution()

        max_size = 10
        n_checks = 10000
        max_val = 200

        test_set = list()

        # build test sets
        for i in range(n_checks):
            this_size = random.randint(0, max_size)
            this_array = list()
            for j in range(this_size):
                this_row = list()
                for k in range(this_size):
                    this_row.append(random.randint(0, max_val))
                this_array.append(this_row)
            test_set.append(this_array)

        print("built " + str(len(test_set)) + " sets")
        
        copy_set = copy.deepcopy(test_set)
        # copy_two = copy.deepcopy(test_set)

        for i in range(n_checks):
            sol.rotate(test_set[i])
            sol.naive_rotate(copy_set[i])
            
            self.assertEqual(test_set[i], copy_set[i])

        print("tested correct")

        print("time test")
        print("mine:")
        start = time.time()
        for matrix in test_set:
            sol.rotate(matrix)
        end = time.time()
        print(str(end - start))

        print("naive:")
        start = time.time()
        for matrix in test_set:
            sol.naive_rotate(matrix)
        end = time.time()
        print(str(end - start))


    def test_rotate(self):
        sol = main.Solution()

        in_matrix = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]
        expected = [
            [7, 4, 1],
            [8, 5, 2],
            [9, 6, 3]
        ]
        sol.rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        in_matrix = [
            [1, 2, 3, 7],
            [4, 5, 6, 7],
            [7, 8, 9, 7],
            [10, 11, 12, 7]
        ]
        expected = [
            [10, 7, 4, 1],
            [11, 8, 5, 2],
            [12, 9, 6, 3],
            [7, 7, 7, 7]
        ]
        sol.rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        in_matrix = [
            [1]
        ]
        expected = [
            [1]
        ]
        sol.rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        in_matrix = [
            []
        ]
        expected = [
            []
        ]
        sol.rotate(in_matrix)
        self.assertEqual(in_matrix, expected)


    def test_naive_rotate(self):
        sol = main.Solution()

        in_matrix = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]
        expected = [
            [7, 4, 1],
            [8, 5, 2],
            [9, 6, 3]
        ]
        sol.naive_rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        in_matrix = [
            [1, 2, 3, 7],
            [4, 5, 6, 7],
            [7, 8, 9, 7],
            [10, 11, 12, 7]
        ]
        expected = [
            [10, 7, 4, 1],
            [11, 8, 5, 2],
            [12, 9, 6, 3],
            [7, 7, 7, 7]
        ]
        sol.naive_rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        in_matrix = [
            [1]
        ]
        expected = [
            [1]
        ]
        sol.naive_rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        in_matrix = [
            []
        ]
        expected = [
            []
        ]
        sol.naive_rotate(in_matrix)
        self.assertEqual(in_matrix, expected)

        


    

        
        



if __name__ == '__main__':
    unittest.main()