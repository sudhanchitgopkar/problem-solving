class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> sol;
        sol.push_back(0);
        for (int i = 1; i <= n; i++)
            sol.push_back(sol[i/2] + i % 2);
        return sol;
    } //countingBits
};