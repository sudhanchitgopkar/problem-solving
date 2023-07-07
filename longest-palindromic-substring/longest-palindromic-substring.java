class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = -1;
        int [][] dp = new int [n][n];
        String sol = "";

        if (n == 1) return s;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            } //for
        } //for

        solve(0, n - 1, s, dp);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1 && Math.abs(j - i) > maxLen) {
                    maxLen = Math.abs(j - i);
                    sol = s.substring(i, j + 1);
                } //if
            } //for
        } //for

        return sol;
    } //longestPalindrome

    private int solve(int l, int r, String s, int [][] dp) {
        if (l == r) {
            dp[l][r] = 1;
            return dp[l][r];
        } else if (l > r) {
            dp[l][r] = 0;
            return dp[l][r];
        } else if (dp[l][r] != -1) {
            return dp[l][r];
        } //if

        if (s.charAt(l) == s.charAt(r)) {
            if (l == r - 1) dp[l][r] = 1;
            else dp[l][r] = solve(l + 1, r - 1, s, dp);
        } else {
            dp[l][r] = 0;
        } //if

        solve(l + 1, r, s, dp);
        solve(l, r - 1, s, dp);

        return dp[l][r];
    } //solve
} //Sol

