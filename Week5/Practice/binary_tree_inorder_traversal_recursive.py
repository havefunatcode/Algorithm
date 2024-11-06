from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorder(self, root):
    # 왼쪽 -> 루트 -> 오른쪽
        if not root:    
            return []
        return self.inorder(root.left) + [root.val] + self.inorder(root.right)

    def preorder(self, root):
        # 루트 -> 왼쪽 -> 오른쪽
        if not root:
            return []
        return [root.val] + self.preorder(root.left) + self.preorder(root.right)

    def postorder(self, root):
        # 왼쪽 -> 오른쪽 -> 루트
        if not root:
            return []
        return self.postorder(root.left) + self.postorder(root.right) + [root.val]


def build_tree(nodes):
    if not nodes:
        return None
        
    root = TreeNode(nodes[0])  # 첫 번째 값으로 루트 생성
    queue = deque([root])
    i = 1
    
    while queue and i < len(nodes):
        node = queue.popleft()
        
        # 왼쪽 자식 추가
        if i < len(nodes) and nodes[i] is not None:
            node.left = TreeNode(nodes[i])
            queue.append(node.left)
        i += 1
        
        # 오른쪽 자식 추가
        if i < len(nodes) and nodes[i] is not None:
            node.right = TreeNode(nodes[i])
            queue.append(node.right)
        i += 1
            
    return root

# 테스트 코드
if __name__ == "__main__":
    # 테스트할 이진 트리 데이터
    nodes = [1, 2, 3, 4, 5, None, 8, None, None, 6, 7, 9]
    
    # 트리 생성
    root = build_tree(nodes)
    
    # Solution 인스턴스 생성 및 중위 순회 실행
    solution = Solution()
    print("Inorder:", solution.inorder(root))
    print("Preorder:", solution.preorder(root)) 
    print("Postorder:", solution.postorder(root))     