# Uses python3

# LeetCode Problem 59 Spiral Matrix II
#
# Description:
# Given a positive integer n, generate an n x n matrix filled with 
# elements from 1 to n2 in spiral order.
#
# Result:
# Runtime: 32 ms, faster than 61.57%
# Memory Usage: 14.4 MB, less than 45.72%

from typing import List

class Solution:

    def generateMatrix(self, n: int) -> List[List[int]]:
        if n == 1:
            return [[1]]

        matrix = [[0 for i in range(n)] for j in range(n)]

        left = 0
        right = n - 1
        top = 0
        bottom = n - 1
        count = 1
        while left <= right or top <= bottom:
            # right
            for i in range(left, right + 1):
                matrix[top][i] = count
                count += 1
            if top == bottom:
                break
            top += 1
            # down
            for i in range(top, bottom + 1):
                matrix[i][right] = count
                count += 1
            if left == right:
                break
            right -= 1
            # left
            for i in range(right, left - 1, -1):
                matrix[bottom][i] = count
                count += 1
            if top == bottom:
                break
            bottom -= 1
            # up
            for i in range(bottom, top - 1, -1):
                matrix[i][left] = count
                count += 1
            if left == right:
                break
            left += 1
        return matrix


def main():
    """starts_here"""
    var = 3
    print(var)
    s = Solution()
    print(s.generateMatrix(var))


if __name__ == '__main__':
    main()