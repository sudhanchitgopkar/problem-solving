class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size(), missing = -1, twice = -1;
        vector<bool> seen (n + 1);

        for (int num : nums) {
            if (seen[num]) twice = num;
            else seen[num] = true;
        } //for

        for (int i = 1; i <= n; i++) {
            if (!seen[i]) missing = i;
        } //for

        return {twice, missing};
    } //findErrorNums
};