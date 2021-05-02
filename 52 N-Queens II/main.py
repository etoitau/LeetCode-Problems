# Uses python3

# LeetCode Problem 52 - N-Queens 2
#
# Description:
# The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
# Given an integer n, return the number of distinct solutions to the n-queens puzzle.
#
# Result:
# Runtime: 68 ms, faster than 49.17%
# Memory Usage: 14.5 MB, less than 14.18%

class Solution:
    def __init__(self):
        # Keep a log of whether there is a queen in each row, col, and diagonal
        self.rows = []
        self.cols = []
        self.fdia = []
        self.bdia = []
        self.n = 0

    def totalNQueens(self, n: int) -> int:
        # Catch trivial cases
        if n in [0, 2, 3]:
            return 0
        elif n == 1:
            return 1
        self.n = n
        # Max square index, we use the idea that each square is indexed from 0 and 
        # numbered left to right, top to bottom, even though we don't keep such an array in memory
        self.n2 = n * n
        self.rows = [False] * n
        self.cols = [False] * n
        nDia = 2 * n - 1
        self.fdia = [False] * nDia
        self.bdia = [False] * nDia
        count = 0
        for col in range(n):
            # For each column of the first row, depth first search for solutions
            self.add_queen(col)
            count += self.recur(n - 1, n)
            self.remove_queen(col)
        return count


    def recur(self, left, start):
        if left > self.n - start // self.n:
            # If there are more queens left than rows
            return 0
        count = 0
        for i in range(start, start + self.n):
            # For each square index of this row, try to place a queen
            if self.add_queen(i):
                if left == 1:
                    count += 1
                else:
                    count += self.recur(left - 1, start + self.n)
                # Clean up this queen before trying the next square    
                self.remove_queen(i)
        return count


    def add_queen(self, i):
        # Convert square index into row, col, and diagonal indexes and check if we 
        # already have a queen in that row, col, or diag
        # If not, add it
        c = i % self.n
        if self.cols[c]:
            return False
        r = i // self.n
        if self.rows[r]:
            return False
        fd = self.n - 1 + c - r
        if self.fdia[fd]:
            return False
        bd = r + c
        if self.bdia[bd]:
            return False
        self.cols[c] = True
        self.rows[r] = True
        self.fdia[fd] = True
        self.bdia[bd] = True
        return True


    def remove_queen(self, i):
        # Remove a queen from the board and clean up the rows, cold, diags it had claimed
        c = i % self.n
        r = i // self.n
        self.cols[c] = False
        self.rows[r] = False
        self.fdia[self.n - 1 + c - r] = False
        self.bdia[r + c] = False


def main():
    """starts_here"""
    print("N Queens 2")


if __name__ == '__main__':
    main()