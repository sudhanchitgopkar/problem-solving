class Solution {
    boolean [][] seen;
    public boolean exist(char[][] board, String word) {
        seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && check(board, word, i, j, 0)) {
                    return true;
                } //if
            } //for
        } //for
        return false;
    } //exist
    
    private boolean check (char [][] board, String word, int row, int col, int index) {
        if (index >= word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (seen[row][col] || board[row][col] != word.charAt(index)) return false;
        seen[row][col] = true;
        if (
            check(board,word,row-1,col,index+1) ||
            check(board,word,row+1,col,index+1) ||
            check(board,word,row,col-1,index+1) ||
            check(board,word,row,col+1,index+1)
           ) 
            return true;
        seen[row][col] = false;
        return false;
    } //check
}