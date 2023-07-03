class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        vector<int> w2freq(26, 0);
        vector<string> sol;

        for (string word : words2) {
            vector<int> wfreq (26, 0);
            for (char c : word) {
                wfreq[c - 'a']++;
            } //for

            for (int i = 0; i < 26; i++) {
                w2freq[i] = max(w2freq[i], wfreq[i]);
            } //for
        } //for

        for (string word : words1) {
            vector<int> wfreq (26, 0);
            bool universal = true;

            for (char c : word) {
                wfreq[c - 'a']++;
            } //for

            for (int i = 0; i < 26; i++) {
                if (w2freq[i] > wfreq[i]) {
                    universal = false;
                    break;
                } //if
            } //for

            if (universal) sol.push_back(word);
        } //for

        return sol;
    } //wordSubsets
};