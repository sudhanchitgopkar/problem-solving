class Solution {
    public int islandPerimeter(int[][] grid) {
       int bds = 0;
        for (int r = 0; r < grid.length; r++) {
            int geo = 0;
            for (int c = 0; c < grid[0].length; c++) {
                if (geo != grid[r][c]) {
                    bds++;
                    geo = geo == 0 ? 1 : 0;
                }
            } // c
            if (geo == 1) bds++;
        } // r
        
        for (int r = 0; r < grid[0].length; r++) {
            int geo = 0;
            for (int c = 0; c < grid.length; c++) {
                if (geo != grid[c][r]) {
                    bds++;
                    geo = geo == 0 ? 1 : 0;
                }
            } // c
            if (geo == 1) bds++;
        } // r
        return bds;
    } //islandPerimeter
}
