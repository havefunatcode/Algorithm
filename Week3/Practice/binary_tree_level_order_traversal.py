from collections import deque
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrderBfs(self, root:Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        queue = deque([(root, 0)])
        result: List[List[int]] = []
        
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
            if node is None:
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
        if root is None:
            return []
        
        result: List[List[int]] = []
        stack = [(root, 0)]
        
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

solution = Solution()
print("BFS 결과:", solution.levelOrderBfs(root))
print("DFS (재귀) 결과:", solution.levelOrderDfsRecursive(root))
print("DFS (반복) 결과:", solution.levelOrderDfsIter(root))