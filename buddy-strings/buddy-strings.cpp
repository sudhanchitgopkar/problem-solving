class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if (s.size() != goal.size()) return false;
        int diff = 0;
        vector<int> locs;

        for (int i = 0; i < s.size(); i++) {
            if (s.at(i) != goal.at(i)) {
                diff++;
                locs.push_back(i);
            } //if
        } //for

        if (diff == 2) {
            return s.at(locs[0]) == goal.at(locs[1]) && s.at(locs[1]) == goal.at(locs[0]);
        } else if (diff == 0) {
            vector<int> freq(26, 0);
            for (int i = 0; i < s.size(); i++) {
                if(++freq[s.at(i) - 'a'] == 2) return true;
            } //for
            return false;
        } else {
            return false;
        } //if
    } //buddyStrings
};