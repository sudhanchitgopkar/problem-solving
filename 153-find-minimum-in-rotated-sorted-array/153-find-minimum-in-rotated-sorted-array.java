class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int min = nums[0];
        
        while (l <= r) {
            int m = l + ((r - l)/2);
            if (nums[m] < min) min = nums[m];
            
            if (nums[m] >= nums[0])
                l = m + 1;
            else
                r = m - 1;
        } //while
       
        return min;
    } //findMin
} //Solution