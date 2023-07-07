class Solution {
public:
    int longestSubsequence(vector<int>& arr, int diff) {
        int n = arr.size(), sol = 1;
        unordered_map<int, int> dp;

        for (int i = n - 1; i >= 0; i--) {
            dp[arr[i] - diff] = max(dp[arr[i] - diff], dp[arr[i]] + 1);
        } //for

        for (auto & entry : dp) {
            sol = max(sol, entry.second);
        } //for

        return sol;
    } //longestSubseq
};