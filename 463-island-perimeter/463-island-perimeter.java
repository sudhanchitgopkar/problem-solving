class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int neighbors = countNeighbors(grid,r,c);
                    perimeter += 4 - neighbors;
                } //if
            } //for
        } //for
        
        return perimeter;
    } //islandPerimeter
    
    private int countNeighbors (int [][] grid, int r, int c) {
        int neighbors = 0;
        if (r + 1 < grid.length && grid[r+1][c] == 1) neighbors++;
        if (r - 1 >= 0 && grid[r-1][c] == 1) neighbors++;
        if (c + 1 < grid[0].length && grid[r][c+1] == 1) neighbors++;
        if (c - 1 >= 0 && grid[r][c-1] == 1) neighbors++;
        return neighbors;
    } //countNeighbors
} //Sol
