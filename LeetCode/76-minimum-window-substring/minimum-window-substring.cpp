class Solution {
public:
    string minWindow(string s, string t) {
        int m = s.size(), n = t.size();
        int l = 0, r = 0, minlen = INT_MAX, numPos = n, minStart = -1;
        vector<int> window (58, 0);
        string sol = "";

        for (int i = 0; i < n; i++) {
            window[t.at(i) - 'A']++;
        } //for

        if (n > m) return sol;

        while (r < m) {
            window[s.at(r) - 'A']--;
            if (window[s.at(r) - 'A'] >= 0) numPos--;
            while (numPos == 0) {
                if (r - l < minlen) {
                    minlen = r - l;
                    minStart = l;
                    //sol = s.substr(l, r - l + 1);
                } //if
                window[s.at(l) - 'A']++;
                if (window[s.at(l) - 'A'] > 0) numPos++;
                l++;
            } //while
            r++;
        } //while

        return minlen == INT_MAX ? "" : s.substr(minStart, ++minlen);
    } //minWindow
};