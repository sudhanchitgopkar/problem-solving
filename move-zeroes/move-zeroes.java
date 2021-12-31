class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1)
            return;
        
        int curr = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[curr++] = nums[i];
        } //for
        
        while (curr < nums.length) {
            nums[curr++] = 0;
        } //while
        
    } //moveZeroes
} //solution