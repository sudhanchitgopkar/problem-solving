class Solution {
public:
    unordered_map<int, int> freq;
    vector<int> dp;
    int deleteAndEarn(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        dp.resize(nums.size(), -1);

        for (int num : nums) {
            freq[num]++;
        } //for

        unordered_set<int> invalid;
        return dfs(0, invalid, nums);
    } //delAndEarn

    int dfs(int i, unordered_set<int>& invalid, vector<int>& nums) {
        if (i == nums.size()) {
            return 0;
        } //if

        if (invalid.count(nums[i])) {
            //if we can't take this num, move to the next one
            return dfs(i + freq[nums[i]], invalid, nums);
        } else {
            //if we already know the best thing to do, do it
            if (dp[i] != -1) return dp[i];

            //try not taking this elem
            int without = dfs(i + freq[nums[i]], invalid, nums);
            //and then try taking it
            invalid.insert(nums[i] - 1);
            invalid.insert(nums[i] + 1);
            int with = (nums[i] * freq[nums[i]]) + dfs(i + freq[nums[i]], invalid, nums);
            invalid.erase(nums[i] - 1);
            invalid.erase(nums[i] + 1);

            dp[i] = max(with, without);
            return max(with, without);
        } //if
    } //dfs
};