# Uses python3

# LeetCode Problem 45 - Jump Game II
# 
# Result:  
# Runtime: 
# Memory Usage: 
#
# Description:
# Given an array of non-negative integers, you are initially positioned at the first index of the array.
# Each element in the array represents your maximum jump length at that position.
#
# return the minimum number of jumps to reach the last index.

from typing import List

class Solution:
    def jump(self, nums: List[int]) -> int:
        min_steps = len(nums)
        if min_steps == 1:
            return 0
        if nums[0] >= min_steps - 1:
            return 1

        if nums[0] == 0:
            return None
        
        for i in range(nums[0]):
            tmp_steps = self.jump(nums[i + 1:])
            if not tmp_steps is None and tmp_steps < min_steps:
                min_steps = tmp_steps
        if min_steps == len(nums):
            return None
        return min_steps + 1



def main():
    """main"""
    print("main")
            
        

if __name__ == '__main__':
    """starts here"""
    main()