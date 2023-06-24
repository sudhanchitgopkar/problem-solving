class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        
        cost[n - 1] = min(cost[n - 1], cost[n - 2]);
        
        for (int i = n - 3; i >= 0; i--) {
            cost[i] += min(cost[i + 1], cost[i + 2]);
        } //for
        
        return min(cost[0], cost[1]);
    } //minCost
};