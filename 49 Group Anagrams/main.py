# Uses python3

# LeetCode Problem 49 - Group Anagrams
# Comment:
# turns out an optimized version of the naive solution below tests faster, but 
# I've left the below because it's more interesting
# 
# Result:
# Runtime: 108 ms, faster than 41.57%
# Memory Usage: 15.7 MB, less than 92.45%
#
# Description:
# Given an array of strings, group anagrams together.
#
# Note:
# All inputs will be in lowercase.
# The order of your output does not matter


from typing import List
import collections

class Solution:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # hash string with custom hash function which ignores order of characters
        # dict mapping custom hash to list of strings found to match hash
        # return list of values (each a list of strings)
        anagram_dict = collections.defaultdict(list)
        for string in strs:
            anagram_dict[self.hash_string(string)].append(string)
        return anagram_dict.values()


    def hash_string(self, string):
        # map each character in problem space (lowercase a-z) to a prime
        primes = [
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 
            47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        ]
        # some big prime to keep hash from blowing up for very long input
        big_prime = 100663319
        
        # get hash by * mapped primes, should be unique for anagram set
        hashed = 1
        for c in string:
            hashed = hashed * primes[ord(c) - 97] % big_prime
        return hashed


    ############
    # to submit, above
    ############

    def groupAnagrams_alt(self, strs: List[str]) -> List[List[str]]:
        # experiment avoiding dict, very similar runtime, maybe slower
        keys = list()
        values = list()
        for string in strs:
            hashed = self.hash_string(string)
            if hashed in keys:
                values[keys.index(hashed)].append(string)
            else:
                keys.append(hashed)
                values.append([string])
        return values
    

    def groupAnagramsNaive(self, strs):
        result = list()
        found = False
        for string in strs:
            for group in result:
                if self.is_anagram(string, group[0]):
                    group.append(string)
                    found = True
                    break
            if found:
                found = not found
            else:
                result.append([string])
        return result
        

    def is_anagram(self, string1, string2):
        if len(string1) != len(string2):
            return False
        else:
            return sorted(string1) == sorted(string2)



def main():
    """main"""
    
    print("main")
    
            
        

if __name__ == '__main__':
    """starts here"""
    main()