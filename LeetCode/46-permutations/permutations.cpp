class Solution {
public:
    vector<vector<int>> sol;
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> curr;
        unordered_set<int> used;
        dfs(curr, nums, used);
        return sol;
    } //permute

    void dfs(vector<int>& curr, vector<int>& nums, unordered_set<int>& used) {
        if (curr.size() == nums.size()) {
            sol.push_back(curr);
        } //if

        for (int num : nums) {
            if (used.count(num)) continue;
            used.insert(num);
            curr.push_back(num);
            dfs(curr, nums, used);
            used.erase(num);
            curr.pop_back();
        } //for
    } //dfs
};