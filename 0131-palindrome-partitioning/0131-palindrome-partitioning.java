class Solution {
    List<List<String>> sol = new ArrayList <> ();
    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<String> (), s);
        return sol;
    } //partition

    private void backtrack (List<String> partitions, String s) {
        if (s.length() == 0) sol.add(new ArrayList<String> (partitions));
        for (int i = 1; i <= s.length(); i++) {
            String curr = s.substring(0,i);
            if (isPal(curr)) {
                partitions.add(curr);
                backtrack(new ArrayList<String> (partitions), s.substring(i));
                partitions.remove(partitions.size()-1);
            } //if
        } //for
    } //backtrack

    private boolean isPal (String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    } //isPal
} //Sol
