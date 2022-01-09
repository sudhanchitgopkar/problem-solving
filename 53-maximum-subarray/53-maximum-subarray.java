class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return nums[0];
        
        int l = 0, r = 1, lmax = nums[0], gmax = nums[0];
        
        while (r < nums.length) {
            if (nums[r] + lmax > nums[r])
                lmax += nums[r++];
            else {
                l = r++;
                lmax = nums[l];
            } //if
            
            if (lmax > gmax)
                gmax = lmax;
        } //while
        
        if (lmax > gmax)
            return lmax;
        else
            return gmax;
        
    } //maxSubArr
} //Solution