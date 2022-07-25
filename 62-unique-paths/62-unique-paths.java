class Solution {
    int rowLen, colLen;
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int [][] numPaths = new int [m][n];
        numPaths[m-1][n-1] = 1;
        rowLen = m;
        colLen = n;
        findPath(0,0,numPaths);
        return numPaths[0][1] + numPaths[1][0];
    } //uniquePaths
    
    private int findPath (int row, int col, int [][] numPaths) {
        if (row == rowLen-1 && col == colLen - 1) return 1;
        if (row >= rowLen || col >= colLen) return 0;
        
        if (row + 1 >= rowLen) {
            if (numPaths[row][col+1] == 0) {
                numPaths[row][col] = findPath(row,col+1,numPaths);
            } else {
                numPaths[row][col] = numPaths[row][col+1];
            } //if
            return numPaths[row][col];
        } //if
        
        if (col + 1 >= colLen) {
            if (numPaths[row+1][col] == 0) {
                numPaths[row][col] = findPath(row+1,col,numPaths);
            } else {
                numPaths[row][col] = numPaths[row+1][col];
            } //if
            return numPaths[row][col];
        } //if
        
        int pathsDown = numPaths[row+1][col];
        int pathsRight = numPaths[row][col+1];
        
        if (pathsDown == 0) pathsDown = findPath(row+1,col,numPaths);
        if (pathsRight == 0) pathsRight = findPath(row,col+1,numPaths);
        
        numPaths[row][col] = pathsDown + pathsRight;
        return numPaths[row][col];
    } //findPath
}