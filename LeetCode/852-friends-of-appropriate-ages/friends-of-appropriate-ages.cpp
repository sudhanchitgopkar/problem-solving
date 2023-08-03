class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        vector<int> freq (121);
        int sol = 0, n = ages.size();

        for (int age : ages) {
            freq[age]++;
        } //for

        for (int i = 0; i < 121; i++) {
            if (freq[i] == 0) continue;
            for(int j = 0; j <= i; j++) {
                if (freq[j] == 0) continue;
                if (can(i, j)) {
                    sol += freq[i] * (freq[j] - (i == j ? 1 : 0));
                } //for
            } //for
        } //for

        return sol;
    } //numFriendRequests

    bool can(int x, int y) {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        return true;
    } //can
};