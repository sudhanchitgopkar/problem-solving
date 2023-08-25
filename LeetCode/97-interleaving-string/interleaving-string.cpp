class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s3.size() != s1.size() + s2.size()) return false;
        vector<vector<int>> dp (s1.size() + 1, vector<int> (s2.size() + 1, -1));
        return can(0, 0, 0, s1, s2, s3, dp);
    } //isInterleave

    bool can (int s1ptr, int s2ptr, int s3ptr, string& s1, string& s2, string& s3, vector<vector<int>> & dp) {
        bool s1cap = s1ptr == s1.size(), 
            s2cap = s2ptr == s2.size(), 
            s3cap = s3ptr == s3.size();

        if (dp[s1ptr][s2ptr] != -1) {
            return dp[s1ptr][s2ptr];
        } else if (s1cap && s2cap && s3cap) {
            return true;
        } else if (s1cap && s2cap) {
            return false;
        } else if (s3cap) {
            return false;
        } else if (s1cap) {
            return s2.substr(s2ptr, s2.size() - s2ptr) == s3.substr(s3ptr, s3.size() - s3ptr);
        } else if (s2cap) {
            return s1.substr(s1ptr, s1.size() - s1ptr) == s3.substr(s3ptr, s3.size() - s3ptr);
        } //if

        if (s1[s1ptr] == s3[s3ptr] && s2[s2ptr] == s3[s3ptr]) {
            dp[s1ptr][s2ptr] = can(s1ptr + 1, s2ptr, s3ptr + 1, s1, s2, s3, dp) || 
                    can(s1ptr, s2ptr + 1, s3ptr + 1, s1, s2, s3, dp);
        } else if (s1[s1ptr] == s3[s3ptr]) {
            dp[s1ptr][s2ptr] = can(s1ptr + 1, s2ptr, s3ptr + 1, s1, s2, s3, dp);
        } else if (s2[s2ptr] == s3[s3ptr]) {
            dp[s1ptr][s2ptr] = can(s1ptr, s2ptr + 1, s3ptr + 1, s1, s2, s3, dp);
        } else {
            dp[s1ptr][s2ptr] = 0;
        } //if

        return dp[s1ptr][s2ptr];
    } //can
};