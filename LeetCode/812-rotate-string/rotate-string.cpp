class Solution {
public:
    bool rotateString(string s, string goal) {
        if (s.size() != goal.size()) return false;

        int n = s.size();
        for (int i = 0; i < n; i++) {
            s = s.substr(1) + s[0];
            if (s == goal) return true;
        } //for

        return false;
    } //rotate
};