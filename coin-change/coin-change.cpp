class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        vector<int> dp (amount + 1, -1);

        if (amount == 0) return 0;
        solve(amount, coins, dp);

        for (int val : dp) cout << val << " ";

        return dp[amount] == -2 ? -1 : dp[amount];
    } //coinChange

    int solve(int amount, vector<int>& coins, vector<int>& dp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -2;
        } else if (dp[amount] != -1) {
            return dp[amount];
        } //if

        int sol = INT_MAX;
        for (int coin : coins) {
            int res = solve(amount - coin, coins, dp);
            if (res != -2) {
                sol = min(sol, 1 + res);
            } //if
        } //for

        dp[amount] = sol == INT_MAX ? -2 : sol;
        return dp[amount];
    } //solve
};