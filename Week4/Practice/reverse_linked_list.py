from typing import Optional

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val  = val
        self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        values = []
        while head:
            values.append(head.val)
            head = head.next
        
        result = ListNode(values[-1])
        current = result
        for i in range(len(values) - 2, -1, -1):
            current.next = ListNode(values[i])
            current = current.next
        return result
    
    def effectiveReverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, head = None, head
        
        while head:
            head.next, prev, head = prev, head, head.next
        return prev
            

def create_linked_list():
    # 첫 번째 노드 생성 (head)
    head = ListNode(1)
    current = head
    
    # 2부터 10까지의 노드 생성 및 연결
    for i in range(2, 11):
        current.next = ListNode(i)
        current = current.next
    
    return head

# 사용 예시
head = create_linked_list()
reversed_head = Solution().reverseList(head)
reversed_head_2 = Solution().effectiveReverseList(head)
# 생성된 리스트 확인을 위한 출력
current = reversed_head
while current:
    print(current.val, end=" -> ")
    current = current.next
print("None")