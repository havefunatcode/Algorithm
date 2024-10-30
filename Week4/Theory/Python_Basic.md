## Multiple Assignment(다중 할당)
### 정의
- 다중 할당은 여러 변수에 동시에 값을 할당하는 파이썬의 기능
- 콤마(,)를 사용하여 변수와 값을 구분한다.   
  ex) `x, y = y, x + y`
### 실행 순서
1.	오른쪽 식의 평가   
    - 오른쪽의 모든 식이 먼저 평가되어 임시 값으로 저장   
	ex) `x, y = y, x + y`에서 `y`와 `x + y`가 먼저 계산
2.	왼쪽 변수에 할당
	- 왼쪽에서 오른쪽 순서로 변수에 값이 할당

### 예시
```python 
def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    prev, head = None, head

    while head:
        head.next, prev, head = prev, head, head.next
    return prev
```
- 위의 코드에서 다중 할당 부분인 `head.next, prev, head = prev, head, head.next`를 `prev, head, head.next = head, head.next, prev`로 선언하면 `AttributeError: 'NoneType' object has no attribute 'next'` 오류가 발생한다.  
   이는 실행 순서가 잘못 됬기 때문이다. 다중 할당에서는 우변의 계산식이 먼저 계산되고 그 해당 값이 좌변에 할당되는 방식인데 `prev, head, head.next = head, head.next, prev`로 선언하면 다음과 같이 할당된다.
```text
ListNode = 1 -> 2 -> 3 -> 4 -> 5 -> None

# 1회차 반복
head = 1
head.next = 2
prev = None

# 2회차 반복
head = 2
head.next = None
prev = 1
prev.next = 2
prev.next.next = None

# 3회차 반복
head = None
head.next = None
prev = 2
prev.next = None
```
- 위와 같이 할당되기 때문에 `AttributeError: 'NoneType' object has no attribute 'next'` 오류가 발생한다.