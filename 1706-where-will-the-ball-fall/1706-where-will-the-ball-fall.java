class Solution {
    public int[] findBall(int[][] grid) {
        int [] sol = new int [grid[0].length];
        for (int i = 0; i < sol.length; i++) sol[i] = getPos(grid,0,i);
        return sol;
    } //findBall
    
    private int getPos(int [][] grid, int row, int col) {
        if (row >= grid.length) return col >= 0 && col < grid[0].length ? col : -1;
        if (col < 0 || col >= grid[0].length) return -1;
        
        if (grid[row][col] == 1 && col + 1 < grid[0].length && grid[row][col+1] == -1) {return -1;}
        if (grid[row][col] == -1 && col - 1 >= 0 && grid[row][col-1] == 1) {return -1;}
        
        if (grid[row][col] == 1) return getPos(grid,row+1,col+1);
        else return getPos(grid,row+1,col-1);
    } //getPos
} //Sol