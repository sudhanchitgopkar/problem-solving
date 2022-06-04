class Solution {
    public int maxProfit(int[] prices) {
        int lMax, gMax = 0;
        int l = 0, r = 0;
        
        while (r < prices.length) {
            lMax = prices[r] - prices[l];
            
            if (prices[r] < prices[l]) l = r++;
            else r++;
                        
            if (gMax < lMax) gMax = lMax;
        } //while
       
        return gMax;
    } //maxProfit
} //Solution