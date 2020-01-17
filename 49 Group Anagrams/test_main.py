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

        max_size = 8
        letter_set = ['e', 'u', 'z']
        n_checks = 1000
        n_words = 30

        test_set = list()

        # build test sets
        for i in range(n_checks):
            this_list = list()
            for j in range(n_words):
                this_size = random.randint(max_size - 2, max_size)
                this_word = ""
                for k in range(this_size):
                    this_word += random.choice(letter_set)
                this_list.append(this_word)
            test_set.append(this_list)

        print("built " + str(len(test_set)) + " sets")
        print("sample: ")
        print(str(test_set[0]))
        print(str(sol.groupAnagrams(test_set[0])))

        for i in range(n_checks):
            self.assertTrue(
                self.check_list_list_anagram(
                    sol.groupAnagrams(test_set[i]), 
                    sol.groupAnagramsNaive(test_set[i])
                )
            )

        print("tested correct")

        print("time test")
        print("new:")
        start = time.time()
        for set_of_words in test_set:
            sol.groupAnagrams(set_of_words)
        end = time.time()
        print(str(end - start))

        print("old:")
        start = time.time()
        for set_of_words in test_set:
            sol.groupAnagrams_old(set_of_words)
        end = time.time()
        print(str(end - start))


    def test_groupAnagramsNaive(self):
        sol = main.Solution()
        in_strings = ["eat", "tea", "tan", "ate", "nat", "bat"]
        expected = [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
        ]
        result = sol.groupAnagramsNaive(in_strings)
        self.assertTrue(self.check_list_list_anagram(expected, result))
    
    def test_groupAnagrams(self):
        sol = main.Solution()

        in_strings = ["eat", "tea", "tan", "ate", "nat", "bat"]
        expected = [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
        ]
        result = sol.groupAnagrams(in_strings)
        self.assertTrue(self.check_list_list_anagram(expected, result))
    

    def test_hash_string(self):
        sol = main.Solution()

        in_string = "a"
        expected = 2
        result = sol.hash_string(in_string)
        self.assertEqual(expected, result)

        in_string = "zzzzz"
        expected = 41115325
        result = sol.hash_string(in_string)
        self.assertEqual(expected, result)


    def test_is_anagram(self):
        sol = main.Solution()

        string1 = "aana"
        string2 = "naaa"
        expected = True
        result = sol.is_anagram(string1, string2)
        self.assertEqual(expected, result)

        string1 = "aanab"
        string2 = "naaa"
        expected = False
        result = sol.is_anagram(string1, string2)
        self.assertEqual(expected, result)

        string1 = ""
        string2 = ""
        expected = True
        result = sol.is_anagram(string1, string2)
        self.assertEqual(expected, result)

        string1 = ""
        string2 = "naaa"
        expected = False
        result = sol.is_anagram(string1, string2)
        self.assertEqual(expected, result)


    def check_list_list_anagram(self, expected, result):
        list_expected = list(expected)
        list_result = list(result)
        if len(list_expected) != len(list_result):
            return False
        for sub_list in list_expected:
            sub_list.sort()
        list_expected.sort()
        for sub_list in list_result:
            sub_list.sort()
        list_result.sort()
        is_equal = list_expected == list_result
        return is_equal
        



if __name__ == '__main__':
    unittest.main()