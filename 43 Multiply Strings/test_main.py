# -*- coding: utf-8 -*-

import main

import unittest


class BasicTestSuite(unittest.TestCase):
    """Basic test cases."""

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


    def test_add_to(self):
        sol = main.Solution()

        base = list([1, 0, 0])
        to_add = [5]
        shift = 1
        expected = list([1, 5, 0])
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = list([1, 9, 9])
        to_add = [2]
        shift = 0
        expected = list([2, 0, 1])
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)

        base = list([1, 2, 3, 4])
        to_add = [3, 2]
        shift = 1
        expected = list([1, 5, 5, 4])
        sol.add_to(base, to_add, shift)
        self.assertEqual(expected, base)


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

        num1 = list((1, 2, 3))
        num2 = list((3, 5)) 
        expected = list((0, 4, 3, 0, 5))
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