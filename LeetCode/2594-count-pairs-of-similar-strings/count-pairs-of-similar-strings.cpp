class Solution {
public:
    int similarPairs(vector<string>& words) {
        int sol = 0, n = words.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (similar(words[i], words[j])) ++sol;
            } //for
        } //for

        return sol;
    } //similarPairs

    bool similar(string& a, string& b) {
        vector<bool> afreq (26);
        vector<bool> bfreq (26);

        for (char c : a) {
            afreq[c - 'a'] = true;
        } //for

        for (char c : b) {
            bfreq[c - 'a'] = true;
        } //for

        for (int i = 0; i < 26; i++) {
            if (bfreq != afreq) return false;
        } //for

        return true;
    } //similar
};