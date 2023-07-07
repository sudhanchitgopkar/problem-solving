class Solution {
public:
    int maxConsecutiveAnswers(string key, int k) {
        int n = key.size(), l = 0, r = 0, t = 0, f = 0;
        int sol = 0;

        while (r < n) {
            if (key.at(r++) == 'T') t++;
            else f++;

            while (min(t, f) > k) {
                if (key[l++] == 'T') t--;
                else f--;
            } //while

            sol = max(sol, r - l);
        } //while

        return sol;
    } //maxConsec
};