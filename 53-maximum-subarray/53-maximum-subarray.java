class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int l = 0, r = 1, gSum = nums[0], lSum = nums[0];
        
        while (r < nums.length) {
            if (lSum + nums[r] > nums[r]) {lSum += nums[r++];}
            else {l = r; lSum = nums[r++];}
            gSum = lSum > gSum ? lSum : gSum;
        } //while
        
        return gSum;
    } //maxSubArr
} //Solution