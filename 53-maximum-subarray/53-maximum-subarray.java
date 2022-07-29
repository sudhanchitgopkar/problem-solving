class Solution {
    public int maxSubArray(int[] nums) {
        int gMax = nums[0], lMax = 0;
        
        for (int num : nums) {
            lMax = Math.max(num,lMax+num);    
            gMax = Math.max(gMax, lMax);
        } //for
        
        return gMax;
    } //maxSubArr
} //Solution