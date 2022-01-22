class Solution {
    public int maxSubArray(int[] nums) {
        int lMax = nums[0], gMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lMax + nums[i])
                lMax = nums[i];
            else lMax += nums[i];
            gMax = lMax > gMax ? lMax : gMax;
        } //for
        return gMax;
    } //maxSubArr
} //Solution