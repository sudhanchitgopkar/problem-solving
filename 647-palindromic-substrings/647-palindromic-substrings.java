class Solution {
    int sol = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++)
            dfs(s,s.substring(i,i+1),i);
        return sol;
    }
    
    private void dfs (String s, String ss, int i) {
        if (check(ss)) sol++;
        if (i == s.length()-1) return;
        dfs(s,ss+s.charAt(i+1),i+1);
    } //dfs
    
    private boolean check (String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    } //isPalindrome
}