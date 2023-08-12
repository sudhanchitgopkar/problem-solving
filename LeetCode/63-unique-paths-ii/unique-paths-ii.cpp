class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<long long>> dp (m, vector<long long> (n));
        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (!(i == m - 1 && j == n - 1)){
                    dp[i][j] = (in(i + 1, j, grid) ? dp[i + 1][j] : 0) + 
                                (in(i, j + 1, grid) ? dp[i][j + 1] : 0);
                } //if
            } //for
        } //for

        return dp[0][0];
    } //uniquePaths

    bool in (int x, int y, const vector<vector<int>>& grid) {
        return !(x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size());
    } //in
};