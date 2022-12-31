class Solution {
    int openCells;
    public int uniquePathsIII(int[][] grid) {
        int startx = 0, starty = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) {
                    openCells++;
                } //if
                
                if (grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                } //if
            } //for
        } //for
        return dfs(grid, startx, starty, new HashSet <String> ());
    } //uniquePaths

    public int dfs (int[][] grid, int x, int y, HashSet <String> seen) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if (grid[x][y] == 2 && seen.size() == openCells - 1) return 1 ;
        if (grid[x][y] == 2 || grid[x][y] == -1) return 0;
        if (seen.contains(x + "," + y)) return 0;

        seen.add(x + "," + y);
        int sol = 
        dfs(grid, x + 1, y, seen) +
        dfs(grid, x - 1, y, seen) + 
        dfs(grid, x, y + 1, seen) +
        dfs(grid, x, y - 1, seen);
        seen.remove(x + "," + y);
        return sol;
    } //dfs
}