class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int [] freq = new int [nums.length+1];

        for (int n : nums)
            freq[n]++;
        
        for (int i = 0; i < freq.length; i++)
            if (freq[i] == 0) return i;
        
        return -1;
    } //missingNumber
} //Solution