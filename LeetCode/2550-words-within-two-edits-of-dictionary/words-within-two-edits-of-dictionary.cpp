class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dict) {
        vector<string> sol;

        for (string query : queries) {
            if (valid(query, dict)) {
                sol.push_back(query);
            } //if
        } //for

        return sol;
    } //twoEdit

    bool valid (string s, vector<string>& dict) {

        for (string d : dict) {
            if (s.size() != d.size()) {
                continue;
            } //if

            int edits = 0;
            for (int i = 0; i < s.size(); i++) {
                if (s[i] != d[i]) {
                    if (++edits > 2) break;
                } //if
            } //for
            if (edits <= 2) {
                return true;
            } //if
        } //for

        return false;
    } //valid
}; 