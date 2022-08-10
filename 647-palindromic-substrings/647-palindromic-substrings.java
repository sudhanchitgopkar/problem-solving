class Solution {
    int sol = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s,i,i);
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                expand(s,i,i+1);
            } //if
        } //for
        
        return sol;
    }
    
    private void expand (String s, int l, int r) {
        if (s.charAt(l) == s.charAt(r)) sol++;
        else return;
        if (--l < 0 || ++r >= s.length()) return;
        expand(s,l,r);
    } //dfs
    
}