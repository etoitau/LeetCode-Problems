#!/usr/bin/env python3

# LeetCode Problem 75 Sort Colors
#
# Result:
# Runtime: 0 ms beats 100%
# Memory Usage: 17.7 mb beats 54%

class Solution:

    def sortColors(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeds = 0
        ones = 0
        for num in nums:
            if num == 0:
                zeds +=1
            elif num == 1:
                ones += 1
        for i in range(zeds):
            nums[i] = 0
        for i in range(zeds, zeds + ones):
            nums[i] = 1
        for i in range(zeds + ones, len(nums)):
            nums[i] = 2

def main():
    """starts_here"""
    in_array = [2,0,2,1,1,0]
    print(Solution().sortColors(in_array))
    

if __name__ == '__main__':
    main()