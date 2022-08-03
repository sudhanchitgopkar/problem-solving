class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] memo = new int [cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];
        
        for (int i = 2; i < cost.length; i++) 
            memo[i] = Math.min(memo[i - 1], memo[i - 2]) + cost[i];
        
        return Math.min(memo[memo.length-1], memo[memo.length-2]);
    } //minCostClimbingStairs
} //Sol