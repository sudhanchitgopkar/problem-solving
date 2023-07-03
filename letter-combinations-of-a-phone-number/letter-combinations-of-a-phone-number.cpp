class Solution {
public:
    vector<string> sol;
    unordered_map <char, vector<char>> num2l;
    vector<string> letterCombinations(string digits) {
        init();
        dfs(0, "", digits);
        return sol;
    } //combos

    void dfs(int i, string curr, string digits) {
        if (i == digits.size()) {
            if (curr.size() > 0) sol.push_back(curr);
            return;
        } //if

        for (auto letter : num2l[digits.at(i)]) {
            curr += letter;
            dfs(i + 1, curr, digits);
            curr.erase(curr.size() - 1);
        } //for
    } //dfs

    void init () {
        num2l['2'] = {'a', 'b', 'c'};
        num2l['3'] = {'d', 'e', 'f'};
        num2l['4'] = {'g', 'h', 'i'};
        num2l['5'] = {'j', 'k', 'l'};
        num2l['6'] = {'m', 'n', 'o'};
        num2l['7'] = {'p', 'q', 'r', 's'};
        num2l['8'] = {'t', 'u', 'v'};
        num2l['9'] = {'w', 'x', 'y', 'z'};
    } //init
};