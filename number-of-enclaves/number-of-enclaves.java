class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length, sol = 0;
        
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(0, i, grid);
            if (grid[m - 1][i] == 1) dfs(m - 1, i, grid);
        } //for

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][n - 1] == 1) dfs(i, n - 1, grid);
        } //for

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) sol++;
            } //for
        } //for
        
        return sol;
    } //numEnclaves

    private void dfs(int x, int y, int [][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == 0 || grid[x][y] == -1) return;
        int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        grid[x][y] = -1;
        for (int [] dir : dirs) {
            dfs(x + dir[0], y + dir[1], grid);
        } //for
    } //dfs

    
} //Sol