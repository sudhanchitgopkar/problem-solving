class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        vector<vector<int>> dp (m + 1, vector<int> (n + 1));
        dp[m - 1][n - 2] = dp[m - 2][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } //if
            } //for
        } //for

        return dp[0][0];
    } //uniquePaths
};