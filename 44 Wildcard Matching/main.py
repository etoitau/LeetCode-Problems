# Uses python3

# LeetCode Problem 44 - Wildcard Matching
# 
# Result:  
# Runtime: 1560 ms, faster than 6.30%
# Memory Usage: 20.9 MB, less than 66.67%
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

from queue import LifoQueue

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        """ 
        matching string s to pattern p with wildcards * and ? 
    
        Does a depth-first search with backtracking and memoization
    
        Parameters: 
        s (str): string to match
        p (str): pattern to compare, can have ? indicating any one character 
            and * indicating any number of any character (including none)
    
        Returns: 
        boolean: does pattern match string 
    
        """

        # check trivial cases
        if s is None or len(s) == 0:
            # empty string
            if p is None or len(p) == 0:
                return True
            else:
                for c in p:
                    if c != "*":
                        return False
                return True
        if p is None or len(p) == 0:
            # is string but no pattern
            return False

        if not self.matchChar(s[0], p[0]):
            return False

        # set up search    
        stack = LifoQueue(0)
        index = 0
        s_index = 0
        p_index = 0
        search_size = len(s) * len(p)

        # remember have we checked this point already
        memo = [False] * search_size 

        while True:
            
            # check if been here before
            if memo[index]:
                if stack.empty():
                    return False
                else:
                    index = stack.get()
                    continue

            # note that we've been here
            memo[index] = True

            # if sucessfully reached end, it's a match
            if index == search_size - 1:
                return True

            # set up for checks
            p_index = index // len(s)
            s_index = index % len(s)

            # check for trailing **
            if s_index == len(s) - 1:
                if self.isMatch("", p[p_index + 1:]):
                    return True

            p_char = p[p_index]

            # are the following an option and a match
            can_right = False # next string char and this pattern char
            can_down = False # this string char and next pattern char
            can_diag = False # next string char and next pattern char 

            if p_char == "*":
                can_right = s_index + 1 < len(s) and not memo[index + 1]
                can_down = p_index + 1 < len(p) and not memo[index + len(s)] and self.matchChar(s[s_index], p[p_index + 1])
            # elif p_index + 1 < len(p) and p[p_index + 1] == "*":
            #     can_down = p_index + 1 < len(p) and not memo[index + len(s)] and self.matchChar(s[s_index], p[p_index + 1])
            can_diag = s_index + 1 < len(s) and p_index + 1 < len(p) and not memo[index + len(s) + 1] and self.matchChar(s[s_index + 1], p[p_index + 1])


            # Can we continue?
            if not (can_diag or can_right or can_down):
                # if this path dead end
                if stack.empty():
                    return False
                else:
                    index = stack.get()
                    continue
            
            # determine next move, and put other possibilities in stack for later
            if s_index > p_index:
                # if should go right next
                if can_right:
                    if can_diag:
                        stack.put(index + len(s) + 1)
                    if can_down:
                        stack.put(index + len(s))
                    index += 1
                    continue
                if can_diag:
                    if can_down:
                        stack.put(index + len(s))
                    index = index + len(s) + 1
                    continue
                index += len(s)
            elif s_index < p_index:
                # if should go down next
                if can_down:
                    if can_diag:
                        stack.put(index + len(s) + 1)
                    if can_right:
                        stack.put(index + 1)
                    index += len(s)
                    continue
                if can_diag:
                    if can_right:
                        stack.put(index + 1)
                    index = index + len(s) + 1
                    continue
                index += 1
            else:
                # if should go diag next
                if can_diag:
                    if can_right:
                        stack.put(index + 1)
                    if can_down:
                        stack.put(index + len(s))
                    index = index + len(s) + 1
                    continue
                if can_right:
                    if can_down:
                        stack.put(index + len(s))
                    index += 1
                    continue
                index += len(s)
        # end of isMatch


    def matchChar(self, s_char, p_char):
        if p_char == "*" or p_char == "?":
            return True
        return s_char == p_char



def main():
    """demo"""
    sol = Solution()
    s = "adceb"
    p = "*a*b"
    print(str(sol.isMatch(s, p))) # true

if __name__ == '__main__':
    """starts here"""
    main()