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
        """
        start cur_index at end point and work toward beginning
        for each cur_index all points before it that can reach it, 
        for each of those points, store the steps to get from cur_index to end + 1 in memo
        when whole string has been scanned, result will be stored in memo[0]
        """

        # trivial cases
        if not nums:
            return 0
        
        length = len(nums)

        if length == 1:
            return 0

        if nums[0] >= length - 1:
            return 1

        # init memo
        memo = [length] * length
        memo[length - 1] = 0
        
        for cur_index in range(length - 1, -1, -1):
            # start at end and work toward beginning
            for i in range(cur_index):
                # check all before cur_index
                if nums[i] + i >= cur_index:
                    # if it can get to cur_index
                    if memo[i] > memo[cur_index] + 1:
                        # and it's faster than whatever is there now, store as new best
                        memo[i] = memo[cur_index] + 1

        return memo[0]
    


def main():
    """main"""
    print("main")
            
        

if __name__ == '__main__':
    """starts here"""
    main()