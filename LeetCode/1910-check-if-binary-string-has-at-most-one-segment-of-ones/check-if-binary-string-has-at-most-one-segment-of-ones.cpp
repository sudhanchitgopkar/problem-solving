class Solution {
public:
    bool checkOnesSegment(string s) {
        int curr = 0;

        while (curr < s.size() && s[curr] != '1') {
            ++curr;
        } //while

        while (curr < s.size() && s[curr] == '1') {
            ++curr;
        } //while

        if (curr == s.size()) return true;

        while (curr < s.size()) {
            if (s[curr++] == '1') return false;
        } //while

        return true;
    } //string s
};