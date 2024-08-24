def maxSubArray(nums: list[int]) -> int:
    pref, suf = [*nums], [*nums]
    
    for i in range(1, len(nums)):
        pref[i] += max(0, pref[i-1])
    for i in range(len(nums)-2, -1, -1):
        suf[i] += max(0, suf[i+1])
    
    def maxSubArray(arr, left, right):
        if left == right:
            return arr[i]
        mid = (left + right) // 2
        
        max_left = maxSubArray(arr, left, mid)
        max_right = maxSubArray(arr, mid + 1, right)
        max_mid = pref[mid] + suf[mid + 1]
        return max(max_left, max_right, max_mid)
    return maxSubArray(nums, 0, len(nums) - 1)
        
print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))