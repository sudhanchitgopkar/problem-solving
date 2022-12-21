class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + ((r-l)/2);
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = ++m;
            else r = --m;
        } //while

        return nums[l] < target ? ++l : l;
    } //searchInsert
} //Sol