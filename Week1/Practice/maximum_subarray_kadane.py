def maxSubArray(nums: list[int]) -> int:
    if len(nums) <=1:
        return nums[0]
    
    current_sum = max_sum = nums[0]
    start_idx = 0
    end_idx = 0
    
    for idx, num in enumerate(nums):
        if num > current_sum + num:
            start_idx = idx
            current_sum = num
        else:
            current_sum += num
        
        if max_sum < current_sum:
            end_idx = idx
            max_sum = current_sum

    print(f"subarray : {nums[start_idx:end_idx+1]}")
    return max_sum
    
print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))