class Solution {
    public int islandPerimeter(int[][] grid) {
        int sol = 0;
        
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) 
                if (grid[i][j] == 1) sol += 4-countNeighbors(grid,i,j);
        return sol;
    }
    
    private int countNeighbors(int[][] grid, int i, int j) {
        int neighbors = 0;
        if (i - 1 >= 0 && grid[i-1][j] == 1) neighbors++;
        if (j - 1 >= 0 && grid[i][j-1] == 1) neighbors++;
        if (i + 1 < grid.length && grid[i+1][j] == 1) neighbors++;
        if (j + 1 < grid[0].length && grid[i][j+1] == 1) neighbors++;
        return neighbors;
    } //countNeighbors
}

//1->3
//2->2
//
