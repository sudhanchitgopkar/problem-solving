class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sol = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates,new ArrayList<Integer>(),0,target,0);
        return sol;
    } //combinationSum
    
    private void backtrack (int [] candidates, List<Integer> subset, int curr, int target, int sum) {
       
        if (curr >= candidates.length || sum > target || sol.size() >= 150) {
            return;
        } else if (sum == target) {
            sol.add(new ArrayList<Integer>(subset));
            return;
        } //if
        
        subset.add(candidates[curr]);
        backtrack(candidates,subset,curr,target,sum+candidates[curr]);
        //backtrack(candidates,subset,curr+1,target,sum+candidates[curr]);
        
        subset.remove(subset.size()-1);
        backtrack(candidates,subset,curr+1,target,sum);
        
    } //backtrack
} //Sol