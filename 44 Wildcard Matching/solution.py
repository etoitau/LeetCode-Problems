# Uses python3

# LeetCode Problem 44 - Wildcard Matching - Take 2
# 
# Result:  
# Runtime: 40 ms, faster than 97.79%
# Memory Usage: 12.8 MB, less than 100.00%
#
# Description:
# Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
#
# '?' Matches any single character.
# '*' Matches any sequence of characters (including the empty sequence).
# The matching should cover the entire input string (not partial).
#
# Note:
# s could be empty and contains only lowercase letters a-z.
# p could be empty and contains only lowercase letters a-z, and characters like ? or *.


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        """ 
        matching string s to pattern p with wildcards * and ? 
    
        Parameters: 
        s (str): string to match
        p (str): pattern to compare, can have ? indicating any one character 
            and * indicating any number of any character (including none)
    
        Returns: 
        boolean: does pattern match string 
    
        """

        # check trivial cases
        if not p:
            return not s

        s_length = len(s)
        s_index = 0
        p_length = len(p)
        p_index = 0
        star_p_index = -1
        star_s_index = -1

        while s_index < s_length:

            if not p_index < p_length:
                # if p out of bounds, backtrack if possible
                if star_p_index != -1:
                    p_index = star_p_index
                    star_s_index += 1
                    s_index = star_s_index
                    continue
                else:
                    return False

            if p[p_index] in [s[s_index], '?']:
                # if direct or ? match, both inc
                s_index += 1
                p_index += 1
            elif p[p_index] == "*":
                # if star match, note state for backtracking and inc p
                star_p_index = p_index
                star_s_index = s_index
                p_index += 1
            elif star_p_index != -1:
                # if no match, but backtrack point set, go back and inc s
                p_index = star_p_index
                star_s_index += 1
                s_index = star_s_index
            else:
                return False
                
        for p_char in p[p_index:]:
            # if out of string, but more pattern left, they'd better all be *
            if p_char != "*":
                return False 

        return True
        



def main():
    """demo"""
    sol = Solution()
    s = "adceb"
    p = "*a*b"
    print(str(sol.isMatch(s, p))) # true

if __name__ == '__main__':
    """starts here"""
    main()