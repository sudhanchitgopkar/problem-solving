class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int l = 0, r = 1, profit = 0;
        
        while (r < prices.length) {
            if (prices[r] < prices[l]) {
                l = r++;
            } else if (prices[r] - prices[l] > profit) {
                profit = prices[r] - prices[l];
                r++;
            } else {
                r++;
            }
        } //while
        
        return profit;
    } //maxProfit
} //Solution