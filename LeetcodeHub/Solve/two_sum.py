def twoSum(nums: list[int], target: int) -> list[int]:
    if len(nums) == 2:
        return [0, 1]
    
    num_map = {}
    
    for idx, num in enumerate(nums):
        complement = target - num
        if complement in num_map:
            return [num_map[complement], idx]
        
        num_map[num] = idx
        
    return []
    
nums = [3,2,4]
target = 6
print(twoSum(nums, target))