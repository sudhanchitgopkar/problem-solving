class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int [] maxProfit = new int [nums.length+3]; 
        rob(nums,0,maxProfit);
        rob(nums,1,maxProfit);
        return Math.max(maxProfit[0],maxProfit[1]);
    } //rob
    
    private void rob(int [] nums, int curr, int [] seen) {
        if (curr >= nums.length) return;
        if (curr + 2 >= nums.length) {seen[curr] = nums[curr]; return;}
        if (seen[curr+2] == 0 && nums[curr+2] != 0) rob(nums,curr+2,seen);
        if (curr + 3 >= nums.length) {seen[curr] = nums[curr] + seen[curr+2]; return;}
        if (seen[curr+3] == 0 && nums[curr+3] != 0) rob(nums,curr+3,seen);
        seen[curr] = nums[curr] + Math.max(seen[curr+2],seen[curr+3]);
    } //rob
} //Solution
