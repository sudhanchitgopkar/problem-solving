class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int [] sol = new int [] {-1,-1};
        if (nums.length == 0) return sol;
        
        while (l <= r) {
            int m = l + ((r-l)/2);
            if (nums[m] < target) {
                l = ++m;
            } else if (nums[m] > target) {
                r = --m;
            } else {
                sol[0] = m;
                r = --m;
            } //if
        } //while

        r = nums.length-1; 
        while (l <= r) {
            int m = l + ((r-l)/2);
            if (nums[m] < target) {
                l = ++m;
            } else if (nums[m] > target) {
                r = --m;
            } else {
                sol[1] = m;
                l = ++m;
            } //if
        } //while

        return sol;
    } //searchRange
} //Sol