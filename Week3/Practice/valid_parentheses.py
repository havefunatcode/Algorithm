from collections import Counter

def isValid(s: str) -> bool:
    if len(s) == 1:
            return False
        
    if len(s) % 2 != 0:
        return False

    s_counter = Counter(s)
    parenthesis_count = s_counter['('] - s_counter[')']
    braces_count = s_counter['{'] - s_counter['}']
    brackets_count = s_counter['['] - s_counter[']']
    
    return ((parenthesis_count or braces_count or brackets_count) == 0)    
    

# true
# s = "()"
# isValid(s)
# true
# s = "()[]{}"
# isValid(s)
# false
s = "((]"
isValid(s)
# true
# s = "([])"
# isValid(s)