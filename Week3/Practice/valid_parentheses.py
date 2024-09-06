def isValid(s: str) -> bool:
    if len(s) == 1:
        return False
    
    if len(s) % 2 != 0:
        return False    
    
    s_list = list(s)
    stack = []
    for char in s_list:
        if len(stack) == 0:
            stack.append(char)
            continue
        
        latest_char = stack.pop()
        if char == ')' and latest_char == '(':
            continue
        elif char == ']' and latest_char == '[':
            continue
        elif char == '}' and latest_char == '{':
            continue
        else:
            stack.append(latest_char)            
            stack.append(char)
        
    if len(stack) != 0:
        return False

    return True

# true
# s = "()"
# isValid(s)
# true
# s = "()[]{}"
# print(isValid(s))
# false
# s = "((]"
# isValid(s)
# true
s = "([])"
isValid(s)