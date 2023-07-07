class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp (n, {1,1});
        int lis = 0, sol = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    if (1 + dp[j][0] > dp[i][0]) {
                        dp[i][0] = 1 + dp[j][0];
                        dp[i][1] = dp[j][1];
                    } else if (1 + dp[j][0] == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    } //if
                } //if
            } //for
        } //for

        for (int i = 0; i < n; i++) {
            if (dp[i][0] > lis) {
                lis = dp[i][0];
                sol = dp[i][1];
            } else if (dp[i][0] == lis) {
                sol += dp[i][1];
            } //if
        } //for

        return sol;
    } //numLIS
};