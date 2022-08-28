class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer> [] group = new List [groupSizes.length+1];
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>> ();
        
        for (int i = 0; i < groupSizes.length; i++) {
            if (group[groupSizes[i]] == null) {
                group[groupSizes[i]] = new ArrayList<Integer> ();
            } //if
            group[groupSizes[i]].add(i);
            if (group[groupSizes[i]].size() == groupSizes[i]) {
                sol.add(group[groupSizes[i]]);
                group[groupSizes[i]] = new ArrayList<Integer> ();
            } //if
        } //for
        
        return sol;
    } //group
} //Sol