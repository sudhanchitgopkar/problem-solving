class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(); 
        int [][] dp = new int [n][n];
        
        if (n == 1) return 1;
        solve (0, n - 1, s, dp);

        return dp[0][n - 1];
    } //longest

    private int solve(int l, int r, String s, int [][] dp) {
        if (l > r) return 0;
        if (l == r) return 1;
        if (dp[l][r] != 0) return dp[l][r];

        if (s.charAt(l) == s.charAt(r)) {
            dp[l][r] = 2 + solve(l + 1, r - 1, s, dp);
        } else {
            dp[l][r] = Math.max(solve(l + 1, r, s, dp), solve(l, r - 1, s, dp));
        } //if

        return dp[l][r];
    } //solve
} //Sol