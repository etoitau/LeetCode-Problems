#!/usr/bin/env python3

# LeetCode Problem 77 Combinations
#
# Result:
# Runtime: 144 ms beats 37%
# Memory Usage: 71.7 MB beats 5%


class Solution:

    def combine(self, n: int, k: int) -> list[list[int]]:
        done: dict[tuple[int, int, int], list[list[int]]] = dict()
        result = self.helper(1, n, k, done)
        return result
    
    def helper(self, m, n, k, done: dict[tuple[int, int, int], list[list[int]]]) -> list[list[int]]:
        key = (m, n, k)
        if key in done:
            # already have a result for this case
            return done[(m, n, k)]
        if k < 1:
            # trivial pick none
            return [[]]
        if n + 1 - m == k:
            # trivial pick all
            return [[i for i in range(m, n + 1)]]
        result = []
        # Get all cases where we pick m
        sub_result = self.helper(m + 1, n, k - 1, done)
        for sub in sub_result:
            result.append([m] + sub)
        # Get all cases where we don't pick m
        sub_result = self.helper(m + 1, n, k, done)
        for sub in sub_result:
            if len(sub):
                result.append(sub)
        # cache the result
        done[key] = result
        return result


def main():
    """starts_here"""
    n = 4
    k = 2
    print(Solution().combine(n, k))
    

if __name__ == '__main__':
    main()