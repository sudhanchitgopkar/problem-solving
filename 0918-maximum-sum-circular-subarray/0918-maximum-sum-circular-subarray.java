class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, max = nums[0], lmax = nums[0], fwdsum = nums[0];
        int [] back = new int [n+1];
        int [] maxfwd = new int [n];

        back[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            back[i] = back[i + 1] + nums[i];
        } //for

        maxfwd[0] = nums[0];
        for (int i = 1; i < n; i++) {
            lmax = Math.max(lmax + nums[i],nums[i]);
            max = Math.max(lmax,max);
            fwdsum += nums[i];
            maxfwd[i] = Math.max(fwdsum,maxfwd[i-1]);
        } //for
       
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i] + back[i + 1] + maxfwd[i-1]);
        } //for

        return max;
    } //maxSubSumCirc
} //Sol
