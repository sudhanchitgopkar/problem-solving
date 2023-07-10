class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map <char, int> freq;
        int l = 0, r = 0, n = s.size(), sol = 0;

        while (r < n) {
            freq[s.at(r++)]++;
            while (freq[s.at(r - 1)] > 1) {
                freq[s.at(l++)]--;
            } //while
            sol = max(r - l, sol);
        } //while

        return sol;
    } //lenLongestSubstring
};