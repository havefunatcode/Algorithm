from collections import Counter

def firstUniqChar(s: str) -> int:
    s_counter = Counter(s)
    unique_characters = [key for key, value in s_counter.items() if value == 1]
    
    if len(unique_characters) == 0:
        return -1
    
    idx_candidates = []
    for unique_character in unique_characters:
        idx_candidates.append(s.index(unique_character))
    
    return sorted(idx_candidates)[0]
    
print(firstUniqChar('loveleetcode'))