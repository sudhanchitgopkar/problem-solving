class Solution {
    List<List<Integer>> subsets;
    
    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<List<Integer>> ();
        backtrack(nums, subsets, new ArrayList<Integer>(),0);
        return subsets;
        //return subsets;
    } //subsets
    
    private void backtrack (int [] nums, List<List<Integer>> subsets, List<Integer> subset, int num) {
        if (num >= nums.length) {
            subsets.add(new ArrayList<Integer>(subset));
            return;
        } //if
        
        subset.add(nums[num]);
        backtrack(nums,subsets,subset,num+1);
        
        subset.remove(subset.size()-1);
        backtrack(nums,subsets,subset,num+1);        
    } //backtrack
} //Sol