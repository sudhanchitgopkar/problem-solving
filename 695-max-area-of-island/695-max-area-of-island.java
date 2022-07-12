class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid,i,j,1));
                } //if
            } //for
        } //for
        
        return max;
    } //maxAreaOfIsland
    
    private int dfs(int [][] grid, int i, int j, int currMax) {
        grid[i][j] = 0;
        
        if (i + 1 < grid.length && grid[i+1][j] == 1) 
            currMax = Math.max(currMax,dfs(grid,i+1,j,currMax+1));
        if (i - 1 >= 0 && grid[i-1][j] == 1) 
            currMax = Math.max(currMax,dfs(grid,i-1,j,currMax+1));
        if (j + 1 < grid[0].length && grid[i][j+1] == 1) 
            currMax = Math.max(currMax,dfs(grid,i,j+1,currMax+1));
        if (j - 1 >= 0 && grid[i][j-1] == 1) 
            currMax = Math.max(currMax,dfs(grid,i,j-1,currMax+1));
       
        return currMax;
    } //dfs
    
} //Sol