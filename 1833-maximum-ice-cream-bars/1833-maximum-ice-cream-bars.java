class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()
        sol = 0
        
        for cost in costs:
            coins -= cost
            if coins < 0:
                return sol
            else:
                sol += 1
        
        return sol
        