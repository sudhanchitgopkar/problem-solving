class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, sol = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && 
                    sumCol(mat, j) + sumRow(mat, i) == 2) ++sol;
            } //for
        } //for

        return sol;
    } //numSpecial

    private int sumCol (int [][] mat, int col) {
        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            sum += mat[row][col];
        } //for 
        return sum;
    } //sumCol

    private int sumRow (int [][] mat, int row) {
        int sum = 0;
        for (int col = 0; col < mat[0].length; col++) {
            sum += mat[row][col];
        } //for 
        return sum;
    } //sumCol
} //Sol