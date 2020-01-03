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

class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        threshold = 10
        num1 = self.trim_int_list(self.string_to_int_array(num1))
        num2 = self.trim_int_list(self.string_to_int_array(num2))
        if len(num1) < threshold or len(num2) < threshold:
            result = self.long_mult(num1, num2)
        else:
            result = self.k_mult(num1, num2)
        return self.int_array_to_string(result)


    def add_to(self, base, to_add, shift):
        # add all
        for i in range(len(to_add)):
            base[len(base) - 1 - shift - i] += to_add[len(to_add) - 1 - i]
        # do carries
        for i in range(len(base) - 1):
            if base[len(base) - 1 - i] > 9:
                base[len(base) - 1 - i] -= 10
                base[len(base) - 1 - i - 1] += 1
        

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
        return product
        
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
    sol = Solution()

    print(sol.multiply("10", "5"))

if __name__ == '__main__':
    """starts here"""
    main()