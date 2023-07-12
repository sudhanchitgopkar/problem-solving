class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> sol;

        for (int i = 0; i < n/2; i++) {
            sol.push_back(i + 1);
            sol.push_back(-1 * (i + 1));
        } //for

        if (n % 2 != 0) {
            sol.push_back(0);
        } //if

        return sol;
    } //sumZero
};