## What is Kadane's Algorithm?
- 주어진 배열에서 연속된 부분 배열 중에서 합이 가장 큰 부분 배열을 찾는 알고리즘
- 주로 최대 부분 배열 문제(Maximum Subarray Problem)를 해결하는 데 사용된다.
- 시간 복잡도는 \(O(n)\)이다.

### Key Idea
1. 배열을 처음부터 끝까지 순회하면서, **현재 위치까지의 부분 배열에서 최대 합을 유지**한다.
2. 현재 위치에서 끝나는 **부분 배열의 최대 합을 계산**한다.
   - 이 값은 현재 원소 하나만 포함하는 경우와 이전 부분 배열에 현재 원소를 추가하는 경우 중 더 큰 값이다.
3. 이 값이 전체 배열에서 최대 합보다 크면, **최대 합을 갱신**한다.
4. 배열을 끝까지 순회한 후, 전체 최대 합을 반환한다.

### Algorithm
1. 변수 초기화
   - `max_current`: 현재 위치까지의 최대 부분 배열 합.
   - `max_global`: 전체 배열에서의 최대 부분 배열 합.
   - 배열의 첫 번째 원소로 `max_current`와 `max_global`를 초기화한다.
     - `max_current = max_global = arr[0]`
2. 두 번째 원소부터 배열의 끝까지 반복한다.
   - `max_current`는 현재 원소와 `max_current + 현재 원소` 중 더 큰 값으로 갱신한다.
   - `max_global`는 `max_current`와 `max_global` 중 더 큰 값으로 갱신한다.
3. 최종적으로 `max_global`이 최대 부분 배열의 합이 된다.

### Example
`arr = \([-2, 1, -3, 4, -1, 2, 1, -5, 4]\)`
1. 첫 번째 원소: `max_current = -2`, `max_global = -2`
2. 두 번째 원소: `max_current = max(1, -2 + 1) = 1`, `max_global = max(-2, 1) = 1`
3. 세 번째 원소: `max_current = max(-3, 1 - 3) = -2`, `max_global = 1`
4. 네 번째 원소: `max_current = max(4, -2 + 4) = 4`, `max_global = max(1, 4) = 4`   
    Loop
5. 마지막 원소: `max_current = 4`, `max_global = 6`

따라서, 이 배열에서의 최대 부분 배열 합은 `6`이 된다. (부분 배열 [4, -1, 2, 1])

### Code
``` python
def kadane_algorithm(arr):
    # 초기화: 첫 번째 원소로 현재 최대 합과 전체 최대 합을 설정
    max_sum = current_sum = arr[0]

    # 부분 배열의 시작과 끝 인덱스를 추적하기 위한 변수
    start_idx = 0
    end_idx = 0

    # 배열 순회
    for idx, num in enumerate(arr):
        # 현재 위치까지의 최대 합 계산
        if num > current_sum + num:
            current_sum = num
            start_idx = idx
        else:
            current_sum += num
        
        # 전체 최대 합 갱신
        if max_sum < current_sum:
            max_sum = current_sum
            end_idx = idx

    return max_global, arr[start_idx:end_idx+1]
```
