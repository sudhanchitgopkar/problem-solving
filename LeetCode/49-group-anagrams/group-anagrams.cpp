class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map <string, vector<string>> um;
        vector<vector<string>> sol;

        for (auto & s : strs) {
            string sorted = s;
            sort(sorted.begin(), sorted.end());
            if (um.find(sorted) == um.end()) um.insert({sorted, vector<string> ()});
            um.at(sorted).push_back(s);
        } //for

        for (auto & entry : um) {
            sol.push_back(entry.second);
        } //for

        return sol;
    } //groupAna
};