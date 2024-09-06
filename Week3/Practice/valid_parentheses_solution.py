def isValid(s: str) -> bool:
    open_braces = ['(', '[', '{']
    close_braces = [')', ']', '}']
    stack = []
    
    for char in s:
        if char in open_braces:
            stack.append(char)
        elif char in close_braces:
            if len(stack) == 0:
                return False
            
            prev_open = stack[-1]
            prev_open_idx = open_braces.index(prev_open)
            close_idx = close_braces.index(char)
            
            if prev_open_idx == close_idx:
                stack.pop(-1)
            else:
                return False
    
    if len(stack) == 0:
        return True
    else:
        return False