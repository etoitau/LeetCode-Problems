#!/usr/bin/env python3

# LeetCode Problem 82 Remove Duplicates from Sorted List II
#
# Result:
# Runtime: 1 ms beats 40%
# Memory Usage: 19 MB beats 59%

from typing import Sequence, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dupeVal = None
        newPrev = ListNode(-1, None)
        newHead = newPrev
        curr = head
        while curr:
            if dupeVal != None:
                if curr.val == dupeVal:
                    curr = curr.next
                    continue
                else:
                    dupeVal = None
                    continue
            if not curr.next:
                newPrev.next = curr
                newPrev = curr
                curr = curr.next
                continue
            if curr.val == curr.next.val:
                dupeVal = curr.val
                curr = curr.next
                continue
            newPrev.next = curr
            newPrev = curr
            curr = curr.next
        if newPrev:
            newPrev.next = None
        return newHead.next
    
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