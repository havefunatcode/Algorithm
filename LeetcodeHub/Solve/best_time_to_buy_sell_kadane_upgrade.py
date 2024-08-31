def maxProfit(prices: list[int]) -> int:
    if len(prices) == 1:
        return 0
    
    # 최소 구매 가격을 추적하기 위한 변수
    # 최적의 구매 시점을 추적하기 위해 최소 구매 가격을 추적
    minimum_price = prices[0]
    max_profit = 0
    for i in range(1, len(prices)):
        profit = prices[i] - minimum_price
        if prices[i] < minimum_price:
            minimum_price = prices[i]
        elif profit > max_profit:
            max_profit = profit
    return max_profit
    
print(maxProfit([7,1,5,3,6,4]))