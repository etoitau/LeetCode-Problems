# Uses python3

# LeetCode Problem 54 Spiral Matrix
#
# Description:
# Given an array of non-negative integers nums, you are initially positioned at 
# the first index of the array.
# Each element in the array represents your maximum jump length at that position.
# Determine if you are able to reach the last index.
#
# Result:
# Runtime: 88 ms, faster than 59.09%
# Memory Usage: 16.1 MB, less than 50.80%

from typing import List

count = 0

class Solution:

    def canJump(self, nums: List[int]) -> bool:
        t = len(nums) - 1
        if t == 0 or nums[0] >= t:
            return True
        elif nums[0] == 0:
            return False
        reach_from = t
        for i in range(t, -1, -1):
            if i + nums[i] >= reach_from:
                reach_from = i
        return reach_from == 0

    # Works, but slow for a case like [3, 2, 1, 0, 0]
    def canJump_dfs(self, nums: List[int]) -> bool:
        return self.search(0, nums, len(nums) - 1, set())

    def search(self, n, a, target, seen):
        global count
        count += 1
        print(count)
        if n + a[n] >= target:
            return True
        if n in seen:
            return False
        for i in range(n + a[n], n, -1):
            if self.search(i, a, target, seen):
                return True
        seen.add(n)
        return False


def main():
    """starts_here"""
    var = [7,6,5,4,3,2,1,1,0,0]
    print(var)
    s = Solution()
    print(s.canJump(var))


if __name__ == '__main__':
    main()