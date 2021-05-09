# Uses python3

# LeetCode Problem 54 Spiral Matrix
#
# Description:
# Given an array of intervals where intervals[i] = [starti, endi], 
# merge all overlapping intervals, and return an array of the non-overlapping 
# intervals that cover all the intervals in the input.
#
# Result:
# Runtime: 124 ms, faster than 5.19%
# Memory Usage: 16.1 MB, less than 82.93%

from typing import List

count = 0

class Solution:

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) < 2:
            return intervals
        intervals.sort(key=lambda l : l[0])
        res = []
        start = intervals[0][0]
        end = intervals[0][1]
        for i in range(1, len(intervals)):
            if intervals[i][0] <= end:
                end = intervals[i][1] if intervals[i][1] > end else end
            else:
                res.append([start, end])
                start = intervals[i][0]
                end = intervals[i][1]
        if not len(res) or end != res[len(res) - 1][1]:
            res.append([start, end])
        return res


def main():
    """starts_here"""
    var = [[2,6],[1,3],[8,10],[15,18]]
    print(var)
    s = Solution()
    print(s.merge(var))


if __name__ == '__main__':
    main()