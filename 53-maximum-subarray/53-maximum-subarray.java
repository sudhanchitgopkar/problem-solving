class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int lMax = nums[0], gMax = nums[0];
        int l = 0, r = 1;
        
        while (r < nums.length) {
            if (lMax + nums[r] > nums[r]) {
                lMax += nums[r++];
            } else {
                l = r;
                lMax = nums[r++];
            } //else
            
            gMax = lMax > gMax ? lMax : gMax;
        } //while
        
        return gMax;
    } //maxSubArr
} //Solution