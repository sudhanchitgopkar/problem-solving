class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <int []> rotting = new LinkedList<int []> ();
        int min = 0;
        
        for (int i = 0; i < grid.length; i++) 
            for (int j = 0; j < grid[0].length; j++) 
                if (grid[i][j] == 2) 
                    rotting.offer(new int [] {i,j});
       
        while (!rotting.isEmpty()) {
            min++;
            int breadth = rotting.size();
            for (int orange = 0; orange < breadth; orange++) {
                int [] curr = rotting.poll();
                int i = curr[0], j = curr[1];
                if (isFresh(grid,i-1,j)) {
                    grid[i-1][j] = 2;
                    rotting.offer(new int [] {i-1,j});
                } //if
                if (isFresh(grid,i+1,j)) {
                    grid[i+1][j] = 2;
                    rotting.offer(new int [] {i+1,j});
                } //if
                if (isFresh(grid,i,j-1)) {
                    grid[i][j-1] = 2;
                    rotting.offer(new int [] {i,j-1});
                }
                if (isFresh(grid,i,j+1)) {
                    grid[i][j+1] = 2;
                    rotting.offer(new int [] {i,j+1});
                } //if
            } //for
        } //while
        
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) return -1;
        
        return Math.max(0,--min);
    } //orangesRotting
    
     public boolean isFresh (int [][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        if (grid[i][j] == 1) return true;
        else return false;
    } //isFresh    
} //Sol