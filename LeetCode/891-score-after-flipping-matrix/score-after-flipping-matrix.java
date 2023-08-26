class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] != 1) {
                flipRow(i, grid);
            } //if
        } //for

        for (int i = 0; i < cols; i++) {
            int num1s = 0;
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 1) {
                    num1s++;
                } //if
            } //for
            if (num1s <= rows/2) {
                flipCol(i, grid);
            } //if
        } //for

        //printGrid(grid);
        return getScore(grid);
    } //matrixScore

    private void flipRow(int row, int [][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            grid[row][i] = grid[row][i] == 0 ? 1 : 0;
        } //for
    } //flipRow

    private void flipCol(int col, int [][] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        } //for
    } //flipRow

    private int getScore(int [][] grid) {
        int score = 0;

        for (int i = 0; i < grid.length; i++) {
            int rowScore = 0, power = 1;

            for (int j = grid[0].length - 1; j >= 0; j--) {
                rowScore += grid[i][j] * power;
                power *= 2;
            } //for

            score += rowScore;
        } //for

        return score;
    } //getScore

    private void printGrid(int [][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            } //for
            System.out.println();
        } //for
    } //printGrid
} //Sol