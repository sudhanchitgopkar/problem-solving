class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] l = new int [nums.length];
        int [] r = new int [nums.length];
        int [] sol = new int [nums.length];
        
        l[0] = nums[0];
        r[r.length-1] = nums[nums.length-1];
        
        for (int i = 1; i < l.length; i++)
            l[i] = l[i-1] * nums[i];
        
        for (int i = r.length-2; i >= 0; i--)
            r[i] = r[i+1] * nums[i];
        
        for (int i = 1; i < sol.length - 1; i++)
            sol[i] = l[i-1] * r[i+1];
        
        sol[0] = r[1];
        sol[sol.length-1] = l[l.length-2];
        
        return sol;
    } //productExcpetSelf
} //Solution