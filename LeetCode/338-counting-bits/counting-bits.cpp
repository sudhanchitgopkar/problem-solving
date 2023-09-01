class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> sol;
        for (int i = 0; i <= n; i++) {
            sol.push_back(numSetBits(i));
        } //for
        return sol;
    } //countingBits

    int numSetBits(int n) {
        int numSet = 0;
        while (n > 0) {
            numSet += n % 2 == 1;
            n /= 2;
        } //while
        return numSet;
    } //numSetBits
};