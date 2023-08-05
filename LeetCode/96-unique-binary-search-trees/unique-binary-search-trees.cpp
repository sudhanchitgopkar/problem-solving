class Solution {
public:
    int numTrees(int n) {
        vector<int> dp (max(3, n + 1));
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int curr = 3; curr <= n; curr++) {
            int res = 0;
            for (int root = 1; root <= curr; root++) {
                res += dp[root - 1] * dp[curr - root];
            } //for
            dp[curr] = res;
        } //for

        return dp[n];
    } //numTrees
};