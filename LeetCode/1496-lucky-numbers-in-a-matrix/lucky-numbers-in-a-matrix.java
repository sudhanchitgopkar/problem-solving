class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int [] rowMins = new int [m];
        HashSet <Integer> colMaxs = new HashSet <> ();
        List <Integer> sol = new ArrayList <> ();
        
        //1. find the min of each row
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) min = matrix[i][j];
            } //for
            rowMins[i] = min;
        } //for

        //2. find the max of each col
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] > max) max = matrix[j][i];
            } //for
            colMaxs.add(max);
        } //for

        //3. find intersecting min/max's
        for (int i = 0; i < m; i++) {
            if (colMaxs.contains(rowMins[i])) sol.add(rowMins[i]);
        } //for

        return sol;
    } //luckyNums
} //Sol