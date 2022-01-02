class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int [] sol = new int [nums.length];
        int r = nums.length - 1;
        int l = 0;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[l] * nums[l] > nums[r] * nums[r]) {
                sol[i] = nums[l] * nums[l];
                l++;
            } else {
                sol[i] = nums[r] * nums[r];
                r--;
            } //if
        } //for
        
        return sol;
    } //sortedSquares
} //Solution