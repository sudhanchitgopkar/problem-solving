class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, n = nums.length, 
            used = 0, sol = 0;

        while (r < n) {
            if (nums[r] == 0 && used == 1) {
                if (r - l > sol) sol = r - l;
                while (used == 1) {
                    if (nums[l++] == 0) used--;
                } //while
            } else if (nums[r++] == 0) used = 1;
        } //while

        return Math.max(r - l, sol) - 1;
    } //longestSubArr
} //Sol