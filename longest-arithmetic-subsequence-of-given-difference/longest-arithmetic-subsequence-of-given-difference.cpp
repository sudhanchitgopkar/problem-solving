class Solution {
public:
    int longestSubsequence(vector<int>& arr, int diff) {
        unordered_map <int, int> subseqs;
        int sol = 1;

        for (int val : arr) {
            if (subseqs.count(val) > 0) {
                subseqs[val + diff] = subseqs[val] + 1;
                sol = max(sol, subseqs[val + diff]);
            } else {
                subseqs[val + diff] = 1;
            } //if
        } //for

        return sol;
    } //longestSubseq
};