class Solution {
    public int [] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int [] sol = new int [queries.length];
        int esum = 0, i = 0;
        
        for (int n : nums) if (n % 2 == 0) esum += n;
        
        for (int [] q : queries) {
            if (nums[q[1]] % 2 == 0) esum -= nums[q[1]];
            //esum = nums[q[1]] % 2 == 0 ? esum - nums[q[1]] : esum;
            nums[q[1]] += q[0];
            if (nums[q[1]] % 2 == 0) esum += nums[q[1]];
            //esum = nums[q[1]] % 2 == 0 ? esum + nums[q[1]] : esum;
            sol[i++] = esum;
        } //for
        
        return sol;
    } //sumEven
} //Sol