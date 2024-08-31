def intersection(nums1: list[int], nums2: list[int]) -> list[int]:    
    # return set(nums1).intersection(set(nums2))
    return set(nums1) & set(nums2)
    
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]
result = intersection(nums1, nums2)
print(result)