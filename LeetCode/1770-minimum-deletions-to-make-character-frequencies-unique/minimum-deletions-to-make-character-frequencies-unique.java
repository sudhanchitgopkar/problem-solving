class Solution {
    public int minDeletions(String s) {
       int [] freq = new int [26];
       HashSet <Integer> seen = new HashSet <> ();
       int sol = 0;

       for (char c : s.toCharArray()) {
           freq[c - 'a']++;
       } //for

       for (int val : freq) {
           int dist = 0, curr = val;
           while (curr > 0 && seen.contains(curr)) {
               dist++;
               curr--;
           } //while
           sol += dist;
           seen.add(curr);
       } //for

        return sol;
    } //minDeletions
} //Sol