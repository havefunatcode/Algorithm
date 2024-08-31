def maxProfit(prices: list[int]) -> int:
    if len(prices) == 1:
        return 0
    
    max_profit = current_profit = 0
    for i in range(1, len(prices)):
        current_profit = max(0, current_profit + prices[i] - prices[i-1])
        max_profit = max(current_profit, max_profit)
    
    return max_profit
    
print(maxProfit([7,1,5,3,6,4]))