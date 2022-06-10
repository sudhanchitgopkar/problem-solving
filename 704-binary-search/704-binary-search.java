class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        while (l <= r) {
            int m = (r+l)/2;
            if (nums[m] < target) l = m + 1;
            else if (nums[m] > target) r = m - 1;
            else return m;
        } //while
        
        return -1;
    } //search
} //Sol