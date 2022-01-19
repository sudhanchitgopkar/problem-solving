class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1, mid = (l+r)/2;
        
        if (target > nums[nums.length-1]) return nums.length;
        
        while (r >= l) {
            mid = (l+r)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid+1;
            else 
                r = mid-1;
        } //while
        
        return l;
        
    } //searchInsert
} //Solution