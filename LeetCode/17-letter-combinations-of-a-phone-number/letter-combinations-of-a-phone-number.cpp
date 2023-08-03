class Solution {
public:
    vector<string> sol;
    vector<string> letterCombinations(string digits) {
        if (digits.size() == 0) return {};
        unordered_map<char, vector<char>> um;

        um['2'] = {'a', 'b', 'c'};
        um['3'] = {'d', 'e', 'f'};
        um['4'] = {'g', 'h', 'i'};
        um['5'] = {'j', 'k', 'l'};
        um['6'] = {'m', 'n', 'o'};
        um['7'] = {'p', 'r', 'q', 's'};
        um['8'] = {'t', 'u', 'v'};
        um['9'] = {'w', 'x', 'y', 'z'};

        dfs(0, "", um, digits);
        return sol;
    } //letterCombos

    void dfs(int i, string curr, unordered_map<char, vector<char>>& um, string digits) {
        if (i == digits.size()) {
            sol.push_back(curr);
        } //if

        for (char c : um[digits[i]]) {
            curr.push_back(c);
            dfs(i + 1, curr, um, digits);
            curr.pop_back();
        } //for
    } //dfs
};