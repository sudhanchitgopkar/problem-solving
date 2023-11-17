class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length, sol = 0;
        Arrays.sort(nums);

        for (int i = 0; i <= n/2; i++) {
            sol = Math.max(sol, nums[i] + nums[n - i - 1]);
        } //for

        return sol;
    } //minPairSum
} //Sol