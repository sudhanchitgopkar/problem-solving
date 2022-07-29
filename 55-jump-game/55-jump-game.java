class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        
        for (int i = goal; i >= 0; i--)
            if (i + nums[i] >= goal) goal = i;
        
        return goal == 0;
    } //canJump
} //Solution

/*
public boolean canJump(int[] nums) {
        boolean [] seen = new boolean [nums.length]; 
        for (int i = 0; i < seen.length; i++) seen[i] = true; 
        return jump(nums,0,seen);
    } //canJump
    
    public boolean jump (int [] nums, int curr, boolean [] seen) {
        if (curr >= nums.length-1 || nums[curr] + curr >= nums.length-1) return true;
        if (nums[curr] == 0) return false;
        
        for (int i = nums[curr]; i > 0; i--) {
            if (seen[curr + i] != false) {
                if (jump(nums,curr + i,seen)) return true;
                else seen[curr + i] = false;
            } //if
        } //for
        
        seen[curr] = false;
        return false;
    } //jump
*/