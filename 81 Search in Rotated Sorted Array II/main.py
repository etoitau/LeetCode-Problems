#!/usr/bin/env python3

# LeetCode Problem 81 Search in Rotated Sorted Array II
#
# Result:
# Runtime: 0 ms beats 100%
# Memory Usage: 18.4 MB beats 10%

from collections import deque

class Solution:

    def find_partition(self, nums: list[int]) -> int:
        ''' Find the index of the "actual" start of the sorted array '''
        # We'd like to do a binary search to find it, but because nums can have 
        # duplicates, sometimes l and r will be equal and we won't know which half
        # to choose - we have to choose both.
        # If we're exploring multiple paths this will be like a DFS or BFS
        # In the case of all duplicates, we have to check everything either way
        # But if it's something like half-duplicates, BFS should give us the ability to 
        # clear all other paths once we find the right one.
        # Note: I actully submitted this twice, with DFS and BFS and the DFS runtime was 
        # 12th percentile and BFS was 100th percentile, so definitely better, at least
        # with their test set.
        stack = deque()
        stack.append((0, len(nums) - 1))
        
        while len(stack):
            l, r = stack.popleft()
            if r - l < 2:
                # End of this path
                if nums[l] > nums[r]:
                    # Found it
                    return r
                # Didn't find it down this path
                continue
            if nums[l] < nums[r]:
                # This part is sorted normally, not here
                continue
            if nums[l] > nums[r]:
                # Haven't found it yet, but the partition is definitely this way, 
                # prune other paths
                stack.clear()
            m = (l + r) // 2
            stack.append((l, m))
            stack.append((m, r))

        # There is no partition
        return 0

    def search(self, nums: list[int], target: int) -> bool:
        if not nums or not len(nums):
            return False
        if len(nums) == 1:
            return nums[0] == target
        part = self.find_partition(nums)
        def val(no_rotation):
            return nums[(no_rotation + part) % len(nums)]
        l = 0
        r = len(nums) - 1
        while (l < r):
            m = (l + r) // 2
            m_val = val(m)
            if m_val == target:
                return True
            if m_val > target:
                r = m - 1
            else:
                l = m + 1
        return val(l) == target
    

def main():
    """starts_here"""
    nums = [1,0,1,1,1]
    k = Solution().search(nums, 0)
    print(k)
    

if __name__ == '__main__':
    main()