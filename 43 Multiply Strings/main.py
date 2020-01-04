# Uses python3

# LeetCode Problem 43 - Multiply Strings
# 
# Result:
# Runtime: 
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
    threshold = 10

    def multiply(self, num1: str, num2: str) -> str:
        num1 = self.trim_int_list(self.string_to_int_array(num1))
        num2 = self.trim_int_list(self.string_to_int_array(num2))
        if len(num1) < self.threshold or len(num2) < self.threshold:
            result = self.long_mult(num1, num2)
        else:
            result = self.k_mult(num1, num2)
        return self.int_array_to_string(result)

    def k_mult(self, num1, num2):
        """ 
        karatsuba algorithm
        takes int lists, returns int list
        based on https://en.wikipedia.org/wiki/Karatsuba_algorithm#Pseudocode
        """ 
        min_len = min(len(num1), len(num2))
        if min_len < self.threshold:
            return self.long_mult(num1, num2)
        shift = min_len // 2
        
        high1, low1 = self.split_at_shift(num1, shift)
        high2, low2 = self.split_at_shift(num2, shift)

        # high1 = num1[:div]
        # low1 = num1[div:]
        # high2 = num2[:div]
        # low2 = num2[div:]

        z0 = self.k_mult(low1, low2) 
        low1 = self.add_to(low1, high1, 0) 
        low2 = self.add_to(low2, high2, 0)
        z1 = self.k_mult(low1, low2)
        z2 = self.k_mult(high1, high2)

        result = [0]
        result = self.add_to(result, z2, 2 * shift)
        result = self.add_to(result, z0, 0)
        result = self.add_to(result, z1, shift)
        result = self.sub_from(result, z2, shift)
        result = self.sub_from(result, z0, shift)

        return self.trim_int_list(result)
        

    def split_at_shift(self, num, shift):
        div = len(num) - shift
        high = num[:div]
        low = num[div:]
        return high, low


    def add_to(self, base, to_add, shift): 
        # todo fix bug: can give 10 as first digit
        if len(base) < len(to_add) + 1 + shift:
            result = [0] * (len(to_add) + 1 + shift - len(base)) + base
        else:
            result = [0] + base
        # add all
        for i in range(len(to_add)):
            result[len(result) - 1 - shift - i] += to_add[len(to_add) - 1 - i]
        # do carries
        for i in range(len(result) - 1):
            if result[len(result) - 1 - i] > 9:
                result[len(result) - 1 - i] -= 10
                result[len(result) - 1 - i - 1] += 1
        return self.trim_int_list(result)


    def sub_from(self, base, to_sub, shift):
        # add all
        for i in range(len(to_sub)):
            base[len(base) - 1 - shift - i] -= to_sub[len(to_sub) - 1 - i] # got index out of range error?
        # do carries
        for i in range(len(base) - 1):
            if base[len(base) - 1 - i] < 0:
                base[len(base) - 1 - i] += 10
                base[len(base) - 1 - i - 1] -= 1
        return base
        

    def long_mult(self, num1, num2):
        """
        Take two arrays of integer, return array of integer
        """
        product = [0] * (len(num1) + len(num2))
        carry = 0
        for i in range(len(num1)):
            for j in range(len(num2)):
                prod_index = len(product) - 1 - i - j
                tmp = product[prod_index] + num1[len(num1) - 1 - i] * num2[len(num2) - 1 - j] + carry
                product[prod_index] = tmp % 10
                carry = tmp // 10
            if carry != 0:
                product[len(product) - i - len(num2) - 1] += carry
                carry = 0
        return self.trim_int_list(product)
        
    def string_to_int_array(self, string):
        return [int(i) for i in string]

    
    def int_array_to_string(self, array):
        solution = ""
        for digit in array:
            if digit == 0 and len(solution) == 0:
                continue
            else:
                solution = "".join((solution, str(digit)))

        return solution if len(solution) > 0 else "0"

    
    def trim_int_list(self, num):
        i = 0
        if len(num) < 1:
            return [0]
        elif len(num) == 1:
            return num
        while num[i] == 0 and i < len(num) - 1:
            i += 1
        return num[i:]
        

def main():
    """starts_here"""
    length = 200
    n_numbers = 100
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
    sol_long.threshold = 1000
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