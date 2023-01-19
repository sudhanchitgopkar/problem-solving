class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, sum = 0, sol = 0;
        int [] modFreq = new int [k];
        modFreq[0] = 1;

        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) sum += k;
            sol += modFreq[sum]++;
        } //for

        return sol;
    } //divK
} //Sol