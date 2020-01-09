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

        # get two lists of positive numbers non-repeating
        source = [i for i in range(200)]

        max_size = 5
        n_checks = 10

        test_set = list()

        # build test sets
        for i in range(n_checks):
            random.shuffle(source)
            this_size = random.randint(0, max_size)
            test_set.append(source[:this_size])

        print("built " + str(len(test_set)) + " sets")
        
        for nums in test_set:
            #print(str(nums))
            result = sol.permute(nums)
            result_cheat = sol.permute_cheat(nums)
            self.assertTrue(self.tool_check_result(nums, result), str(nums))
            self.assertTrue(self.tool_check_result(nums, result_cheat))

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
        self.assertTrue(self.tool_check_result(in_list, result))

        in_list = [48, 177, 98, 159, 136]
        result = sol.permute(in_list)
        self.assertTrue(self.tool_check_result(in_list, result))


    def tool_check_result(self, base, result_to_check):
        
        result_expected = sorted(list(itertools.permutations(base)))

        if (len(result_to_check) != len(result_expected)):
            return False

        result_to_check = sorted(result_to_check)

        for i in range(len(result_expected)):
            if list(result_expected[i]) != result_to_check[i]:
                return False
        return True


        
        



if __name__ == '__main__':
    unittest.main()