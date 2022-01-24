class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] l = new int [nums.length];
        int [] r = new int [nums.length];
        int [] sol = new int [nums.length];
        
        l[0] = nums[0];
        r[nums.length-1] = nums[nums.length-1];
        
        for (int i = 1; i < nums.length; i++) 
            l[i] = l[i-1] * nums[i];   
        for (int i = nums.length-2; i >= 0; i--)
            r[i] = r[i+1] * nums[i];
        
        sol[0]  = r[1]; sol[nums.length-1] = l[nums.length-2];
        
        for (int i = 1; i < nums.length-1; i++) {
            sol[i] = l[i-1] * r[i+1];
        } //for
        
        return sol;
    } //productExcpetSelf
} //Solution