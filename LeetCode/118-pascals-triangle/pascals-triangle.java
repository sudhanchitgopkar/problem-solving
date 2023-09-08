class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> sol = new ArrayList <> ();
       sol.add(new ArrayList <Integer> (Arrays.asList(1)));
       
       for (int i = 1; i < numRows; i++) {
           List<Integer> curr = new ArrayList <> ();
           curr.add(1);
           for (int j = 0; j < sol.get(i - 1).size() - 1; j++) {
               curr.add(sol.get(i - 1).get(j) + sol.get(i - 1).get(j + 1));
           } //for
           curr.add(1);
           sol.add(curr);
       } //for

       return sol;
    } //gen
} //Sol