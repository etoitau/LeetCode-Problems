#!/usr/bin/env python3

# LeetCode Problem 80 Remove Duplicates from Sorted Array II
#
# Result:
# Runtime: 78 ms beats 89%
# Memory Usage: 20.5 MB beats 21%

class Solution:

    def removeDuplicates(self, nums: list[int]) -> int:
        write_to = 0
        last_num = None
        can_dupe = True
        for i in range(len(nums)):
            if nums[i] == last_num:
                if can_dupe:
                    nums[write_to] = nums[i]
                    write_to += 1
                    can_dupe = False
            else:
                can_dupe = True
                nums[write_to] = nums[i]
                write_to += 1
                last_num = nums[i]
        return write_to
    

def main():
    """starts_here"""
    nums = [1,1,1,2,2,3]
    k = Solution().removeDuplicates(nums)
    print(k)
    print(nums)
    

if __name__ == '__main__':
    main()