class Solution {
    public int maxProduct(int[] nums) {    
    
        if (nums.length == 1)
            return nums[0];
            
        
        int lMin = nums[0], lMax = nums[0], max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        
            if (nums[i] == 0) {
                if (max < 0)
                    max = 0;
                if (i+1 < nums.length) {
                    lMin = 1;
                    lMax = 1;
                } //if  
            } else {

            if (lMax == 0)
                lMax = 1;
                
            int temp = lMin;
            lMin = Math.min(lMax*nums[i], Math.min(lMin * nums[i],nums[i]));
            lMax = Math.max(lMax*nums[i], Math.max(temp * nums[i],nums[i]));
                if (lMax > max)
                    max = lMax;
            }
            
            
        } //for
        if (lMax > max)
                    max = lMax;
        return max;
            
    } //maxProd
} //Solution