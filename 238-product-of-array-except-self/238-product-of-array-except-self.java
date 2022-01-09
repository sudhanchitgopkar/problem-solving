class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] pre = new int [nums.length];
        int [] post = new int [nums.length];
        int [] sol = new int [nums.length];
        
        pre[0] = nums[0];
        for (int i = 1; i < pre.length; i++) 
            pre[i] = nums[i] * pre[i-1];
        
        post[post.length-1] = nums[nums.length-1];
         for (int i = post.length-2; i >= 0; i--) 
            post[i] = nums[i] * post[i+1];
        
        sol[0] = post[1];
        sol[sol.length-1] = pre[post.length-2];
        for (int i = 1; i < post.length-1; i++)
            sol[i] = pre[i-1] * post[i+1];
        
        return sol;
    } //productExcpetSelf
} //Solution