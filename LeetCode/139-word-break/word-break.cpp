class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<int> dp (s.size(), -1);
        return canBreak(0, s, wordDict, dp);
    } //break

    bool canBreak(int i, string s, vector<string>& dict, vector<int>& dp) {
        if (i >= s.size()) {
            return true;
        } else if (dp[i] != -1) {
            return dp[i];
        } //if
        
        for (string word : dict) {
            if (word[0] == s[i] && word.size() <= s.size() - i) {
                bool valid = true;
                //cout << "TRYING: " << word << "\n";
                for (int j = 0; j < word.size(); j++) {
                    if (word[j] != s[i + j]) {
                        valid = false;
                        break;
                    } //if
                } //for
                if (valid) {
                    if (canBreak(i + word.size(), s, dict, dp)) {
                        dp[i] = 1;
                        return true;
                    } //if
                } //if
            } //if
        } //for 

        dp[i] = 0;
        return dp[i];
    } //break
};