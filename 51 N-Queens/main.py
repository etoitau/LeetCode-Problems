# Uses python3

# LeetCode Problem 51 - N-Queens
#
# Description:
# The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
# Given an integer n, return all distinct solutions to the n-queens puzzle.
#
# Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
# queen and an empty space respectively.
#
#
# Result:
# Runtime: 540 ms, faster than 6.18%
# Memory Usage: 13 MB, less than 100.00%

from typing import List


class Solution:
    rows = list()
    rev_rows = list()

    def solveNQueens(self, n: int) -> List[List[str]]:
        result = list()

        if n < 1:
            return result
        elif n == 1:
            return [["Q"]]

        Solution.rows = [i for i in range(n)]
        Solution.rev_rows = self.rows[::-1]

        for cols in self.col_iterator(n):
            if not cols[0] < cols[-1]:
                continue
            if self.is_valid(cols):
                for board in self.get_boards(cols):
                    result.append(board)

        return result

    @staticmethod
    def print_board(rows: List[int], cols: List[int]):

        n = len(rows)
        board = [['.'] * n for i in range(n)]
        for i in range(n):
            board[rows[i]][cols[i]] = 'Q'
        result = [''.join(str_list) for str_list in board]
        return result

    @staticmethod
    def get_boards(cols: List[int]):
        yield Solution.print_board(Solution.rows, cols)
        yield Solution.print_board(Solution.rev_rows, cols)

    @staticmethod
    def is_valid(cols: List[int]) -> bool:
        # check for diagonal clashes
        for i in range(len(cols) - 1):
            # check each piece for others that clash
            for j in range(i + 1, len(cols)):
                row_offset = j - i
                col_offset = abs(cols[j] - cols[i])
                if row_offset == col_offset:
                    return False
        return True

    @staticmethod
    def col_iterator(n: int) -> List[int]:
        # init
        index = 0
        current = [i for i in range(n)]
        c = [0] * n

        yield current

        while index < n:
            if c[index] < index:
                if index % 2 == 0:
                    current[0], current[index] = current[index], current[0]
                else:
                    current[c[index]], current[index] = current[index], current[c[index]]

                c[index] += 1
                index = 0
                yield current
            else:
                c[index] = 0
                index += 1


def main():
    """starts_here"""
    print("Hello World" + " name")
    n = 4
    board = [['.'] * n for i in range(n)]
    print(board)


if __name__ == '__main__':
    """starts here"""
    main()