class Solution {
    int [][] grid;
    public int numMagicSquaresInside(int[][] grid) {
        this.grid = grid;
        int sol = 0;

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                boolean isMagic = isMagic(i, j);
                if (isMagic) ++sol;
            } //for
        } //for

        return sol;
    } //numMagic

    private boolean isMagic(int startRow, int startCol) {
        int target = 0;
        boolean [] seen = new boolean [10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] < 1 || 
                    grid[startRow + i][startCol + j] > 9 || 
                    seen[grid[startRow + i][startCol + j]]) return false;
                else seen[grid[startRow + i][startCol + j]] = true;
            } //for
        } //for

        
        //check 0th row
        for (int i = 0; i < 3; i++) {
            target += grid[startRow + i][startCol];
        } //for

        //checks 1st, 2nd row
        for (int row = 1; row < 3; row++) {
            int sum = 0;
            for (int col = 0; col < 3; col++) {
                sum += grid[startRow + row][startCol + col];
            } //for
            if (target != sum) {
                return false;
            } //if
        } //for

        //checks all cols
        for (int col = 0; col < 3; col++) {
            int sum = 0;
            for (int row = 0; row < 3; row++) {
                sum += grid[startRow + row][startCol + col];
            } //for
            if (target != sum) {
                return false;
            } //if
        } //for

        if ((grid[startRow][startCol] + 
            grid[startRow + 1][startCol + 1] + 
            grid[startRow + 2][startCol + 2]) != target) {
                return false;
        } //if

        if ((grid[startRow][startCol + 2] + 
            grid[startRow + 1][startCol + 1] + 
            grid[startRow + 2][startCol]) != target) {
                return false;
        }

        return true;
    } //isMagic
} //Sol