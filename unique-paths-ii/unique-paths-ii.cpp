class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<long long>> dp (m, vector<long long> (n, 0));

        if (grid[m - 1][n - 1] == 1 || grid[0][0] == 1) return 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                bool dValid = valid(i + 1, j, m, n, grid);
                bool rValid = valid(i, j + 1, m, n, grid);

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = (long long) 1;
                } else if (!rValid && !dValid) {
                    dp[i][j] = (long long) 0;
                } else if (!rValid || !dValid) {
                    dp[i][j] = dValid ? dp[i + 1][j] : dp[i][j + 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } //if
            } //for
        } //for

        return dp[0][0];
    } //uniquePathsWithObstacles

    bool valid (int i, int j, int m, int n, vector<vector<int>>& grid) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        else return !grid[i][j];
    } //valid
};