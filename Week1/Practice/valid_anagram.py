from collections import Counter

def isAnagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    
    s_counter = Counter(s)
    t_counter = Counter(t)
    s_char = s_counter.keys()
    t_char = t_counter.keys()
    
    if t_char & s_char != s_char:
        return False
    
    for element, element_count in s_counter.items():
        if t_counter[element] != element_count:
            return False
    
    return True


print(isAnagram("aa", "a"))