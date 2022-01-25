class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int max = 0;
        int l = 0, r = 1;
        
        while (r < prices.length) {
            if (prices[r] < prices[l])
                l = r++;
            else if (prices[r] - prices[l] > max)
                max = prices[r++] - prices[l];
            else r++;
        } //while
        
        return max;
    } //maxProfit
} //Solution