class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        while (l <= r) {
            int m = l + ((r-l)/2);
            System.out.println(nums[m]);
            if (nums[m] == target) {
                return m;
            } 
            //l-sorted
            if (nums[m] >= nums[0]) {
                if (nums[m] > target) {
                    if (nums[0] > target) l = m + 1;
                    else r = m - 1;
                } else {
                    l = m + 1;
                } //if
            } else {
                if (nums[m] > target) {
                    r = m - 1;
                } else {
                    if (nums[nums.length-1] >= target) l = m + 1;
                    else r = m - 1;
                } //if
            } //else
        } //while
       
        return -1;
    } //search
} //solution
