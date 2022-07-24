class Solution {
    public int removeDuplicates(int[] nums) {
        int writeOver = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) nums[writeOver++] = nums[i];
        } //for
       
        return writeOver;
    } //removeDuplicates
} //Solution

/*
1 1 2
*/