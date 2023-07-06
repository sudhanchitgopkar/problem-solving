class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> sol (m, vector<int> (n, INT_MAX));

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sol[i][j] = grid[i][j];
                if (i == m - 1 && j == n - 1) {
                    continue;
                } else if (!in(i + 1, j, m, n)) {
                    sol[i][j] += sol[i][j + 1];
                } else if (!in(i, j + 1, m, n)) {
                    sol[i][j] += sol[i + 1][j];
                } else {
                    sol[i][j] += min(sol[i + 1][j],
                                    sol[i][j + 1]);
                } //if
            } //for
        } //for

        return sol[0][0];
    } //minPathSum

    bool in(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    } //in
}; 