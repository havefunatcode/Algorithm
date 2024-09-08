## `if not node` & `if root is None`
### `if not node`
- Python의 `Truthy`와 `Falsy` 개념을 활용한다.
- None, 빈 컨테이너([], {}, ""), 숫자 0은 모두 "Falsy"로 평가된다.
- node가 None이거나 빈 객체일 경우 조건이 참이 된다.

### `if root is None`
- 명시적으로 None과의 비교를 수행
- root가 정확히 None일 때만 조건이 참

### 차이점
#### 범위
- if not node:는 None 뿐만 아니라 빈 리스트, 빈 문자열, 0 등도 참으로 평가할 수 있다.
#### 사용 맥락
- 트리나 연결 리스트 같은 자료구조에서는 보통 None을 체크하므로 두 표현이 동일하게 작동   
    But. 다른 상황에서는 if not x:가 더 넓은 범위의 **"비어있음"**을 체크할 수 있다.

## Python의 `Truthy` & `Falsy`
### 정의
- `Boolean` 컨텍스트에서 `True` 또는 `False`로 평가되는 값
  - `Truthy` : 불리언 컨텍스트에서 `True`로 평가되는 값들
  - `Falsy` : 불리언 컨텍스트에서 `False`로 평가되는 값들
### `Falsy`
- `None`
- `False`
- 숫자 0 (0, 0.0, 0j)
- 빈 시퀀스와 컬렉션: '', [], (), {}, set(), range(0)
### `Truthy`
- Falsy가 아닌 모든 값
  - True
  - 0이 아닌 모든 숫자
  - 비어있지 않은 문자열, 리스트, 튜플, 딕셔너리, 집합 등