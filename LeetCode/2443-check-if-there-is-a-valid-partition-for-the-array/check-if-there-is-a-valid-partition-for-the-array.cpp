class Solution {
public:
    bool validPartition(vector<int>& nums) {
        int n = nums.size(); 
        vector<int> dp (n, -1);
        return dfs(0, dp, nums);
    } //valid

    bool dfs(int start, vector<int>& dp, vector<int>& nums) {
        if (start == nums.size()) {
            return true;
        } else if (start == nums.size() - 1) {
            return false;
        } else if (dp[start] != -1) {
            return dp[start];
        } //if
        
        bool pair = false, trip = false, seq = false;
        if (nums[start] == nums[start + 1]) {
            pair = dfs(start + 2, dp, nums);
        } //if

        if (start + 2 < nums.size() && 
            nums[start] == nums[start + 1] && nums[start] == nums[start + 2]) {
            trip = dfs(start + 3, dp, nums);
        } //if

        if (start + 2 < nums.size() && 
            nums[start] == nums[start + 1] - 1 && nums[start] == nums[start + 2] - 2) {
            seq = dfs(start + 3, dp, nums);
        } //if

        dp[start] = pair || trip || seq;
        return dp[start];
    } //dfs
};