class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 0;
                    numIslands++;
                    dfs(grid,i,j);
                } //if
            } //for
        } //for
        
        return numIslands;
    } //numIslands
    
    private void dfs (char[][] grid, int i, int j) {
        if (i-1 >= 0 && grid[i-1][j] == '1') {
            grid[i-1][j] = 0;
            dfs(grid,i-1,j);
        }
        if (i + 1 < grid.length && grid[i+1][j] == '1') {
            grid[i+1][j] = 0;
            dfs(grid,i+1,j);
        }
        if (j-1 >= 0 && grid[i][j-1] == '1') {
            grid[i][j-1] = 0;
            dfs(grid,i,j-1);
        }
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
            grid[i][j+1] = 0;
            dfs(grid,i,j+1);
        } //if
    } //dfs
} //Sol