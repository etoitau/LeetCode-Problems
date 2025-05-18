#!/usr/bin/env python3

# LeetCode Problem 73 Set Matrix Zeroes
#
# Result:
# Runtime: 3 ms beats 73%
# Memory Usage: 18.3 MB beats 78%

class Solution:

    def setZeroes(self, matrix: list[list[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row_zero = [False for _ in matrix]
        col_zero = [False for _ in matrix[0]]

        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0:
                    col_zero[col] = True
                    row_zero[row] = True

        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if row_zero[row] or col_zero[col]:
                    matrix[row][col] = 0
        return
    

def main():
    """starts_here"""
    in_array = [[1,1,1],[1,0,1],[1,1,1]]
    Solution().setZeroes(in_array)
    print(in_array)
    

if __name__ == '__main__':
    main()