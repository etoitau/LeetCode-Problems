# Uses python3

# LeetCode Problem 46 - Permutations
# 
# Result for permute_cheat:  
# Runtime: 28 ms, faster than 99.15%
# Memory Usage: 12.8 MB, less than 100.00%
#
# Result for permute
# Runtime: 36 ms, faster than 81.84%
# Memory Usage: 12.8 MB, less than 100.00%
#
# Description:
# Given a collection of distinct integers, return all possible permutations.

from typing import List
import math
import itertools

class Solution:
    length = 0

    def permute(self, nums: List[int]) -> List[List[int]]:

        perms = [nums]

        # handle trivial cases
        if not nums or len(nums) < 2: 
            return perms
        elif len(nums) == 2:
            working = list(nums)
            working[0], working[1] = working[1], working[0]
            perms.append(working)
            return perms

        self.length = len(nums)

        # calc size of result
        size = math.factorial(self.length)
  

        for i in range(1, size):
            nums = self.next_permutation(nums)
            perms.append(nums)
        
        return perms

        
        
    def next_permutation(self, nums):
        # gives next permutation in a sorted series of permutations

        # make copy
        working = list(nums)

        # permute
        # eg [1, 2, 4, 3]
        for i in range(self.length - 2, -1, -1):
            # scan right to left 
            if working[i] < working[i + 1]: 
                # until find one that is less than one to right
                # eg the 2 is less than the 4 
                for j in range(self.length - 1, i, -1):
                    # scan right to left until i  
                    if working[j] > working[i]:
                        # find the first one from right that is larger, to swap
                        # e.g. swap 2 with 3 to get [1, 3, 4, 2]
                        working[i], working[j] = working[j], working[i]
                        # sort portion to right
                        # e.g. [1, 3, 2, 4]
                        working[i + 1:] = sorted(working[i + 1:])
                        return working
        # if totally reverse sorted, start over with sorted
        working = sorted(working)

        return working

    def permute_cheat(self, nums):
        return [list(result) for result in itertools.permutations(nums)]



def main():
    """main"""
    
    print("main")
    
            
        

if __name__ == '__main__':
    """starts here"""
    main()