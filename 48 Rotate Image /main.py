# Uses python3

# LeetCode Problem 48 - Rotate Image
# 
# Result:
# Runtime: 32 ms, faster than 71.95%
# Memory Usage: 12.7 MB, less than 100.00%

# Description:
# You are given an n x n 2D matrix representing an image.
# Rotate the image by 90 degrees (clockwise).
# Note:
# You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
# DO NOT allocate another 2D matrix and do the rotation.


from typing import List

import copy

class Solution:
    
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        if not matrix or not matrix[0]: return
        
        self.matrix = matrix
        self.size = len(matrix)

        # take each element in the top left quarter and swap it around with the other three in that relative position
        for i in range(self.size // 2):
            for j in range((self.size + 1) // 2):
                self.rotate_four(i, j)


    def rotate_four(self, row, col):
        # hold starting point value in storage bc we'll overwrite it in place
        tmp = self.matrix[row][col]

        from_row, from_col = row, col

        # three times we want to get the value that should end up in this position
        # put it in this position
        # set this position to the one we just got from
        for i in range(3):
            to_row, to_col = from_row, from_col
            from_row, from_col = self.size - 1 - to_col, to_row
            self.matrix[to_row][to_col] = self.matrix[from_row][from_col]
        
        # finish by putting the starting value in the 4th position
        self.matrix[col][self.size - 1 - row] = tmp
        

    def naive_rotate(self, matrix):
        # doesn't work in place, so violates spec
        # just used to test against
        if not matrix or not matrix[0]: return

        size = len(matrix)
        
        working_copy = copy.deepcopy(matrix)

        for row in range(size):
            for col in range(size):
                working_copy[col][size - 1 - row] = matrix[row][col]
        
        for row in range(size):
            for col in range(size):
                matrix[row][col] = working_copy[row][col]



def main():
    """main"""
    
    print("main")
    
            
        

if __name__ == '__main__':
    """starts here"""
    main()