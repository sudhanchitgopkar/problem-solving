class Solution {
    List<List<Integer>> sol;
    int t;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sol = new ArrayList<List<Integer>>();
        t = target;
        backtrack(candidates,new ArrayList<Integer>(),0,0);
        return sol;
    } //combinationSum
    
    private void backtrack (int [] candidates, List<Integer> subset, int curr, int sum) {
       
        if (curr >= candidates.length || sum > t || sol.size() >= 150) {
            return;
        } else if (sum == t) {
            sol.add(new ArrayList<Integer>(subset));
            return;
        } //if
        
        subset.add(candidates[curr]);
        backtrack(candidates,subset,curr,sum+candidates[curr]);
        
        subset.remove(subset.size()-1);
        backtrack(candidates,subset,curr+1,sum);
        
    } //backtrack
} //Sol