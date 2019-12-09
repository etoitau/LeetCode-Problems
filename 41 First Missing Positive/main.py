# Uses python3

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        minVal = min(nums)
        # only interested in integers 1 and larger, if less, set them aside
        if minVal < 1:
            start = partition(nums: List[int], 0, len(nums), part: int)
        if nums[start] != 1:
            return 1
        else:
            return recursiveSearch(nums, minVal, start, len(nums))

    def recursiveSearch(nums: List[int], minVal: int, start: int, endEx: int) -> int:
        # if search is terminated
        if endEx - start == 1:
            if nums[start] == minVal:
                return minVal + len(nums) - start)
            else:
                return minVal
        
        halfLength = (endEx - start) // 2

        # partition about middle value
        partition(nums, start, endEx, minVal + halfLength)   
    
        if nums[start + halfLength] == minVal + halfLength:
            return recusiveSearch(nums, minVal + halfLength, start + halfLength + 1, endEx))
        else:
            return recursiveSearch(nums, minVal, start, start + halfLength)
    

    def partition(nums: List[int], start: int, endEx: int, partVal: int):
        """
        partition similar to quicksort
        reserve nums[start] for partVal, if found
        go through rest, sorting less than or greater than partVal, put partVal at start if found
        swap start to middle and return middle index
        """
        div = start + 1
        cursor = start + 1
        end = endEx - 1
        while cursor <= end:
            if nums[cursor] < partVal:
                cursor += 1
                div += 1
            elif nums[cursor] == partVal:
                nums[start], nums[cursor] = nums[cursor], nums[start]
            else:
                nums[cursor], nums[end] = nums[end], nums[cursor]
                end -= 1
        return div
    




def main():
    """starts_here"""
    print("Hello World")

if __name__ == '__main__':
    """starts here"""
    main()