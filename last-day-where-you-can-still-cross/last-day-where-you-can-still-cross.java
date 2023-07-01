class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1, r = cells.length - 1, sol = 0;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (canCross(cells, m, row, col)) {
                sol = m > sol ? m : sol;
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while
        
        return sol;
    } //latestDay

    private boolean canCross(int [][] cells, int mid, int m, int n) {
        int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int [][] water = new int [m][n];
        Queue <int []> q = new LinkedList <> ();
        
        //fill with water
        for (int i = 0; i < mid; i++) {
            water[cells[i][0] - 1][cells[i][1] - 1] = 1;
        } //for

        //add all poss start pos
        for (int i = 0; i < n; i++) {
            if (water[0][i] == 0) {
                water[0][i] = -1;
                q.offer(new int [] {0, i});
            } //if
        } //for
        
        //bfs to find path
        while (!q.isEmpty()) {
            int [] curr = q.poll();
            int x = curr[0], y = curr[1];

            if (x == m - 1) return true;

            for (int [] dir : dirs) {
                int newx = x + dir[0], newy = y + dir[1];

                if (newx < 0 || newx >= m || newy < 0 || newy >= n) {
                    continue;
                } else if (water[newx][newy] != 0) {
                    continue;
                } else {
                    water[newx][newy] = -1;
                    q.offer(new int [] {newx, newy});
                } //if             
            } //for
        } //while

        return false;
    } //canCross
} //Sol