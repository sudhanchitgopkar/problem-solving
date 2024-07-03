class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;

        if (n <= 4) return 0;
        Arrays.sort(nums);
        return backtrack(nums, 0, n - 1, 0);
    } //minDiff

    private int backtrack(int [] nums, int l, int r, int moves) {
        if (moves == 3) return nums[r] - nums[l];
        
        int sol = Integer.MAX_VALUE;
        if (l < nums.length - 2) sol = backtrack(nums, l + 1, r, moves + 1);
        if (r > 0) sol = Math.min(sol, backtrack(nums, l, r - 1, moves + 1));
        return sol;
    } //backtrack
} //Sol
