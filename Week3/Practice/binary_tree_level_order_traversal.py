from collections import deque
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def levelOrder(root: Optional[TreeNode]) -> List[List[int]]:
    if root is None:
        return root
    
    queue = []
    result = []
    queue.append(root)
    
    while queue:
        ans = []
        l = len(queue)
        for l in range(l):
            node = queue.pop()
            ans.append(node.val)
            if node.left != None:
                queue.append(node.left)
            if node.right != None:
                queue.append(node.right)
        result.append(ans)
    return result

class Solution:
    def levelOrderBfs(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return root

        result: List[List[int]] = []
        # (node, level)
        queue = deque([(root, 0)])
        
        while queue:
            node, level = queue.popleft()
            
            if len(result) == level:
                result.append([])
            
            result[level].append(node.val)
            
            if node.left:
                queue.append((node.left, level + 1))
            if node.right:
                queue.append((node.right, level + 1))
            
        return result

    def levelOrderDfsRecursive(self, root: Optional[TreeNode]) -> List[List[int]]:
        def dfs(node: Optional[TreeNode], level: int) -> None:
            if not node:
                return
            
            if len(result) == level:
                result.append([])
            
            result[level].append(node.val)
            
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)
        
        result: List[List[int]] = []
        dfs(root, 0)
        return result

    def levelOrderDfsIter(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        result: List[List[int]] = []
        stack = [(root, 0)]  # (node, level) 튜플을 저장
        
        while stack:
            node, level = stack.pop()
            
            if len(result) == level:
                result.append([])
            
            result[level].append(node.val)
            
            if node.right:
                stack.append((node.right, level + 1))
            if node.left:
                stack.append((node.left, level + 1))
        
        return result

root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

# Solution 인스턴스 생성
solution = Solution()

# BFS 테스트
print("BFS 결과:", solution.levelOrderBfs(root))

# DFS (재귀) 테스트
print("DFS (재귀) 결과:", solution.levelOrderDfsRecursive(root))

# DFS (반복) 테스트
print("DFS (반복) 결과:", solution.levelOrderDfsIter(root))