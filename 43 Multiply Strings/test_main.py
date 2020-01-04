# -*- coding: utf-8 -*-

import main

import unittest
import random


class BasicTestSuite(unittest.TestCase):

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
                self.assertEqual( 
                    sol_long.int_array_to_string(sol_long.long_mult(numbers[i], numbers[j])), 
                    sol_kara.int_array_to_string(sol_kara.k_mult(numbers[i], numbers[j])),
                    str(numbers[i]) + ", " + str(numbers[j]) 
                )
        

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

        num1 = [0, 1]
        num2 = [5]
        expected = [0, 5]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [0]
        num2 = [4, 5, 6]
        expected = [0]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [1, 2]
        num2 = [0, 1]
        expected = [0, 1, 2]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [1, 2, 3]
        num2 = [4, 5, 6]
        expected = [4, 3, 9, 9, 0, 2]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [0, 0, 0, 1]
        num2 = [1, 0, 2]
        expected = [0, 0, 0, 1, 0, 2]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [9, 6, 8]
        num2 = [9, 6]
        expected = [1, 6, 9, 9, 5]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [4, 5, 6, 8]
        num2 = [4, 5, 6]
        expected = [6, 1, 7, 9, 5, 6, 5]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)

        num1 = [4, 5, 7, 4]
        num2 = [7, 5, 6, 4, 3, 0, 3, 3, 5, 2, 3, 8, 5, 1, 0, 8, 4, 0, 1, 2]
        expected = [8, 7, 3, 9, 5, 7, 6, 4, 0, 2, 6, 8, 7, 6, 2, 7, 6, 2, 2, 6, 0, 0, 0, 1]
        result = sol.trim_int_list(sol.k_mult(num1, num2))
        self.assertEqual(expected, result)


    def test_split_at_shift(self):
        sol = main.Solution()

        num = [1, 2, 3]
        shift = 1
        high_expected = [2, 3]
        low_expected = [1]
        high_result, low_result = sol.split_at_shift(num, shift)
        self.assertEqual(high_expected, high_result)
        self.assertEqual(low_expected, low_result)

        num = [1, 2, 3]
        shift = 2
        high_expected = [3]
        low_expected = [1, 2]
        high_result, low_result = sol.split_at_shift(num, shift)
        self.assertEqual(high_expected, high_result)
        self.assertEqual(low_expected, low_result)


    def test_add_to(self):
        sol = main.Solution()

        base = [9]
        to_add = [6, 8]
        shift = 0
        expected = [5, 9]
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = [1, 0, 0]
        to_add = [5]
        shift = 1
        expected = [1, 5, 0]
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = [1, 9, 9]
        to_add = [2]
        shift = 0
        expected = [3, 9, 9]
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = [1, 2, 3, 4]
        to_add = [3, 2]
        shift = 1
        expected = [1, 5, 5, 4]
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = [1, 2]
        to_add = [3, 2]
        shift = 1
        expected = [1, 5, 2]
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = [9, 9, 9, 9]
        to_add = [1]
        shift = 1
        expected = [9, 0, 0, 0, 1]
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

    
    def test_sub_from(self):
        sol = main.Solution()
        base = [1, 7, 7, 0, 6]
        to_sub = [1, 8]
        shift = 1
        expected = [1, 6, 9, 9, 5]
        sol.sub_from(base, to_sub, shift)
        self.assertEqual(expected, base)


    def test_long_mult(self):
        sol = main.Solution()
        sol.threshold = 200

        num1 = list((1, 2, 3))
        num2 = list((3, 5)) 
        expected = list((3, 1, 0, 7, 1))
        result = sol.long_mult(num1, num2)
        self.assertEqual(expected, result)


    def test_string_to_int_array(self):
        sol = main.Solution()

        string_num = "123"
        expected = list((3, 2, 1))
        result = sol.string_to_int_array(string_num)
        self.assertEqual(expected, result)


    def test_int_array_to_string(self):
        sol = main.Solution()

        array = list([3, 1, 0, 0])
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
        expected = "3101"
        result = sol.int_array_to_string(array)
        self.assertEqual(expected, result)


    def test_trim_int_list(self):
        sol = main.Solution()

        num = [9, 8, 1, 0, 0]
        expected = [9, 8, 1]
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list((0, 1, 8, 9, 0))
        expected = list((0, 1, 8, 9))
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list((1, 8, 9))
        expected = list((1, 8, 9))
        result = sol.trim_int_list(num)
        self.assertEqual(expected, result)

        num = list((1, 0, 8, 9, 0))
        expected = list((1, 0, 8, 9))
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