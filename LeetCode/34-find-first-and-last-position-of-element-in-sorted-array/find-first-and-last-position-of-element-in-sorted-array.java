class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int [] {findFirst(nums, target), findLast(nums, target)};
    } //searchRange

    private int findFirst (int [] nums, int target) {
        int l = 0, r = nums.length - 1, sol = -1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] == target) {
                sol = m;
                r = --m;
            } else if (nums[m] < target) {
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while

        return sol;
    } //findFirst

    private int findLast (int [] nums, int target) {
        int l = 0, r = nums.length - 1, sol = -1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] == target) {
                sol = m;
                l = ++m;
            } else if (nums[m] < target) {
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while

        return sol;
    } //findFirst
} //Sol