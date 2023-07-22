class Solution {
    public double knightProbability(int n, int k, int row, int col) {
       double [][][] dp = new double [k + 1][n][n];
       int [][] dirs = {{2,1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
       dp[k][row][col] = 1.0;
       double sol = 0.0;

       while (k > 0) {
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   if (dp[k][i][j] != 0) {
                    for (int [] dir : dirs) {
                       int nextRow = i + dir[0], nextCol = j + dir[1];
                       if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
                       dp[k - 1][nextRow][nextCol] += dp[k][i][j] * 1/8;
                    } //for
                   } //if
               } //for
           } //for
           --k;
       } //while


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol += dp[0][i][j];
            } //for
        } //for

        return sol;
    } //knightP
} //Sol


/*
class Solution {
public:
    double knightProbability(int n, int k, int row, int col) {
        vector<vector<vector<double>>> dp (k + 1, vector<vector<double>> (n, vector<double> (n)));
        vector<vector<int>> dirs {{2,1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
        dp[k][row][col] = 1.0;
        double sol = 0.0;

        while (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[k][i][j] != 0) {
                        for (vector<int> dir : dirs) {
                            int nextRow = i + dir[0], nextCol = j + dir[1];
                            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
                            dp[k - 1][nextRow][nextCol] += dp[k][i][j] * 1/8;
                        } //for
                    } //if
                } //for
            } //for
            --k;
        } //while

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol += dp[0][i][j];
            } //for
        } //for

        return sol;
    } //knightProb
};
*/