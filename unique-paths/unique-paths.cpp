class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> grid;

        for (int i = 0; i < m; i++) {
            grid.push_back(vector<int> (n, 0));
        } //for

        grid[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (in(i + 1, j, m, n)) {
                    grid[i][j] += grid[i + 1][j];
                } //if

                if (in(i, j + 1, m, n)) {
                    grid[i][j] += grid[i][j + 1];
                } //if
            } //for
        } //for

        return grid[0][0];
    } //uniquePaths

    bool in(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n; 
    } //in
}; 