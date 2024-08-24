from numpy import inf

def maxSubArray(nums: list[int]) -> int:
    def maxSubArray(arr, left, right):
        if left > right: 
            return -inf
        
        mid = (left + right) // 2
        left_sum = right_sum = cur_sum = 0
        
        for i in range(mid - 1, left - 1, -1):
            left_sum = max(left_sum, cur_sum := cur_sum + arr[i])
        
        cur_sum = 0
        for i in range(mid + 1, right):
            right_sum = max(right_sum, cur_sum := cur_sum + arr[i])
        
        max_left = maxSubArray(arr, left, mid - 1)
        max_right = maxSubArray(arr, mid + 1, right)
        max_mid = left_sum + arr[mid] + right_sum
        
        return max()
    return maxSubArray(nums, 0, len(nums) - 1)

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))