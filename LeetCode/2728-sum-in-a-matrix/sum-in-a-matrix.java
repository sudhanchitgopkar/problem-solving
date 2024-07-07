class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length, sol = 0;

        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        } //for

        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < m; j++) {
                if (nums[j][i] > maxVal) {
                    maxVal = nums[j][i];
                } //if
            } //for
            sol += maxVal;
        } //for

        return sol;
    } //matrixSum
} //Sol