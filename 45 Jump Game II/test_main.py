# -*- coding: utf-8 -*-

import one, two, three

import unittest
import random
import time


class BasicTestSuite(unittest.TestCase):

    def test_stress(self):
        enabled = True

        if not enabled:
            return

        # get two lists of positive numbers
        n_lists = 200
        max_size = 20

        test_set = list()

        for i in range(n_lists):
            to_add = list()
            size = random.randint(1, max_size)
            for j in range(size):
                to_add.append(random.randint(0, size))
            test_set.append(to_add)
        
        sol_one = one.Solution()
        sol_two = two.Solution()
        sol_three = three.Solution()

        for nums in test_set:
            #print(str(nums))
            result_one = sol_one.jump(nums)
            result_two = sol_two.jump(nums)
            result_three = sol_three.jump(nums)

            if (result_one is None and result_two == len(nums)):
                # agree it's invalid, ok
                self.assertTrue(True)
            else:
                self.assertEqual(result_one, result_two, str(nums))
                self.assertEqual(result_two, result_three, str(nums))

        print("jump one:")
        start = time.time()
        for nums in test_set:
            sol_one.jump(nums)
        end = time.time()
        print(str(end - start))

        print("jump_two:")
        start = time.time()
        for nums in test_set:
            sol_two.jump(nums)
        end = time.time()
        print(str(end - start))

        print("jump_three:")
        start = time.time()
        for nums in test_set:
            sol_three.jump(nums)
        end = time.time()
        print(str(end - start))

    
        

    def test_jump(self):
        solutions = [three.Solution(), two.Solution(), one.Solution()]
        for i in range(len(solutions)):
            sol = solutions[i]

            in_list = [2, 3, 1, 1, 4]
            expected = 2
            result = sol.jump(in_list)
            self.assertEqual(expected, result)

            in_list = [2, 3, 1]
            expected = 1
            result = sol.jump(in_list)
            self.assertEqual(expected, result)

            in_list = [2]
            expected = 0
            result = sol.jump(in_list)
            self.assertEqual(expected, result)

            in_list = [1, 1, 1, 1]
            expected = 3
            result = sol.jump(in_list)
            self.assertEqual(expected, result)

            in_list = [2, 3, 0, 1, 4]
            expected = 2
            result = sol.jump(in_list)
            self.assertEqual(expected, result)

            in_list = [13, 0, 8, 3, 19, 5, 8, 6, 7, 14, 2, 19, 18, 0, 12, 0, 13, 15, 16]
            expected = 2
            result = sol.jump(in_list)
            self.assertEqual(expected, result)

            print(str(i) + " ok")

    def test_build_maxes(self):
        sol = three.Solution()

        in_list = [2, 3, 0, 1, 4]
        expected = [2, 3, 4]
        result = sol.build_maxes(in_list)
        self.assertEqual(len(expected), len(result))
        for i in range(len(expected)):
            self.assertEqual(expected[i], result[i])

        in_list = [1, 1, 1]
        expected = [1, 1, 1]
        result = sol.build_maxes(in_list)
        self.assertEqual(len(expected), len(result))
        for i in range(len(expected)):
            self.assertEqual(expected[i], result[i])
        



if __name__ == '__main__':
    unittest.main()