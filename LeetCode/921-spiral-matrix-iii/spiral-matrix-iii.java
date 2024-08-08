class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int currRow, int currCol) {
        int [][] sol = new int [rows * cols][2];
        int [][] dirs = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int mag = 1, seen = 0, soli = 0;

        while (seen < (rows * cols)) {
            for (int [] dir : dirs) {
                int endRow = currRow + (dir[0] * mag);
                int endCol = currCol + (dir[1] * mag);

                while (currRow != endRow || currCol != endCol) {
                    if (in(currRow, currCol, rows, cols)) {
                        sol[soli++] = new int [] {currRow, currCol};
                        ++seen;
                    } //if
                    currRow += dir[0];
                    currCol += dir[1];
                } //while

                if (dir[0] != 0) ++mag;
            } //for
        } //while

        return sol;
    } //spiral

    private boolean in(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    } //in
} //Sol

/*
                for (int [] row : sol) System.out.println(Arrays.toString(row));

    1e
    1s
    2w
    2n
    3e
    2s
*/