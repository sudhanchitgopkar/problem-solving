class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0, n = nums.length, r = n - 1;

        while (l <= r) {
            if (-1 * nums[l] == nums[r]) return nums[r];
            else if (-1 * nums[l] < nums[r]) --r;
            else ++l;
        } //while

        return -1;
    } //findMaxK
} //Sol