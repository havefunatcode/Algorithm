def maxProfit(prices: list[int]) -> int:
    if len(prices) == 1:
        return 0
        
    candidates = []
    
    for idx in range(len(prices) - 1):
        max_value = max(prices[idx+1:])
        candidates.append((prices[idx], max_value))
    
    max_profit = max(value - key for key, value in candidates)
    if max_profit < 0:
        return 0
    return max_profit
    
# print(maxProfit([7,1,5,3,6,4]))
# print(maxProfit([7,6,4,3,1]))
# print(maxProfit([7]))
# print(maxProfit([8,6,4,3,3,2,3,5,8,3,8,2,6]))