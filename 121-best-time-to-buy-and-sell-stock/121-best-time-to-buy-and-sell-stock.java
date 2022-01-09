class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int l = 0, r = 1, min = prices[0], max = 0;
        
        while (r < prices.length) {
            if (prices[r] < min) {
                min = prices[r];
                l = r;
            } else if (prices[r] - prices[l] > max)
                max = prices[r] - prices[l];
            r++;
        } //while
        
        return max;
    } //maxProfit
} //Solution