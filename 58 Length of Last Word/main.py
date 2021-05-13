# Uses python3

# LeetCode Problem 57 Insert Intervals
#
# Description:
# Given a string s consists of some words separated by spaces, return the 
# length of the last word in the string. 
# If the last word does not exist, return 0.
# A word is a maximal substring consisting of non-space characters only
#
# Result:
# Runtime: 16 ms, faster than 99.89%
# Memory Usage: 14.1 MB, less than 87.07%

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if not s:
            return 0
        end = len(s) - 1
        while end > -1 and s[end] == " ":
            end -= 1
        start = end
        while start > -1 and s[start] != " ":
            start -= 1
        return end - start


def main():
    """starts_here"""
    var = "Hello world"
    print(var)
    s = Solution()
    print(s.lengthOfLastWord(var))


if __name__ == '__main__':
    main()