class Solution {
    int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
       Queue <Tuple> q = new LinkedList <> ();
       int dist = 0, n = grid.length;
       boolean [][] seen = new boolean [n][n];


       //find first island O(n^2)
       boolean foundFirst = false;
       for (int i = 0; !foundFirst && i < n; i++) {
           for (int j = 0; !foundFirst && j < n; j++) {
               if (!foundFirst && grid[i][j] == 1) {
                   makeFirstIsland(i, j, q, seen, grid);
                   foundFirst = true;
               } //if
           } //for
       } //for

       //bfs to next island
       while (!q.isEmpty()) {
           int size = q.size();
           for (int i = 0; i < size; i++) {
               Tuple coords = q.poll();
               int x = coords.x, y = coords.y;

               for (int [] dir : dirs) {
                   int newx = x + dir[0], newy = y + dir[1];
                   if (newx < 0 || newx >= n || newy < 0 || newy >= n) continue;
                   if (seen[newx][newy]) continue;
                   if (grid[newx][newy] == 1) return dist;
                   q.offer(new Tuple(newx, newy));
                   seen[newx][newy] = true;
               } //for

           } //for
           ++dist;
       } //while

       //return distance
        return -1; //should be unreachable
    } //shortestBridge

    public void makeFirstIsland(int i, int j, Queue <Tuple> q, boolean [][] seen, int [][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) return;
        if (seen[i][j] || grid[i][j] == 0) return;

        q.offer(new Tuple(i, j));
        seen[i][j] = true;

        for (int [] dir : dirs) makeFirstIsland(i + dir[0], j + dir[1], q, seen, grid);

    } //makeFirstIsland
} //Sol

public class Tuple {
    protected int x, y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    } //constructor
} //class