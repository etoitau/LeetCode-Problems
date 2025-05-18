# Uses python3

# LeetCode Problem 71 Simplify Path
#
# Result:
# Runtime: 1 ms, faster than 70.7%
# Memory Usage: 12.45 MB, less than 74.33%

import math

class Solution:

    def simplify_path(self, in_path: str):
        in_parts = in_path.split("/")
        in_parts.reverse()
        out_parts = []
        to_skip = 0
        for in_part in in_parts:
            if in_part == "" or in_part == ".":
                continue
            if in_part == "..":
                to_skip += 1
                continue
            if to_skip > 0:
                to_skip -= 1
                continue
            out_parts.append(in_part)
        out_parts.reverse()
        return "/" + "/".join(out_parts)
    

def main():
    """starts_here"""
    var = "/test//path//../../../...."
    print(Solution().simplify_path(var))
    


if __name__ == '__main__':
    main()