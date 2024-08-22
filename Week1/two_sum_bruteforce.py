def two_sum(nums: list[int], target: int) -> list[int]:
    if len(nums) == 2:
        return [0, 1]
    
    result = []
    nums_len = len(nums)
    
    for i in range(0, nums_len - 1):
        for j in range(i + 1, nums_len):
            if nums[i] + nums[j] == target:
                return [i, j]
        
    return result

print(two_sum([2, 7, 11, 15], 9))