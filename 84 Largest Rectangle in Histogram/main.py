#!/usr/bin/env python3

# LeetCode Problem 84 Largest Rectangle in Histogram
#
# Result:
# Runtime: 5301 ms beats 5%
# Memory Usage: 36 MB beats 26%

from typing import List, Self, Optional

class Solution:

    class Node:
        ''' Nodes represent rectangles next to each other in a linked list '''
        
        def __init__(self, h: int, w: int, prev: Optional[Self], next: Optional[Self]) -> None:
            self.h = h
            self.w = w
            self.prev = prev
            self.next = next
        
        @property
        def area(self):
            return self.h * self.w
        
        @classmethod
        def from_list(cls, heights: List[int]):
            ''' Convert a list of rectangles of width one to a linked list of Nodes '''
            if not len(heights):
                return None
            head = cls(heights[0], 1, None, None)
            prev = head
            for i in range(1, len(heights)):
                if heights[i] == prev.h:
                    prev.w += 1
                    continue
                prev.next = cls(heights[i], 1, prev, None)
                prev = prev.next
            return head
        
        def merge_next(self):
            ''' Merge the next node into this one '''
            if not self.next:
                return
            self.h = min(self.h, self.next.h)
            self.w += self.next.w
            self.next = self.next.next
            if self.next:
                self.next.prev = self

        def merge_prev(self):
            ''' Merge this node into the previous '''
            if not self.prev:
                return
            self.prev.h = min(self.h, self.prev.h)
            self.prev.w += self.w
            self.prev.next = self.next
            if self.prev.next:
                self.prev.next.prev = self.prev

        def try_flatten(self):
            ''' If this is a peak, combine it with the tallest neighbor and 
            report the larger area between this Node and the resulting one 
            '''
            if self.prev and self.prev.h > self.h:
                # Shorter than prev, not a peak
                return None
            if self.next and self.next.h > self.h:
                # Shorter than next, not a peak
                return None
            # Area before merge
            area = self.area
            if self.prev and (not self.next or self.prev.h > self.next.h):
                # If prev is the highest neighbor
                self.merge_prev()
                return max(area, self.prev.area)
            if self.next:
                # if next is the highest neighbor
                self.merge_next()
                return max(area, self.area)
        

    def largestRectangleArea(self, heights: List[int]) -> int:
        head = Solution.Node.from_list(heights)
        if not head:
            return 0
        largest_area = head.area
        l = len(heights)
        while l > 1:
            # Do passes merging the Nodes until there is only one that 
            # spans the whole histogram
            l = 0
            curr = head
            while curr:
                area = curr.try_flatten()
                if area:
                    largest_area = max(largest_area, area)
                l += 1
                curr = curr.next
        return largest_area

    def also_slow_largestRectangleArea(self, heights: List[int]) -> int:
        ''' This one made it to test case 94 before timing out '''
        largest_area = 0
        # Consider each bin as potentially the left edge of the rectangle.
        # Try to exetend the rectangle right.
        # If we hit a lower bar and have to stop that rectangle, check the area, then
        # reduce the height to be able to continue, and keep scanning
        # Note this means if a potential left edge is lower than the bar to the left
        # we don't need to check it because it would have been part of a rectangle 
        # already checked.
        for l in range(len(heights)):
            # for each left edge
            if l > 0 and heights[l] <= heights[l - 1]:
                # this bar is lower than to the left, can skip
                continue
            h = heights[l]
            if h * (len(heights) - l) <= largest_area:
                # not possible to make a larger rect from here
                continue
            r = l + 1
            while r < len(heights):
                # extend the right edge of the rectangle to the right
                if heights[r] < h:
                    # if it can't continue at that height, check this rectangle
                    # and continue at a reduced height
                    largest_area = max(largest_area, h * (r - l))
                    h = heights[r]
                    if h * (len(heights) - l) < largest_area:
                        # Don't need to keep scanning, not possible to make
                        # a larger rectangle from here.
                        break
                r += 1
            largest_area = max(largest_area, h * (r - l))
        return largest_area
            
    
    def slow_largestRectangleArea(self, heights: List[int]) -> int:
        ''' This one made it to test case 88 before timing out '''
        # The rectangle's top will align with at least one of the bars' height
        # Get unique heigts in order from high to low
        largest_area = 0
        unique_heights = sorted(set(heights), reverse=True)
        last_height = 0
        for l in range(len(heights)): 
            # If this bar is lower than the one to the left, we already checked it
            if heights[l] <= last_height:
                last_height = heights[l]
                continue
            # for each height in unique_heights larger than the bar to the left
            # scan right as far as we can and check that rectangle
            for rectangle_height in unique_heights:
                if rectangle_height > heights[l]:
                    continue
                if rectangle_height <= last_height:
                    break
                max_width = len(heights) - l
                if rectangle_height * max_width <= largest_area:
                    continue
                width = 1
                while width < max_width and heights[l + width] >= rectangle_height:
                    width += 1
                largest_area = max(largest_area, rectangle_height * width)
            last_height = heights[l]
            l += 1
        return largest_area
    

def main():
    """starts_here"""
    nums = [2,1,5,6,2,3] # should be 10 from 2x5 in 5 and 6 bars
    k = Solution().largestRectangleArea(nums)
    print(k)
    

if __name__ == '__main__':
    main()