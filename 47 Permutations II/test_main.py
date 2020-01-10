# -*- coding: utf-8 -*-

import unittest
import itertools
import random
import time
import main

class BasicTestSuite(unittest.TestCase):

    def test_stress(self):
        enabled = True

        if not enabled:
            return

        sol = main.Solution()

        max_size = 8
        n_checks = 100
        max_val = 200

        test_set = list()

        # build test sets
        for i in range(n_checks):
            this_size = random.randint(0, max_size)
            this_list = list()
            for j in range(this_size):
                this_list.append(random.randint(0, 200))
            test_set.append(this_list)

        print("built " + str(len(test_set)) + " sets")
        
        for nums in test_set:
            #print(str(nums))
            result = sol.permute(nums)
            result_cheat = sol.permute_cheat(nums)
            self.assertTrue(self.tool_check_result(result_cheat, result), str(nums))

        print("tested correct")

        print("time test")
        print("mine")
        start = time.time()
        for nums in test_set:
            sol.permute(nums)
        end = time.time()
        print(str(end - start))

        print("python's:")
        start = time.time()
        for nums in test_set:
            sol.permute_cheat(nums)
        end = time.time()
        print(str(end - start))

        

    def test_permute(self):
        sol = main.Solution()

        in_list = [1, 2, 3]
        expected = [
            [1, 2, 3],
            [1, 3, 2],
            [2, 1, 3],
            [2, 3, 1],
            [3, 1, 2],
            [3, 2, 1]
        ]
        result = sol.permute(in_list)
        self.assertTrue(self.tool_check_result(sol.permute_cheat(in_list), result))

        in_list = [48, 177, 98, 159, 136]
        result = sol.permute(in_list)
        self.assertTrue(self.tool_check_result(sol.permute_cheat(in_list), result))

        in_list = [1, 1, 2]
        result = sol.permute(in_list)
        self.assertTrue(self.tool_check_result(sol.permute_cheat(in_list), result))

        in_list = [1, 1]
        result = sol.permute(in_list)
        self.assertTrue(self.tool_check_result(sol.permute_cheat(in_list), result))


    def test_permute_cheat(self):
        sol = main.Solution()
        in_list = [1, 1, 2]
        expected = [
            [1, 1, 2],
            [1, 2, 1],
            [2, 1, 1]
        ]
        result = sol.permute_cheat(in_list)
        self.assertEqual(expected, sorted(result))


    def tool_check_result(self, expected, result):
        if (len(expected) != len(result)): return False

        expected = sorted(expected)
        result = sorted(result)

        for i in range(len(expected)):
            if list(expected[i]) != result[i]:
                return False
        return True


        
        



if __name__ == '__main__':
    unittest.main()