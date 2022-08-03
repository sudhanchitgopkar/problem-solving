class Solution {
     public int jump(int[] nums) {
         int timestep = 0;
         int l = 0, r = 0;
         int nextl = l+1, nextr = 0;
         
         while (r < nums.length-1) {
             for (int i = l; i <= r; i++) {
                 nextr = Math.max(nextr, i + nums[i]);
             } //for
             timestep++;
             r = nextr;
         } //while
         
         return timestep;
    } //jump
} //Sol