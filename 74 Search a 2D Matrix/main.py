#!/usr/bin/env python3

# LeetCode Problem 74 Search a 2D Matrix
#
# Result:
# Runtime: 0 ms beats 100%
# Memory Usage: 18.2 MB beats 71.9%

class Solution:

    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        # binary search rows
        low_row = 0
        high_row = len(matrix)
        mid_row = high_row // 2
        while low_row < mid_row and mid_row < high_row:
            if matrix[mid_row][0] > target:
                high_row = mid_row
            else:
                low_row = mid_row
            mid_row = (low_row + high_row) // 2
        if matrix[mid_row][-1] < target:
            return False
        # value is in mid_row, if anywhere
        # binary search columns
        low_col = 0
        high_col = len(matrix[0])
        mid_col = high_col // 2
        while low_col < mid_col and mid_col < high_col:
            if matrix[mid_row][mid_col] > target:
                high_col = mid_col
            else:
                low_col = mid_col
            mid_col = (low_col + high_col) // 2
        return matrix[mid_row][mid_col] == target
    

def main():
    """starts_here"""
    in_array = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    print(Solution().searchMatrix(in_array, 59))
    

if __name__ == '__main__':
    main()