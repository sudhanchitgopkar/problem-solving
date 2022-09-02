class Solution {
    public int rob(int[] nums) {
        int k = nums.length;
        
        if (k == 1) return nums[0];
        if (k == 2) return Math.max(nums[0], nums[1]);
        
        int [] sol = new int [k];
        sol[k-1] = nums[k-1];
        sol[k-2] = Math.max(nums[k-1],nums[k-2]);
        
        for (int i = k-3; i >= 0; i--) {
            sol[i] = Math.max(nums[i] + sol[i+2], sol[i+1]);
        } //for
        
        return Math.max(sol[0], sol[1]);
    } //rob
} //Solution
