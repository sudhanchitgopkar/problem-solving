class Solution {
    public int uniquePaths(int m, int n) {
        int [][] numPaths = new int [m][n];
        
        for (int row = 0; row < m; row++)
            numPaths[row][0] = 1;
        for (int col = 0; col < n; col++)
            numPaths[0][col] = 1;
        
        for (int row = 1; row < m; row++)
            for (int col = 1; col < n; col++)
                numPaths[row][col] = numPaths[row-1][col] + numPaths[row][col-1];
        
        return numPaths[m-1][n-1];
    } //uniquePaths
}