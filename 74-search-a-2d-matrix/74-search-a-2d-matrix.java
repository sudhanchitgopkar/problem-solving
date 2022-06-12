class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length-1;
        int rowToSearch = -1;
        
        while (l <= r) {
            int m = l + ((r-l)/2);
            if (matrix[m][0] <= target && matrix[m][matrix[0].length-1] >= target) {
                rowToSearch = m;
                break;
            } else if (matrix[m][0] > target) {
                r = m - 1;
            } else l = m + 1;
        } //while
        
        if (rowToSearch == -1) return false;
    
        l = 0; 
        r = matrix[0].length-1;
        
        while (l <= r) {
            int m = l + ((r-l)/2);
            if (matrix[rowToSearch][m] == target) {
                return true;
            } else if (matrix[rowToSearch][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            } //if
        } //while
        
        return (matrix[rowToSearch][r] == target);
    } //searchMatrix
} //Sol