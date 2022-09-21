class Solution {
    public int [] sumEvenAfterQueries(int[] nums, int[][] queries) {
        List <Integer> sol = new ArrayList <Integer> ();
        int esum = 0;
        
        for (int n : nums) if (n % 2 == 0) esum += n;
        
        for (int [] q : queries) {
            esum = nums[q[1]] % 2 == 0 ? esum - nums[q[1]] : esum;
            //int temp = nums[q[1]];
            nums[q[1]] += q[0];
            esum = nums[q[1]] % 2 == 0 ? esum + nums[q[1]] : esum;
            //if (temp % 2 == 0) esum -= temp;
            //if (nums[q[1]] % 2 == 0) esum += nums[q[1]];
            sol.add(esum);
        } //for
        
        return sol.stream().mapToInt(Integer::intValue).toArray();
    } //sumEven
} //Sol