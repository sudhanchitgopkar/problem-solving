class Solution {
    String s;
    int n;
    int [][] memo;
    public int longestPalindromeSubseq(String s) {
        this.s = s;
        n = s.length();
        memo = new int[n][n];
        return build(0, n - 1);
    } //longest
    
    public int build (int l, int r) {
        if (l == r) {
            memo[l][r] = 1;
            return 1;
        } else if (r < l) {
            return 0;
        } //if
        
        if (memo[l][r] != 0) return memo[l][r];
        int len = 0;

        if (s.charAt(l) == s.charAt(r)) {
            len = 2 + build(l + 1, r - 1);            
        } else {
            len = Math.max(
                build(l + 1, r), 
                build(l, r - 1));
        } //if
        
        memo[l][r] = len;
        return len;
    } //build
} //Sol