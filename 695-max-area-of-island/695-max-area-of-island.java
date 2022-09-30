class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int gMax = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid,i,j);
                    if (size > gMax) gMax = size;
                } //iof
            } //for
        } //for
        
        return gMax;
    } //maxAreaOfIsland
    
    private int dfs (int [][] grid, int r, int c) {
        if (r < 0 || c < 0 || 
            r >= grid.length || c >= grid[0].length) return 0;
        if (grid[r][c] == 0) return 0;
        
        grid[r][c] = 0;
        return 1 + dfs(grid,r-1,c) + dfs(grid,r+1,c) + 
            dfs(grid,r,c+1) + dfs(grid,r,c-1);
    } //dfs
} //Sol