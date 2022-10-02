class Solution {
    public boolean equationsPossible(String[] eqns) {
        int[][] eq = new int[26][26], neq = new int[26][26];
        boolean sol = false;
        
        for (String s : eqns) {
            if (s.charAt(1) == '=') {
                char v1 = s.charAt(0);
                char v2 = s.charAt(3);
                //char v1 = s.charAt(0) < s.charAt(3) ? s.charAt(0) : s.charAt(3);
                //char v2 = s.charAt(0) > s.charAt(3) ? s.charAt(0) : s.charAt(3);
                if (v1 != v2) eq[v1-'a'][v2-'a'] = 1;
                if (v1 != v2) eq[v2-'a'][v1-'a'] = 1;
            } //if
        } //for
        
        for (String s : eqns) {
            if (s.charAt(1) == '!') {
                char v1 = s.charAt(0);
                char v2 = s.charAt(3);
                //char v1 = s.charAt(0) < s.charAt(3) ? s.charAt(0) : s.charAt(3);
                //char v2 = s.charAt(0) > s.charAt(3) ? s.charAt(0) : s.charAt(3);
                if (v1 != v2) {
                    neq[v1-'a'][v2-'a'] = 1;
                    neq[v2-'a'][v1-'a'] = 1;
                }
                else return false;
            } //if
        } //for
        
        for (int i = 0; i < 26; i++) {
            sol = true;
            for (int r = 0; r < 26; r++) {
                for (int c = 0; c < 26; c++) {
                    if (eq[r][c] >= neq[r][c] && neq[r][c] == 1) return false;
                    if (neq[r][c] == 1) sol = false;
                } //for
            } //for
            if (sol) return sol;
            eq = addMat(eq,mult(eq,eq));
        } //for
      
        return true;
    } //equationsPossible
    
    int[][] mult(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) 
            for (int col = 0; col < result[row].length; col++) 
                result[row][col] = multCell(firstMatrix, secondMatrix, row, col);

        return result;
    } //mult
    
    int multCell(int[][] firstMatrix, int[][] secondMatrix, int row, int col) {
        int cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) 
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        return cell;
    } //multCell
    
    int[][] addMat(int[][] m1, int [][] m2) {
        int[][] sol = new int [m1.length][m1[0].length];
        
        for (int i = 0; i < sol.length; i++) 
            for (int j = 0; j < sol[0].length; j++)
                sol[i][j] = m1[i][j] + m2[i][j];
        
        return sol;
    }
} //Sol