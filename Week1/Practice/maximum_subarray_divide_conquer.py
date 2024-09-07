from numpy import inf

def maxSubArray(nums: list[int]) -> int:
    def maxSubArray(arr, left, right):
        if left > right: 
            return -inf
        
        mid = (left + right) // 2
        left_sum = right_sum = cur_sum = 0
        
        # 좌측의 최대 합
        # 중간 지점 바로 앞에서 왼쪽 끝까지 역순으로 계산
        # [1, -3, 4, -2, 2] 배열의 경우에 계산에 순서에 따라 최댓값이 변경 될 수 있다.
        # 왼족 끝에서부터 중간까지 : 2
        # 중간에서 왼쪽 끝까지 : 4
        for i in range(mid - 1, left - 1, -1):
            left_sum = max(left_sum, cur_sum := cur_sum + arr[i])
        
        cur_sum = 0
        # 우측의 최대합
        for i in range(mid + 1, right):
            right_sum = max(right_sum, cur_sum := cur_sum + arr[i])
        
        max_left = maxSubArray(arr, left, mid - 1)
        max_right = maxSubArray(arr, mid + 1, right)
        max_mid = left_sum + arr[mid] + right_sum
        
        return max(max_left, max_right, max_mid)
    return maxSubArray(nums, 0, len(nums) - 1)

print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))