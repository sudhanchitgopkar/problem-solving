class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] s = new int [nums.length];
        int l = 0, r = nums.length-1;
        
        for (int i = s.length-1; i >= 0; i--) {
            if (nums[r]*nums[r] > nums[l]*nums[l])
                s[i] = nums[r]*nums[r--];
            else s[i] = nums[l]*nums[l++];
        } //for
        
        return s;
    } //sortedSquares
} //Solution