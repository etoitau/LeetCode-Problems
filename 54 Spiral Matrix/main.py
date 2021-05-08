# Uses python3

# LeetCode Problem 54 Spiral Matrix
#
# Description:
# Given an m x n matrix, return all elements of the matrix in spiral order.
#
# Result:
# Runtime: 28 ms, faster than 81.28%
# Memory Usage: 14.3 MB, less than 59.78%

from typing import List

class Solution:

    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if len(matrix) == 1:
            return matrix[0]
        left = 0
        right = len(matrix[0]) - 1
        top = 0
        bottom = len(matrix) - 1
        result = []
        while left <= right or top <= bottom:
            # right
            for i in range(left, right + 1):
                result.append(matrix[top][i])
            if top == bottom:
                break
            top += 1
            # down
            for i in range(top, bottom + 1):
                result.append(matrix[i][right])
            if left == right:
                break
            right -= 1
            # left
            for i in range(right, left - 1, -1):
                result.append(matrix[bottom][i])
            if top == bottom:
                break
            bottom -= 1
            # up
            for i in range(bottom, top - 1, -1):
                result.append(matrix[i][left])
            if left == right:
                break
            left += 1
        return result


def main():
    """starts_here"""
    var = [[1,2,3],[4,5,6],[7,8,9]]
    print(var)
    s = Solution()
    print(s.spiralOrder(var))


if __name__ == '__main__':
    main()