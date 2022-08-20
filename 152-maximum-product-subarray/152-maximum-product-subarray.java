class Solution {
    public int maxProduct(int[] nums) { 
        int gMax = nums[0];
        int lMax = nums[0], lMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = lMax;
            lMax = Math.max(nums[i],Math.max(lMax*nums[i],lMin*nums[i]));
            lMin = Math.min(nums[i],Math.min(lMin*nums[i],temp*nums[i]));
            gMax = Math.max(gMax,lMax);
        } //for
        
        return gMax;
    } //maxProd
} //Solution