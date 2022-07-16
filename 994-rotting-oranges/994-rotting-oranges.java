class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <int []> rotting = new LinkedList<int []> ();
        int min = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotting.offer(new int [] {i,j});
                } //if
            } //for
        } //for
        
        
        while (!rotting.isEmpty()) {
            min++;
            int breadth = rotting.size();
            for (int orange = 0; orange < breadth; orange++) {
                int [] curr = rotting.poll();
                int i = curr[0], j = curr[1];
                if (i-1 >= 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    rotting.offer(new int [] {i-1,j});
                } //if
                if (i+1 < grid.length && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    rotting.offer(new int [] {i+1,j});
                } //if
                if (j-1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    rotting.offer(new int [] {i,j-1});
                }
                if (j+1 < grid[0].length && grid[i][j+1] == 1) {
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
    
} //Sol