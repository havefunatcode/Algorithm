def containsDuplicate(nums: list[int]) -> bool:
    nums_set = set(nums)
    if len(nums_set) != len(nums):
        return True
    return False

print(containsDuplicate([1,1,1,3,3,4,3,2,4,2]))