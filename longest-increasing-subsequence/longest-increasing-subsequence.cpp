class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size(), sol = 1;
        vector<int> dp (n, 1);

        for (int i = n - 2; i >= 0; i--) {
            int best = dp[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    best = max(best, 1 + dp[j]);
                } //if
            } //for
            dp[i] = best;
        } //for

        for (int val : dp) {
            sol = max(sol, val);
        } //for

        return sol;
    } //LISlen
};