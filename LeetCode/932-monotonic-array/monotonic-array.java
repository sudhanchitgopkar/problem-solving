class Solution {
    public boolean isMonotonic(int[] nums) {
       int inc = 0;

       for (int i = 1; i < nums.length; i++) {
           if (nums[i] < nums[i - 1]) {
               if (inc == 1) return false;
               if (inc == 0) inc = -1;
           } else if (nums[i] > nums[i - 1]) {
               if (inc == -1) return false;
               if (inc == 0) inc = 1;
           } //if
       }  //for
       
       return true;
    } //isMonotonic
} //Sol