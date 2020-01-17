# Uses python3

# LeetCode Problem 50 - Pow(x, n)
#
# Description:
# Implement pow(x, n), which calculates x raised to the power n (xn)
#
# Note:
# -100.0 < x < 100.0
# n is a 32-bit signed integer, within the range [−231, 231 − 1]
#
# Result:
# Runtime: 24 ms, faster than 87.17%
# Memory Usage: 12.6 MB, less than 100.00%


class Solution:
    def myPow(self, x: float, n: int) -> float:
        # if negative power, need to work with inverse
        if n < 0:
            x = 1 / x
            n *= -1
        elif n == 0:
            return 1
        elif n == 1:
            return x

        # exponentiation by squaring
        result = 1
        while n:
            if n & 1:
                # if n is odd
                result *= x
            # next bit of n (divide n by 2)
            n >>= 1
            # square base x
            x *= x
        return result

    def naive_pow(self, x, n):
        if n < 0:
            x = 1 / x
            n *= -1
        r = 1
        for i in range(n):
            r *= x
        return r

    def built_in_pow(self, x, n):
        try:
            result = pow(x, n)
        except OverflowError:
            return None


def main():
    """starts_here"""
    print("Hello World")


if __name__ == '__main__':
    """starts here"""
    main()