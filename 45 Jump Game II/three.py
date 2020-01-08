# Uses python3

# LeetCode Problem 45 - Jump Game II
# 
# Result:  
# Runtime: 100 ms, faster than 61.61%
# Memory Usage: 14.9 MB, less than 8.33%
#
# Description:
# Given an array of non-negative integers, you are initially positioned at the first index of the array.
# Each element in the array represents your maximum jump length at that position.
#
# return the minimum number of jumps to reach the last index.

from typing import List
from collections import deque

class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        start at end and look for biggest jump that can reach it, then repeat for that point
        keeping track of biggest value below current point can greatly limit that search space
        """

        # trivial cases
        if not nums:
            return 0
        
        length = len(nums)

        if length == 1:
            return 0

        if nums[0] >= length - 1:
            return 1

        # deque of max values that helps us keep track of biggest value remaining
        max_jump = self.build_maxes(nums)

        # start at end point with zero jumps
        jumps = 0
        index = length - 1

        while index > 0:
            # look for points that can reach this index, take biggest jump

            # check trivial case for remaining
            if max_jump[-1] == 1:
                return jumps + index

            # search down from here
            i = index -1
            best = None
            while i > -1 and i >= index - max_jump[-1]:
                # don't need to search deeper than biggest value remaining

                if nums[i] == max_jump[-1]:
                    # if we found current biggest value, remove it from deque
                    max_jump.pop()
                if nums[i] + i >= index:
                    # if this one can reach current position, it's new best option
                    best = i
                i -= 1
            if not best is None:
                # if we found a jump that works, set it as new position and inc jumps
                index = best
                jumps += 1
            else:
                # if game not possible. Spec says this shouldn't happen
                return -1
        
        return jumps


    def build_maxes(self, nums):
        maxes = deque()
        maxes.append(nums[0])
        for i in range(1, len(nums)):
            if nums[i] >= maxes[-1]:
                maxes.append(nums[i])
        return maxes


        




def main():
    """main"""
    print("main")
            
        

if __name__ == '__main__':
    """starts here"""
    main()