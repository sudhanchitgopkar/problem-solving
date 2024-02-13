class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        for (string word : words) {
            if (isP(word)) return word;
        } //for
        return "";
    } //firstP

    bool isP (string s) {
        int l = 0, r = s.size() - 1;

        while (l < r) {
            if (s[l++] != s[r--]) return false;
        } //while

        return true;
    } //isP
};