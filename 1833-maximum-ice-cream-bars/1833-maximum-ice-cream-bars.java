class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = Integer.MIN_VALUE, sol = 0, bucketidx = 0;
        for (int cost : costs) max = cost > max ? cost : max;
        int [] buckets = new int [max + 1];
        for (int cost : costs) buckets[cost]++;
        
        while (coins > 0 && bucketidx < buckets.length) {
            if (buckets[bucketidx] == 0) {
                bucketidx++;
            } else if (coins >= bucketidx * buckets[bucketidx]) {
                coins -= bucketidx * buckets[bucketidx];
                sol += buckets[bucketidx++];
            } else if (coins >= bucketidx) {
                coins -= bucketidx;
                buckets[bucketidx]--;
                sol++;
            } else break;
        } //while
        
        return sol;
    } //maxIceCream
} //Sol