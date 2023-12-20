class Solution(object):
    def buyChoco(self, prices, money):
        return money - (sorted(prices)[0] + sorted(prices)[1]) if sorted(prices)[0] + sorted(prices)[1] <= money else money
        