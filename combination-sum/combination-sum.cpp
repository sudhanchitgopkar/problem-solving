class Solution {
public:
    set<vector<int>> combns;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> curr;
        vector<vector<int>> sol;

        dfs(0, target, curr, candidates);
        for (auto & combo : combns) sol.push_back(combo);

        return sol;
    } //comboSum

    void dfs(int i, int target, vector<int>& curr, vector <int>& candidates) {
        if (target == 0) {
            combns.insert(curr);
            return;
        } else if (i == candidates.size() || target < 0) {
            return;
        } //if
        
        curr.push_back(candidates[i]);
        dfs(i, target - candidates[i], curr, candidates);
        dfs(i + 1, target - candidates[i], curr, candidates);
        curr.pop_back();
        dfs(i + 1, target, curr, candidates);
    } //dfs
};