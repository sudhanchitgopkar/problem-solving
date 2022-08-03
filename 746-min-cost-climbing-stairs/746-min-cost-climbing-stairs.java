class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] memo = new int [cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];
        dfs(cost,memo,2);
        return Math.min(memo[memo.length-1], memo[memo.length-2]);
    } //minCostClimbingStairs
    
    private void dfs (int [] cost, int [] memo, int curr) {
        if (curr >= cost.length) return;
        memo[curr] = Math.min(memo[curr - 1], memo[curr - 2]) + cost[curr];
        dfs(cost,memo,curr+1);
    } //dfs
} //Sol