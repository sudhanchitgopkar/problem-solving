class Solution {
    public void rotate(int[] nums, int k) {
        int [] copy = new int [nums.length];
        //copy
        for (int i = 0; i < nums.length; i++)
            copy[i] = nums[i];
        
        //rotate
        for (int i = 0; i < nums.length; i++) {
            nums[(i+k)%nums.length] = copy[i];
        } //for
    } //rotate
} //Solution
