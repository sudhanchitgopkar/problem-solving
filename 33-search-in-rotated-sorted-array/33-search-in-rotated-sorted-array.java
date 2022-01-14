class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) if (nums[0] == target) return 0; else return -1;
        int l = 0, r = nums.length-1, m = (l+r)/2;
        
        while (l <= r) {
            m = (l+r)/2;
    
            if (nums[m] == target)
                return m;
            else if (nums[l] <= nums[m] && nums[l] <= target && nums[m] >= target)
                r = m-1;
            else if (nums[l] <= nums[m])
                l = m+1;
            else if (nums[m] <= nums[r] && nums[m] <= target && nums[r] >= target)
                l = m+1;
            else
                r = m-1;
        } //while
        
        return -1;
    } //search
} //solution