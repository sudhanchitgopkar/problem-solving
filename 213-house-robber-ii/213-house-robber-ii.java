class Solution {
    public int rob(int[] nums) {
        int k = nums.length;
        int [] beg = new int [k];
        int [] end = new int [k];
        
        if (k == 1) return nums[0];
        else if (k == 2) return Math.max(nums[0],nums[1]);
        
        beg[0] = nums[0];
        beg[1] = Math.max(nums[0],nums[1]);
        
        end[k-1] = nums[k-1];
        end[k-2] = Math.max(nums[k-1], nums[k-2]);
        
        for (int i = 2; i < nums.length-1; i++)
            beg[i] = Math.max(nums[i] + beg[i-2], beg[i-1]);
        
        for (int i = k-3; i >= 1; i--)
            end[i] = Math.max(nums[i] + end[i+2], end[i+1]);
        
        return Math.max(Math.max(end[1],end[2]), Math.max(beg[k-2],beg[k-3]));
        
        
    }
}