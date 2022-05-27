class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet <String> seen = new HashSet <String> ();
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] != '.') {
                    if (seen.contains("row" + r + board[r][c]) || 
                    seen.contains("col" + c + board[r][c]) ||
                    seen.contains("sq" + r/3 + "," + c/3 + board[r][c])) {
                        return false;
                    } else {
                        seen.add("row" + r + board[r][c]);
                        seen.add("col" + c + board[r][c]);
                        seen.add("sq" + r/3 + "," + c/3 + board[r][c]);
                        } //if
                } //if
                } //for
        } //for
        
        return true;
    } //isValidSudoku
} //Solution
