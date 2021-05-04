# Uses python3

# LeetCode Problem 53 Maximum Subarray
#
# Description:
# Given an integer array nums, find the contiguous subarray (containing at least one number) 
# which has the largest sum and return its sum.
#
# Result:
# Runtime: 64 ms, faster than 72.48%
# Memory Usage: 14.9 MB, less than 79.28%

from typing import List

class Solution:

    def maxSubArray(self, nums: List[int]) -> int:
        sub = nums[0]
        cur = 0
        for n in nums:
            cur = cur + n
            sub = cur if cur > sub else sub
            cur = cur if cur > 0 else 0
        return sub


def main():
    """starts_here"""
    print("Subarray")
    a = 0
    b = 3
    a = b if b > a else a
    print(a)
    s = Solution()
    print(s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))


if __name__ == '__main__':
    main()