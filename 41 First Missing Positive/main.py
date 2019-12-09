# Uses python3

# LeetCode Problem 41 - First Missing Positive
# 
# Result:
# Runtime: 32 ms, faster than 93.10%
# Memory Usage: 12.7 MB, less than 100.00%
#
# Description:
# Given an unsorted integer array, find the smallest missing positive integer.


from typing import List

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        return Solution.specialSort(nums) + 1

    @staticmethod
    def specialSort(nums: List[int]) -> int:
        cursor = 0
        endEx = len(nums)
        while cursor < endEx:
            if nums[cursor] == cursor + 1:
                # if already correct value here, consider next
                cursor += 1
            elif nums[cursor] < 1 or nums[cursor] > endEx or nums[nums[cursor] - 1] == nums[cursor]:
                # if this value is negative or too big, or a repeat, banish to end and forget
                nums[cursor], nums[endEx - 1] = nums[endEx - 1], nums[cursor]
                endEx -= 1
            else:
                # swap this value into the spot where it belongs
                nums[nums[cursor] - 1], nums[cursor] = nums[cursor], nums[nums[cursor] - 1]
        # let user know where valid numbers end        
        return endEx
