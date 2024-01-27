class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int l = 0, r = 1, n = nums.length;
        int sol = 1;

        while (r < n) {
            if (nums[r] > nums[r - 1]) {
                ++r;
            } else {
                sol = Math.max(sol, r - l);
                l = r++;
            } //if
        } //while
        
        return Math.max(sol, r - l);
    } //LICS
} //Sol