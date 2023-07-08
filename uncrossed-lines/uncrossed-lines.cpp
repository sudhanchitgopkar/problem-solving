class Solution {
public:
    int maxUncrossedLines(vector<int>& a, vector<int>& b) {
        int alen = a.size(), blen = b.size();
        vector<vector<int>> dp (alen, vector<int> (blen, -1));

        solve(alen - 1, blen - 1, a, b, dp);
        return dp[alen - 1][blen - 1];
    } //maxUncrossed

    int solve (int aptr, int bptr, vector<int>& a, vector<int>& b, vector<vector<int>>& dp) {
        if (aptr < 0 || bptr < 0) {
            return 0;
        } else if (dp[aptr][bptr] != -1) {
            return dp[aptr][bptr];
        } //if

        if (a[aptr] == b[bptr]) {
            dp[aptr][bptr] = 1 + solve(aptr - 1, bptr - 1, a, b, dp);
        } else {
            dp[aptr][bptr] = max(solve(aptr - 1, bptr, a, b, dp), solve(aptr, bptr - 1, a, b, dp));
        } //if

        return dp[aptr][bptr];
    } //solve
};

//intersection if val >= i connects to val <= j