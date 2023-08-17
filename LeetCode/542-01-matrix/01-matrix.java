class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int m = mat.length, n = mat[0].length, dist = 0;
       int [][] sol = new int [m][n];
       boolean [][] seen = new boolean [m][n];
       int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

       Queue <int []> q = new LinkedList <> ();

       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (mat[i][j] == 0) {
                   q.offer(new int [] {i, j});
                   seen[i][j] = true;
               } //if
           } //for
       } //for

       while (!q.isEmpty()) {
           int size = q.size();
           for (int i = 0; i < size; i++) {
               int [] curr = q.poll();
               int x = curr[0], y = curr[1];

               sol[x][y] = dist;

               for (int [] dir : dirs) {
                   int nx = x + dir[0], ny = y + dir[1];
                   if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                   if (seen[nx][ny]) continue;
                   seen[nx][ny] = true;
                   q.offer(new int [] {nx, ny});
               } //for
           } //for
           ++dist;
       } //while

       return sol;
    } //updateMat
} //Sol

/*
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair <int, int> curr = q.front();
                q.pop();
                cout << curr.first << "\t" << curr.second << "\n";
                sol[curr.first][curr.second] = dist;

                for (vector<int> dir : dirs) {
                    int nextX = curr.first + dir[0], nextY = curr.second + dir[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
                    if (seen[nextX][nextY]) continue;
                    seen[nextX][nextY] = true;
                    q.push(pair(nextX, nextY));
                } //for
            } //for
            ++dist;
        } //while

        return sol;
    } //updateMatrix
};
*/