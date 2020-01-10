# Uses python3

# LeetCode Problem 47 - Permutations II
# 
# Result permute:
# Runtime: 60 ms, faster than 46.86%
# Memory Usage: 12.7 MB, less than 100.00%
#
# Result permute_cheat:
# Runtime: 76 ms, faster than 34.47%
# Memory Usage: 12.9 MB, less than 100.00%
#
# Description:
# Given a collection of numbers that might contain duplicates, return all possible unique permutations.

from typing import List
import math
import itertools

class Solution:
    length = 0

    def permute(self, nums: List[int]) -> List[List[int]]:
        self.length = len(nums)

        perms = [nums]

        # handle trivial cases
        if not nums or len(nums) < 2: 
            return perms
        elif len(nums) == 2:
            if nums[0] == nums[1]:
                return perms
            working = list(nums)
            working[0], working[1] = working[1], working[0]
            perms.append(working)
            return perms

        while True:
            nums = self.next_permutation(nums)
            if nums == perms[0]:
                return perms
            perms.append(nums)
        

        
        
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
        set_result = set()
        for result in itertools.permutations(nums):
            set_result.add(result)
        return [list(i) for i in set_result]



def main():
    """main"""
    
    print("main")
    
            
        

if __name__ == '__main__':
    """starts here"""
    main()