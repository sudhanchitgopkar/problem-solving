class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int [][] sums = new int [n][n];

        for (int i = 0; i < n; i++) {
            sums[0][i] = nums[i];
        } //for

        for (int i = 0; i < n - 1; i++) {
            int idx = 0;
            for (int j = 0; j < n - i - 1; j++) {
                sums[i + 1][idx++] = (sums[i][j] + sums[i][j + 1]) % 10;
            } //for
        } //for

        return sums[n - 1][0];
    } //triSum
} //Sol