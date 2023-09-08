class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> sol {{1}};
        for (int i = 1; i < numRows; i++) {
            sol.push_back(gen(sol[i - 1]));
        } //for
        return sol;
    } //gen

    vector<int> gen(vector<int>& prev) {
        vector<int> curr (1,1);
        for (int i = 0; i < prev.size() - 1; i++) {
            curr.push_back(prev[i] + prev[i + 1]);
        } //for
        curr.push_back(1);
        return curr;
    } //gen
};