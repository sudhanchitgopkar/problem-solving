class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet <String> seen = new HashSet <String> ();
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') continue;
                if (seen.contains("R" + r + "V" + board[r][c]) ||
                    seen.contains("C" + c + "V" + board[r][c]) ||
                    seen.contains("S" + r/3 + "," + c/3 + "V" + board[r][c]))
                        return false;
                seen.add("R" + r + "V" + board[r][c]);
                seen.add("C" + c + "V" + board[r][c]);
                seen.add("S" + r/3 +  "," + c/3 + "V" + board[r][c]);
            } //for
        } //for
       
        return true;
    } //isValidSudoku
} //Solution
