class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        while (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            } //for
            --n;
        } //while

        return nums[0];
    } //triSum
} //Sol