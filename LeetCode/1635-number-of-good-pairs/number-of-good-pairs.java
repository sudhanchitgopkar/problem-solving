class Solution {
    public int numIdenticalPairs(int[] nums) {
       int sol = 0;
       int [] buckets = new int [101];

       for (int num : nums) {
           buckets[num]++;
       } //for
       
       for (int i = 0; i < nums.length; i++) {
           if (buckets[nums[i]] > 0) {
                sol += --buckets[nums[i]];
           } //if
       } //for

       return sol;
    } //numIdentical
} //Sol