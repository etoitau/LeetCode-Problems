# Uses python3

# LeetCode Problem 39 - Combination Sum
#
# Result:
# Runtime: 52 ms, faster than 97.41%
# Memory Usage: 12.6 MB, less than 100.00%
#
# Description:
# Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate 
# numbers sums to target.
#
# The same repeated number may be chosen from candidates unlimited number of times.
#
# Note:
# All numbers (including target) will be positive integers.
# The solution set must not contain duplicate combinations.


from typing import List

class Solution:

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = list()
        so_far = list()
        # if we sort candidates it allows us to be smart about iterating over them
        candidates.sort()
        self.recursive_search(target, candidates, so_far, result, 0)
        return result
    
    def recursive_search(self, target: int, candidates: List[int], so_far: List[int], result: List[List[int]], start_index: int):
        """ recusive function to collect candidates that look like they could work and add the collection to result if they sucessfully get target to 0
        """
        
        for i in range(start_index, len(candidates)):
            # when this is called, possibilities at start of candidates may have been exhausted
            val = candidates[i]
            new_target = target - val
            if new_target < 0:
                # if this candidate is no good, the following ones won't be either because it's sorted, we're done with this path
                return
            elif new_target > 0:
                # this candidate works, add it to the colleciton and pass on
                new_so_far = so_far.copy()
                new_so_far.append(val)
                # note next recursion doens't need to consider candidates left of i, those have already been exhausted
                self.recursive_search(new_target, candidates, new_so_far, result, i)
            else:
                # an exact match, add to list we'll return to user
                so_far.append(val)
                result.append(so_far)
                # any further candidates will result in new_target < 0, so end loop here
                return
