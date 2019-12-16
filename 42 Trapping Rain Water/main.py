# Uses python3

# LeetCode Problem 42 - Trapping Rain Water
# 
# Result:
# Runtime: 60 ms, faster than 58.17%
# Memory Usage: 14.4 MB, less than 6.98%
#
# Description:
# Given n non-negative integers representing an elevation map where the width 
# of each bar is 1, compute how much water it is able to trap after raining.


from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 3: return 0

        # make a list of tuples (original index, value)
        topo = list()
        for i in range(len(height)):
            topo.append( (i, height[i]) )
        # sort by value, values are still mapped to original index via tuple
        topo.sort(key=lambda tup: tup[1])

        if topo[-1][1] == 0: return 0
        
        # init list of water heights
        water = [0] * len(topo)

        # mark the highest peak
        left = right = topo[-1][0]
        # water will fill the space between the highest and second-highest 
        # peaks to the height of the second highest
        # then same with second and third IF third is not between first and second
        for i in range(len(topo) - 2, -1, -1):
            x, h = topo[i]
            if x < left:
                self.fill(water, x, left, h)
                left = x
            elif x > right:
                self.fill(water, right, x, h)
                right = x
        
        # return sum of water less the ammount displaced by land
        return self.count(water, height)
        
    # fill water array between (not including) left and right
    def fill(self, water: List[int], left: int, right: int, height: int):
        if right - left < 2:
            return
        for i in range(left + 1, right):
            water[i] = height

    # sum net ammount of water
    def count(self, water: List[int], height: List[int]):
        total = 0
        for i in range(len(water)):
            if water[i] > 0:
                total += water[i] - height[i]
        return total
