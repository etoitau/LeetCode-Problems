# Uses python3

# LeetCode Problem 57 Insert Intervals
#
# Description:
# Given a set of non-overlapping intervals, insert a new interval into the 
# intervals (merge if necessary).
# You may assume that the intervals were initially sorted according to their 
# start times.
#
# Result:
# Runtime: 76 ms, faster than 84.94%
# Memory Usage: 17.6 MB, less than 29.08%

from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: 
        List[int]) -> List[List[int]]:

        if not len(intervals):
            return [newInterval]

        start_val = newInterval[0]
        end_val = newInterval[1]
        # find index of start interval
        start_index = self.bs(intervals, newInterval[0], 0, len(intervals))
        # interval at start_index has start >= newInterval start
        
        if start_index > 0 and intervals[start_index - 1][1] >= newInterval[0]:
            # interval before startindex laps with new
            start_val = intervals[start_index - 1][0]
            start_index -= 1
        elif start_index == len(intervals):
            intervals.append(newInterval)
            return intervals
        elif newInterval[1] < intervals[start_index][0]:
            # Doesn't lap, insert and return 
            intervals.insert(start_index, newInterval)
            return intervals
        # else laps with value at start_index, nothing to do

        end_index = self.bs(intervals, newInterval[1], start_index, len(intervals))
        if end_index == len(intervals):
            # if end of new is after start of last in intervals
            end_val = max(newInterval[1], intervals[end_index - 1][1])
        elif newInterval[1] >= intervals[end_index][0]:
            # does lap with interval at end_index
            end_val = max(newInterval[1], intervals[end_index][1])
            end_index += 1
        else:
            end_val = max(newInterval[1], intervals[end_index - 1][1])
        intervals[start_index:end_index] = [[start_val, end_val]]
        return intervals
        
        
    def comp(self, interval, value):
        if interval[0] <= value and interval[1] >= value:
            return 0
        elif interval[0] > value:
            return -1
        return 1

    # Returns index where val is found, or where it would be inserted
    def bs(self, arr: List[List[int]], val: int, start_index, end_index):
        if start_index == end_index:
            return start_index
        m = (start_index + end_index) // 2
        comp = val - arr[m][0]
        if comp < 0:
            return self.bs(arr, val, start_index, m)
        elif comp > 0:
            return self.bs(arr, val, m + 1, end_index)
        else:
            return m


def main():
    """starts_here"""
    var = [[2,6],[8,10],[15,18]]
    print(var)
    s = Solution()
    print(s.bs(var, 8, 0, len(var)))
    var[2:2] = [[0, 0]]
    print(var)


if __name__ == '__main__':
    main()