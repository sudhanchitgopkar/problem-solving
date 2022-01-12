class Solution {
    public int maxProduct(int[] nums) {    
        int lMin = nums[0], lMax = nums[0], gMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == 0) {
                lMin = nums[i];
                lMax = nums[i];  
            } else {
                int temp = lMin;
                lMin = Math.min(Math.min(lMin*nums[i],lMax*nums[i]),nums[i]);
                lMax = Math.max(Math.max(lMax*nums[i],temp*nums[i]),nums[i]);
            } //if
            
            if (lMax > gMax)
                gMax = lMax;
        } //for
        
        return gMax;
    } //maxProd
} //Solution