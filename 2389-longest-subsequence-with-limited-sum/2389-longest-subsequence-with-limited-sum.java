class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i-1];
        int [] sol = new int [queries.length];
        int i = 0;

        for (int query : queries) 
            sol[i++] = bsearch(nums,query);

        return sol;
    } //answerQ

    private int bsearch (int [] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r-l)/2);
            if (nums[m] > target) r = --m;
            else if (nums[m] <= target) l = ++m;
        } //while

        return l; 
    } //bsearch

} //Sol