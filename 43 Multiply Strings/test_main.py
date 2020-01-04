# -*- coding: utf-8 -*-

import main

import unittest
import random


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

    def test_stress(self):
        enabled = True

        if not enabled:
            return

        # get two lists of string numbers
        max_len = 20
        n_numbers = 100
        numbers = list()

        for i in range(n_numbers):
            to_add = list()
            length = random.randint(0, max_len)
            for j in range(length):
                if j == 0:
                    to_add.append(random.randint(1, 9))
                else:
                    to_add.append(random.randint(0, 9))
            numbers.append(to_add)

        sol_long = main.Solution()
        sol_long.threshold = 1000
        sol_kara = main.Solution()
        sol_kara.threshold = 2

        for i in range(n_numbers):
            for j in range(i, n_numbers):
                self.assertEqual( sol_long.long_mult(numbers[i], numbers[j]), 
                                  sol_kara.k_mult(numbers[i], numbers[j]),
                                  str(numbers[i]) + ", " + str(numbers[j]) )
        



    def test_split_at_shift(self):
        sol = main.Solution()

        num = [1, 2, 3]
        shift = 1
        high_expected = [1, 2]
        low_expected = [3]
        high_result, low_result = sol.split_at_shift(num, shift)
        self.assertEqual(high_expected, high_result)
        self.assertEqual(low_expected, low_result)

        num = [1, 2, 3]
        shift = 2
        high_expected = [1]
        low_expected = [2, 3]
        high_result, low_result = sol.split_at_shift(num, shift)
        self.assertEqual(high_expected, high_result)
        self.assertEqual(low_expected, low_result)

    def test_add_to(self):
        sol = main.Solution()

        base = list([1, 0, 0])
        to_add = [5]
        shift = 1
        expected = list([1, 5, 0])
        result = sol.add_to(base, to_add, shift)
        self.assertEqual(expected, result)

        base = list([1, 9, 9])
        to_add = [2]
        shift = 0
        expected = list([2, 0, 1])
        result = sol.add_to(base, to_add, shift)
        self.assertEqual(expected, result)

        base = list([1, 2, 3, 4])
        to_add = [3, 2]
        shift = 1
        expected = list([1, 5, 5, 4])
        result = sol.add_to(base, to_add, shift)
        self.assertEqual(expected, result)


    def test_multiply(self):
        sol = main.Solution()

        num1 = "10"
        num2 = "5"
        expected = "50"
        result = sol.multiply(num1, num2)
        self.assertEqual(expected, result)

        num1 = "123"
        num2 = "456"
        expected = "56088"
        result = sol.multiply(num1, num2)
        self.assertEqual(expected, result)

        num1 = "0"
        num2 = "456"
        expected = "0"
        result = sol.multiply(num1, num2)
        self.assertEqual(expected, result)

        num1 = "4568"
        num2 = "456"
        expected = "2083008"
        result = sol.multiply(num1, num2)
        self.assertEqual(expected, result)

        num1 = "1000"
        num2 = "102"
        expected = "102000"
        result = sol.multiply(num1, num2)
        self.assertEqual(expected, result)


    def test_k_mult(self):
        sol = main.Solution()
        sol.threshold = 2 # take all the way down to single digit

        num1 = [4, 7, 5, 4] 
        num2 = [2, 1, 0, 4, 8, 0, 1, 5, 8, 3, 2, 5, 3, 3, 0, 3, 4, 6, 5, 7]
        expected = [1, 0, 0, 0, 6, 2, 2, 6, 7, 2, 6, 7, 8, 6, 2, 0, 4, 6, 7, 5, 9, 3, 7, 8]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

        num1 = [1, 0]
        num2 = [5]
        expected = [5, 0]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

        num1 = [0]
        num2 = [4, 5, 6]
        expected = [0]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

        num1 = [1, 2]
        num2 = [1, 0]
        expected = [1, 2, 0]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

        num1 = [1, 2, 3]
        num2 = [4, 5, 6]
        expected = [5, 6, 0, 8, 8]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

        num1 = [4, 5, 6, 8]
        num2 = [4, 5, 6]
        expected = [2, 0, 8, 3, 0, 0, 8]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

        num1 = [1, 0, 0, 0]
        num2 = [1, 0, 2]
        expected = [1, 0, 2, 0, 0, 0]
        result = sol.k_mult(num1, num2)
        self.assertEqual(expected, result)

    
    def test_string_to_int_array(self):
        sol = main.Solution()

        string_num = "123"
        expected = list((1, 2, 3))
        result = sol.string_to_int_array(string_num)
        self.assertEqual(expected, result)


    def test_int_array_to_string(self):
        sol = main.Solution()

        array = list([0, 0, 1, 3])
        expected = "13"
        result = sol.int_array_to_string(array)
        self.assertEqual(expected, result)

        array = list([0])
        expected = "0"
        result = sol.int_array_to_string(array)
        self.assertEqual(expected, result)

        array = list([3])
        expected = "3"
        result = sol.int_array_to_string(array)
        self.assertEqual(expected, result)

        array = list([1, 0, 1, 3])
        expected = "1013"
        result = sol.int_array_to_string(array)
        self.assertEqual(expected, result)


    def test_long_mult(self):
        sol = main.Solution()
        sol.threshold = 200

        num1 = list((1, 2, 3))
        num2 = list((3, 5)) 
        expected = list((4, 3, 0, 5))
        result = sol.long_mult(num1, num2)
        self.assertEqual(expected, result)


    def test_trim_int_list(self):
        sol = main.Solution()

        num = list((0, 0, 1, 8, 9))
        expected = list((1, 8, 9))
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list((0, 1, 8, 9, 0))
        expected = list((1, 8, 9, 0))
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list((1, 8, 9))
        expected = list((1, 8, 9))
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list((1, 0, 8, 9, 0))
        expected = list((1, 0, 8, 9, 0))
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = [0]
        expected = [0]
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list()
        expected = [0]
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)


    
         


if __name__ == '__main__':
    unittest.main()