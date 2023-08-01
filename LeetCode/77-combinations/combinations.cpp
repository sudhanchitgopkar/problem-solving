class Solution {
public:
    vector<vector<int>> sol;
    vector<vector<int>> combine(int n, int k) {
        vector<int> curr;
        dfs(curr, 1, n, k);
        return sol;
    } //combine

    void dfs (vector<int>& curr, int i, int n, int k) {
        if (k == 0) {
            sol.push_back(curr);
            return;
        } else if (i > n) {
            return;
        } //if

        curr.push_back(i);
        dfs(curr, i + 1, n, k - 1);
        curr.pop_back();
        dfs(curr, i + 1, n, k);
    } //dfs
};