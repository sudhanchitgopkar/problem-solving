class Solution {
public:
    vector<string> sol;
    vector<string> letterCasePermutation(string s) {
        dfs(0, s);
        return sol;
    } //letterCasePerm

    void dfs (int i, string s) {
        if (i == s.size()) {
            sol.push_back(s);
            return;
        } //if
        
        dfs(i + 1, s);
        if (islower(s.at(i))) {
            s[i] = toupper(s[i]);
            dfs(i + 1, s);
        } else if (isupper(s.at(i))) {
            s[i] = tolower(s[i]);
            dfs(i + 1, s);
        } //if
    } //dfs
};