class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp (1001, -1);
        return dfs(nums, dp, target);
    } //comboSum4

    int dfs(vector<int>& nums, vector<int>& dp, int curr) {
        if (curr == 0) return 1;
        if (curr < 0) return 0;
        if (dp[curr] != -1) return dp[curr];

        int res = 0;
        for (int num : nums) {
            res += dfs(nums, dp, curr - num);
        } //for
        dp[curr] = res;
        return dp[curr];
    } //dfs
};