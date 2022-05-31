class Solution {
    public int maxProfit(int[] prices) {
        int lMax = 0, gMax = 0;
        int buyi = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[buyi] > gMax) gMax = prices[i] - prices[buyi];
            else if (prices[i] < prices[buyi]) buyi = i;
        } //for
        
    return gMax;
    } //maxProfit
} //Solution