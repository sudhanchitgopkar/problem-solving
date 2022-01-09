class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int l = 0;
        int r = 1;
        int lMax = nums[0]; int gMax = nums[0];
        
        while (r < nums.length) {
            if (lMax > gMax)
                gMax = lMax;
            if (nums[r] + lMax > nums[r]) {
                lMax += nums[r];
                r++;
            } else {
                lMax = nums[r];
                l=r;
                r++;
            }
        } //while
        
         if (lMax > gMax)
                gMax = lMax;
            
        return gMax;
        
    } //maxSubArr
} //Solution