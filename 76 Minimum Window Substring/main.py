#!/usr/bin/env python3

# LeetCode Problem 75 Sort Colors
#
# Result:
# Runtime: 69 ms beats 70%
# Memory Usage: 18.2 MB beats 55%

from collections import defaultdict
from math import inf

class Solution:

    class StringStat:
        """ Keeps a count of the number of each character added and removed
        from it. 
        Characters not in the initializing string are ignored.
        Maintains a net positive count wich is the sum of all positive 
        character counts.
        """
        def __init__(self, chars: str = ""):
            self.counts = defaultdict(int)
            self.pos_size = len(chars)
            for c in chars:
                self.counts[c] += 1

        def add(self, c: str):
            if c not in self.counts:
                return
            self.counts[c] += 1
            if self.counts[c] > 0:
                self.pos_size += 1

        def rem(self, c: str):
            if c not in self.counts:
                return
            self.counts[c] -= 1
            if self.counts[c] >= 0:
                self.pos_size -= 1


    def minWindow(self, s: str, t: str) -> str:
        min_str_start = 0
        min_str_end = inf
        goal = Solution.StringStat(t)
        start = 0
        end = 0
        while True:
            new_solution = False
            while end < len(s) and goal.pos_size > 0:
                # Advance end of the window until it includes all characters
                goal.rem(s[end])
                end += 1
            
            new_solution = goal.pos_size == 0

            while goal.pos_size == 0:
                # If we have a solution, advance start of the window until it 
                # breaks the solution
                goal.add(s[start])
                start += 1
            
            if new_solution:
                new_solution = False
                if min_str_end - min_str_start > end - start:
                    min_str_start = start - 1
                    min_str_end = end

            if end == len(s):
                break
            
        if min_str_end <= len(s):
            return s[min_str_start:min_str_end]
        return ""

def main():
    """starts_here"""
    s = "ADOBECODEBANC"
    t = "ABC"
    print(Solution().minWindow(s, t))
    

if __name__ == '__main__':
    main()