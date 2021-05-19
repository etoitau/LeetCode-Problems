# Uses python3

# LeetCode Problem 60 Permutation Sequence
#
# Description:
# The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
# By listing and labeling all of the permutations in order, 
# we get the following sequence for n = 3:
# "123"
# "132"
# "213"
# "231"
# "312"
# "321"
# Given n and k, return the kth permutation sequence.
#
# Result:
# Runtime: 32 ms, faster than 65.94%
# Memory Usage: 14.2 MB, less than 85.37%

import math

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        used = set()
        result = ""
        for d in range(n):
            next = self.getDigit(n, k - 1, d, used)
            result = result + str(next)
            used.add(next)

        return result

    def getDigit(self, n, k, d, used):
        # k and d counting from 0
        # eligable digits
        digits = [i for i in range(1, n + 1) if i not in used ]
        # how many permutations a digit remains unchanged
        cycle_speed = self.factorial(n - d - 1)
        # how many times has the digit changed
        cycle_number = k // cycle_speed
        # what will be digit position in digits
        cycle_pos = cycle_number % len(digits)
        digit = digits[cycle_pos]
        return digit

    def factorial(self, n):
        if n < 0:
            return 1
        factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]
        return factorials[n]


def main():
    """starts_here"""
    var = "Hello world"
    print(var)
    s = Solution()
    n = 4
    for k in range(1, s.factorial(n) + 1):
        print(s.getPermutation(n, k))


if __name__ == '__main__':
    main()