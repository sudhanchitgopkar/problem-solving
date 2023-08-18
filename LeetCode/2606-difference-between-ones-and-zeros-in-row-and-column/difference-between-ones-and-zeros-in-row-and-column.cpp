class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<int> rowSum (m), colSum (n);
        vector<vector<int>> diff (m, vector<int> (n));

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            } //for
            rowSum[i] = sum;
        } //for

         for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += grid[j][i];
            } //for
            colSum[i] = sum;
        } //for

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = rowSum[i] - (m - rowSum[i]);
                diff[i][j] += colSum[j] - (n - colSum[j]);
            } //for
        } //for
        
        return diff;
    } //onesMinusZeros
};