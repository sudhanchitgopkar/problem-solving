class Solution {
    public int minEatingSpeed(int[] piles, int h) {        
        int max = piles[0];
        
        for (int p : piles) {
            if (p > max) max = p;
        } //for
        
        int l = 1, r = max, sol = max;
        
        while (l <= r) {
            int m = l + ((r-l)/2);
            int hoursTaken = 0;
            
            for (int p : piles) {
                hoursTaken += Math.ceil(p/(m*1.0));
            } //for
            
            if (hoursTaken <= h) {
                if (m < sol) sol = m;  
                r = m - 1;
            } else {
                l = m + 1;
            } //if
        } //while
        
        return sol;
    } //minEatingSpeed
} //Solution