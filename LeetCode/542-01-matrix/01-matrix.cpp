class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size(), n = mat[0].size(), dist = 0;
        vector<vector<int>> sol (m, vector<int> (n));
        vector<vector<bool>> seen (m, vector<bool> (n));

        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue <pair<int, int>> q;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.push(pair(i, j));
                    seen[i][j] = true;
                } //if
            } //for
        } //for

        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair <int, int> curr = q.front();
                q.pop();
                
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