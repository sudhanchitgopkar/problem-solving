class Solution {
    public int maxProduct(int[] nums) {
        
        boolean flag = false;
        if (nums.length == 1)
            return nums[0];
        if (nums[0] == 0)
            flag = true;
            
        
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

/*
 if (nums[i] == 0) {
                if (lMax < 0)
                    lMax = 0;
                if (lMax > max)
                    max = lMax;
                if (i+1 < nums.length) {
                    lMin = nums[i+1]; 
                    lMax = nums[i+1];
                } else
                    return max;
            
            */
/*
int numNeg = 0, lMax = 1, gMax = 0, totalProd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numNeg = 0;
                lMax = 1;
                totalProd = 1;
                if (lMax > gMax)
                    gMax = lMax;
            } //if
            
            totalProd *= nums[i];
            
            if (nums[i] < 0)
                numNeg++;
            if (numNeg % 2 == 0)
                lMax = totalProd;
            
            
            
            
        } //for
        */