class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int l = 0, r = 1;
        int lMax = 0, gMax = 0;
        
        while (r < prices.length) {
            if (prices[r] < prices[l]) l = r++;
            else lMax = prices[r++]-prices[l];
            gMax = lMax > gMax ? lMax : gMax;
        } //while
        
        return gMax;
    } //maxProfit
} //Solution