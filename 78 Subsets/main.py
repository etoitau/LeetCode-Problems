#!/usr/bin/env python3

# LeetCode Problem 78 Subsets
#
# Result:
# Runtime: 3 ms beats 10%
# Memory Usage: 18 MB beats 21.5%

import math

class Solution:

    def subsets(self, nums: list[int]) -> list[list[int]]:
        # How many results will there be
        n = int(math.pow(2, len(nums)))
        out = []
        # Find each result
        for m in range(n):
            sub = []
            # Interpret m as a bit mask where each bit corresponds with an index of numbs
            # and a 1 means we should include that num in the subset
            # e.g. for the sixth element the mask is 110 so we should include the second 
            # and third num
            bit = 1
            for i in range(len(nums)):
                if (m & bit):
                    sub.append(nums[i])
                bit *= 2
            out.append(sub)
        return out


def main():
    """starts_here"""
    n = [1, 2, 3]
    print(Solution().subsets(n))
    

if __name__ == '__main__':
    main()