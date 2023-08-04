class Solution {
public:
    unordered_set<string> dict;
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<int> dp (s.size(), -1);

        for (string s : wordDict) {
            dict.insert(s);
        } //for

        return canBreak(0, s, dict, dp);
    } //break

    bool canBreak(int i, string s, unordered_set<string>& dict, vector<int>& dp) {
        if (i >= s.size()) {
            return true;
        } else if (dp[i] != -1) {
            return dp[i];
        } //if

        int j = i;
        while (j < s.size()) {
            if (dict.count(s.substr(i, j - i + 1))) {
                if (canBreak(j + 1, s, dict, dp)) {
                    return true;
                } //if
            } //if
            j++;
        } //while

        dp[i] = 0;
        return dp[i];
    } //break
};