class Solution {
    List<List<Integer>> sol;
    List<Integer> vals;
    HashSet <List<Integer>> seen;

    public List<List<Integer>> findSubsequences(int[] nums) {
        sol = new ArrayList<>();
        vals = Arrays.stream(nums).boxed().collect(Collectors.toList());
        seen = new HashSet <> ();

        for (int i = 0; i < nums.length; i++) {
            List <Integer> subseq = new ArrayList<> ();
            subseq.add(nums[i]);
            getSubs(subseq,i);
        } //for

        return sol;
    } //findSub

    private void getSubs(List<Integer> n, int i) {
        if (n.size() >= 2 && !seen.contains(n)) {
            List <Integer> solSub = new ArrayList <> (n);
            sol.add(solSub);
            seen.add(solSub);
        } //if 

        for (int j = i + 1; j < vals.size(); j++) {
            if (vals.get(j) >= vals.get(i)) {
                n.add(vals.get(j));
                getSubs(n,j);
                n.remove(n.size()-1);
            } //if
        } //for

    } //getSubs
} //Sol