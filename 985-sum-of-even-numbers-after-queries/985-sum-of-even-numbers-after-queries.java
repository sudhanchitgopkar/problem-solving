class Solution {
    public int [] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int [] sol = new int [queries.length];
        int solIndex = 0;
        int esum = 0;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                esum += num;
            }
        } //for
        
        
        for (int [] query : queries) {
            int val = query[0];
            int idx = query[1];
            if (nums[idx] % 2 == 0) {
                esum -= nums[idx];
            }
            nums[idx] += val;
            if (nums[idx] % 2 == 0) {
                esum += nums[idx];
            }
            sol[solIndex++] = esum;
        } //for
        
        return sol;
    } //sumEven
} //Sol