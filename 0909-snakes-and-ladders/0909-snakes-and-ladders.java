class Solution {
    public int snakesAndLadders(int[][] board) {
        int sol = 1, n = board.length, m = board[0].length;
        Queue <Integer> q = new LinkedList <> (); 
        boolean [] seen = new boolean [n * m];

        q.offer(1);
        seen[1] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int roll = 1; roll <= 6; roll++) {
                    if (curr + roll > n * m) break;
                    int next = getPos(curr + roll, board) == -1 ? curr + roll : getPos(curr + roll, board);
                    if (next == n * m) return sol;
                    if (!seen[next]) {
                        q.offer(next);
                        seen[next] = true;
                    } //if
                } //for
            } //for
            sol++;
        } //while
        
        return -1;
    } //snakesAndLadders

    private int getPos (int n, int [][] board) {
        int row = board.length - ((n - 1) / board[0].length) - 1, col;
        if ((board.length - row) % 2 != 0) col = n - ((board.length - (row + 1)) * board[0].length + 1);
        else col = ((board.length - row) * board[0].length) - n;
        return board[row][col];
    } //getInd
} //Sol