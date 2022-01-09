class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] sol = new int [nums.length];
        int [] pre = new int [nums.length];
        int [] post = new int [nums.length];
        
        pre[0] = nums[0];
        post[post.length-1] = nums[nums.length-1];
        
        for (int i = 1; i < pre.length; i++) 
            pre[i] = pre[i-1]*nums[i];
        
        for (int i = post.length-2; i >= 0; i--) 
            post[i] = post[i+1] * nums[i];
        
        for (int i = 0; i< sol.length; i++) {
            if (i == 0)
                sol[0] = post[1];
            else if (i == sol.length-1)
                sol[i] = pre[i-1];
            else
                sol[i] = pre[i-1] * post[i+1];
        } //for
        
        
        for (int i:pre)
            System.out.print(i + " ");
        System.out.println();
        for (int i:post)
            System.out.print(i + " ");
            return sol;
    } //productExcpetSelf
} //Solution