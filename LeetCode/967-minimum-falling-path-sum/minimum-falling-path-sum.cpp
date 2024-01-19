class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& mat) {
        int m = mat.size(), n = mat[0].size(), sol = INT_MAX;
        vector<vector<int>> dp (m, vector<int> (n, -1));

        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = mat[m - 1][j];
        } //for

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int dl = in(i + 1, j - 1, m, n) ? dp[i + 1][j - 1] : INT_MAX;
                int d = in(i + 1, j, m, n) ? dp[i + 1][j] : INT_MAX;
                int dr = in(i + 1, j + 1, m, n) ? dp[i + 1][j + 1] : INT_MAX;

                dp[i][j] = mat[i][j] + min(dl, min(d, dr));
            } //for
        } //for

        for (int j = 0; j < n; j++) {
            sol = min(sol, dp[0][j]);
        } //for

        return sol;
    } //minFallingPathSum

    bool in (int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    } //in
};