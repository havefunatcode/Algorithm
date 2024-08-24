from numpy import inf

def maxSubArray(nums: list[int]) -> int:
    nums_len = len(nums)
    
    if nums_len <= 1:
        return nums[0]
    
    ans = -inf
    for i in range(nums_len):
        current_sum = 0
        for j in range(i, nums_len):
            current_sum += nums[j]
            ans = max(current_sum, ans)
    
    return ans

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))