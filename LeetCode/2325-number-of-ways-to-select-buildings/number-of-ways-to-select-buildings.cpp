class Solution {
public:
    long long numberOfWays(string s) {
        vector<long long> freq (6, 0);
        //0, 01, 010, 1, 10, 101
        for (char c : s) {
            if (c == '0') {
                freq[0]++;
                freq[2] += freq[1];
                freq[4] += freq[3];
            } else {
                freq[3]++;
                freq[1] += freq[0];
                freq[5] += freq[4];
            } //if
        } //for


        return freq[2] + freq[5];
    } //numWays
};
