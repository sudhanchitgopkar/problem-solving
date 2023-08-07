class Solution {
    public int numIslands(char[][] grid) {
        int sol = 0, m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++sol;
                    invalidate(i, j, grid);
                } //if
            } //for
        } //for

        return sol;
    } //numIslands

    private void invalidate (int x, int y, char[][] grid) {
        if (!(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length)) return;
        if (grid[x][y] == '0') return;
        grid[x][y] = '0';
        
        invalidate(x - 1, y, grid);
        invalidate(x + 1, y, grid);
        invalidate(x, y - 1, grid);
        invalidate(x, y + 1, grid);
    } //invalidate
} //Sol