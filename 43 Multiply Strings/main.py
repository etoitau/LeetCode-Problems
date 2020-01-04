# Uses python3

# LeetCode Problem 43 - Multiply Strings
# 
# Result: 88 ms, faster than 55.82% 
# Runtime: 12.7 MB, less than 100.00%
# Memory Usage: 
#
# Description:
# Given two non-negative integers num1 and num2 represented as strings, 
# return the product of num1 and num2, also represented as a string.
# Note:
#
# The length of both num1 and num2 is < 110.
# Both num1 and num2 contain only digits 0-9.
# Both num1 and num2 do not contain any leading zero, except the number 0 itself.
# You must not use any built-in BigInteger library or convert the inputs to integer directly.

import time
import random

class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        """
        karatsuba method turned out to be slower than long multiplication within
        the spec of the problem, so this is the submitted solution with just
        long
        """
        num1 = self.string_to_int_array(num1)
        num2 = self.string_to_int_array(num2)
        return self.int_array_to_string(self.long_mult(num1, num2))
    

    def string_to_int_array(self, string):
        """
        takes string, returns reversed in list of int
        """
        return [int(i) for i in reversed(string)]
    

    def int_array_to_string(self, array):
        """ 
        takes reversed int array
        returns string (with extra zeros trimmed)
        """
        solution = ""
        for digit in reversed(array):
            if digit == 0 and len(solution) == 0:
                continue
            else:
                solution = "".join((solution, str(digit)))

        return solution if len(solution) > 0 else "0"


    def long_mult(self, num1, num2):
        """
        Take two arrays of integer, return array of integer
        """
        product = [0] * (len(num1) + len(num2))
        carry = 0
        for i in range(len(num1)):
            for j in range(len(num2)):
                prod_index = i + j
                tmp = product[prod_index] + num1[i] * num2[j] + carry
                product[prod_index] = tmp % 10
                carry = tmp // 10
            if carry != 0:
                product[i + len(num2)] += carry
                carry = 0
        return product
    
    ###
    # Above was submitted to leetcode, below is a composite solution using 
    # karatsuba for big numbers and long mult for smaller
    ###

    threshold = 200 # below this length, use long mult

    def multiply_comp(self, num1: str, num2: str) -> str:
        num1 = self.string_to_int_array(num1)
        num2 = self.string_to_int_array(num2)
        if len(num1) < self.threshold or len(num2) < self.threshold:
            result = self.long_mult(num1, num2)
        else:
            result = self.k_mult(num1, num2)
        return self.int_array_to_string(result)

    def k_mult(self, num1, num2):
        """ 
        karatsuba algorithm
        takes int lists, returns int list, both backwards
        based on https://en.wikipedia.org/wiki/Karatsuba_algorithm#Pseudocode
        """ 
        min_len = min(len(num1), len(num2))
        if min_len < self.threshold:
            return self.long_mult(num1, num2)
        shift = min_len // 2
        
        high1, low1 = self.split_at_shift(num1, shift)
        high2, low2 = self.split_at_shift(num2, shift)

        z0 = self.k_mult(low1, low2) 
        self.add_to(low1, high1, 0) 
        self.add_to(low2, high2, 0)
        z1 = self.k_mult(low1, low2)
        z2 = self.k_mult(high1, high2)

        result = [0]
        self.add_to(result, z2, 2 * shift)
        self.add_to(result, z0, 0)
        self.add_to(result, z1, shift)
        self.sub_from(result, z2, shift)
        self.sub_from(result, z0, shift)

        return result
        

    def split_at_shift(self, num, shift):
        return num[shift:], num[:shift]


    def add_to(self, base, to_add, shift): 
        """
        adds to_add shifted over shift places into base (in place)
        extends base as needed
        """
        while len(base) - 1 < shift:
            base.append(0)
        # add add_to into base
        carry = 0
        for i in range(len(to_add)):
            if i + shift > len(base) - 1:
                base.append(to_add[i] + carry)
                carry = 0
            else:
                tmp = base[i + shift] + to_add[i] + carry
                base[i + shift] = tmp % 10
                carry = tmp // 10

        # add in last carry
        i = shift + len(to_add)
        if carry != 0:
            if len(base) > i:
                base[i] += carry
                if base[i] < 10:
                    return
            else:
                base.append(carry)
                return
        else:
            return

        # was carry, and ended w/in base, and ended > 9, continue carry as needed
        while base[i] > 9:
            base[i] -= 10
            if len(base) > i + 1:
                base[i + 1] += 1
                i += 1
            else:
                base.append(1)
                return


    def sub_from(self, base, to_sub, shift):
        """ 
        subtract to_sub shifted over shift places from base
        base is assumed > to_sub
        """
        # assumes base > to_sub
        for i in range(len(to_sub)):
            base[shift + i] -= to_sub[i]
            if base[shift + i] < 0:
                base[shift + i] += 10
                base[shift + i + 1] -= 1
        i = len(to_sub) + shift
        # continue carries as needed
        while i < len(base) and base[i] < 0:
            base[i] += 10
            i += 1
            base[i] -= 1
        

    def trim_int_list(self, num):
        """
        trims given list of ints, returns list without leading zeros
        """
        if len(num) < 1:
            return [0]
        elif len(num) == 1:
            return num

        i = len(num) - 1
        while num[i] == 0 and i > 0:
            i -= 1
        return num[:i + 1]
        

def main():
    """benchmarking"""
    length = 1000
    n_numbers = 10
    numbers = list()

    for i in range(n_numbers):
        to_add = list()
        for j in range(length):
            if j == 0:
                to_add.append(random.randint(1, 9))
            else:
                to_add.append(random.randint(0, 9))
        numbers.append(to_add)

    sol_long = Solution()
    sol_long.threshold = 100000
    sol_kara = Solution()
    sol_kara.threshold = 2
    time_long = 0
    time_k = 0
    for i in range(n_numbers):
        for j in range(i, n_numbers):
            start = time.time()
            sol_long.long_mult(numbers[i], numbers[j])
            time_long += time.time() - start
            start = time.time()
            sol_kara.k_mult(numbers[i], numbers[j])
            time_k += time.time() - start
    print("long: " + str(time_long) + ", kara: " + str(time_k))
            
        

if __name__ == '__main__':
    """starts here"""
    main()