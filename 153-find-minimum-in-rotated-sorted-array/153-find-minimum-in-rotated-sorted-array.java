class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length-1, m = (r-l)/2;
        
        //unrotated
        if (nums[r] > nums[l]) 
            return nums[l];
        //min in middle
        else if (nums.length >= 3 && nums[m-1] > nums[m] && nums[m+1] > nums[m])
            return nums[m];
        
        while (l <= r) {
            m = (r+l)/2;
            if (m != 0 && nums[m] < nums[m-1])
                return nums[m];
            else if (nums[l] > nums[m]) 
                r = m-1;
            else if (nums[r] < nums[m]) 
                l = m+1;
            else
                return nums[l];
        } //while
        
        return nums[l];
    } //findMin
} //Solution