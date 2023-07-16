class Solution {
public:
    string greatestLetter(string s) {
        vector<bool> hasLower (26), hasUpper (26);

        for (int i = 0; i < s.size(); i++) {
            if (isupper(s.at(i))) {
                hasUpper[s.at(i) - 'A'] = true;
            } else {
                hasLower[s.at(i) - 'a'] = true;
            } //if
        } //for

        for (int i = 25; i >= 0; i--) {
            if (hasUpper[i] && hasLower[i]) {
                return string(1, (char) ('A' + i));
            } //if
        } //for

        return "";
    } //greatestLetter
};