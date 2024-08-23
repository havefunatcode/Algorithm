def heap_sort(arr: list):
    arr_len = len(arr)
    
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, arr_len, i)
        
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

def heapify(arr: list, arr_len: int, i: int):
    largest_idx = i
    left_child_idx = 2 * i + 1
    right_child_idx = 2 * i + 2
    
    if left_child_idx < arr_len and arr[largest_idx] < arr[left_child_idx]:
        largest_idx = left_child_idx
    
    if right_child_idx < arr_len and arr[largest_idx] < arr[right_child_idx]:
        largest_idx = right_child_idx
    
    if largest_idx != i:
        arr[largest_idx], arr[i] = arr[i], arr[largest_idx]
        heapify(arr, arr_len, largest_idx)
    
n = int(input())
arr = list(map(int, input().split()))

heap_sort(arr)
print(f"Sorted List: {' '.join(map(str, arr))}")