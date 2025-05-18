#!/usr/bin/env python3

# LeetCode Problem 72 Edit Distance
#
# Result:
# Runtime: 44 ms beats 82.8%
# Memory Usage: 19.36 MB beats 89.4%

class Solution:

    def minDistance(self, word1: str, word2: str) -> int:
        result_cache: dict[tuple[int, int], int] = {}
        return self.min_distance(word1, word2, 0, 0, result_cache)
    
    def min_distance(self, word1: str, word2: str, index1: int, index2: int, 
                     result_cache: dict[tuple[int, int], int]) -> int:
        position = (index1, index2)
        if position in result_cache:
            return result_cache[position]
        if index1 > len(word1) - 1:
            result_cache[position] = len(word2) - index2
            return result_cache[position]
        if index2 > len(word2) - 1:
            result_cache[position] = len(word1) - index1
            return result_cache[position]
        char1 = word1[index1]
        char2 = word2[index2]
        if char1 == char2:
            result_cache[position] = self.min_distance(word1, word2, index1 + 1, index2 + 1, result_cache)
            return result_cache[position]
        # try insert
        insert = self.min_distance(word1, word2, index1 + 1, index2, result_cache) + 1
        # try delete
        delete = self.min_distance(word1, word2, index1, index2 + 1, result_cache) + 1
        # try replace
        replace = self.min_distance(word1, word2, index1 + 1, index2 + 1, result_cache) + 1
        result_cache[position] = min(insert, delete, replace)
        return result_cache[position]
    

def main():
    """starts_here"""
    word1 = "a"
    word2 = "aa"
    print(Solution().minDistance(word1, word2))
    


if __name__ == '__main__':
    main()