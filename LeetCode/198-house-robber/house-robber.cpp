class Solution {
public:
    int rob(vector<int>& money) {
        int n = money.size();
        vector<int> dp (n, -1);
        dfs(0, money, dp);
        return dp[0];
    } //rob

    int dfs(int curr, vector<int>& money, vector<int>& dp) {
        int n = money.size();
        if (curr == n - 2) {
            dp[curr] = max(money[n - 2], money[n - 1]);
            return dp[curr];
        } else if (curr == n - 1) {
            dp[curr] = money[n - 1];
            return dp[curr];
        } else if (curr >= n) {
            return 0;
        } else if (dp[curr] != -1) {
            return dp[curr];
        } //if

        dp[curr] = max(dfs(curr + 1, money, dp), money[curr] + dfs(curr + 2, money, dp));
        return dp[curr];
    } //dfs
};