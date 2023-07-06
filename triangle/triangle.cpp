class Solution {
public:
    int minimumTotal(vector<vector<int>>& tri) {
        int n = tri.size();
        vector<vector<int>> dp;

        for (int i = 0; i < n; i++) {
            dp.push_back(vector<int> (i + 1, -1));
        } //for

        return dfs(0, 0, n, 0, tri, dp);
    } //minTotal

    int dfs(int i, int j, int n, int sum, 
            vector<vector<int>>& tri, vector<vector<int>>& dp) {
        if (i == n - 1) return tri[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        sum += tri[i][j];
        sum += min(dfs(i + 1, j, n, 0, tri, dp), dfs(i + 1, j + 1, n, 0, tri, dp));
        dp[i][j] = sum;
        return sum;        
    } //dfs
};