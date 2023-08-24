class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int sol = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 1; i++) {
            sol = max(sol, nums[i + 1] - nums[i]);
        } //for
        return sol;
    } //maxGap
};