class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        int n = pairs.size(), sol = 1;
        vector<int> dp (n, 1);
        sort(pairs.begin(), pairs.end(), [] 
        (const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (pairs[i][1] < pairs[j][0]) {
                    dp[i] = max(dp[i], 1 + dp[j]);
                }//if
            } //for
            sol = max(sol, dp[i]);
        } //for

        return sol;
    } //findLongest
};