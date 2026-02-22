#!/usr/bin/env python3

# LeetCode Problem 83 Remove Duplicates from Sorted List
#
# Result:
# Runtime: 0 ms beats 100%
# Memory Usage: 19 MB beats 25%

from typing import Sequence, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        newPrev = head
        curr = head.next
        while curr:
            if curr.val != newPrev.val:
                newPrev.next = curr
                newPrev = curr
            curr = curr.next
        newPrev.next = None
        return head
    
def toLinkedList(numbers: Sequence[int]):
    head: ListNode | None = None
    for i in range(len(numbers) -1, -1, -1):
        next = ListNode(numbers[i], head)
        head = next
    return head

def fromLinkedList(node: ListNode | None):
    result = []
    while node:
        result.append(node.val)
        node = node.next
    return result

def main():
    """starts_here"""
    nums = [1,2,2]
    k = fromLinkedList(Solution().deleteDuplicates(toLinkedList(nums)))
    print(k)
    

if __name__ == '__main__':
    main()