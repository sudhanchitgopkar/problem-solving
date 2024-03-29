class Solution {
public:
    int distributeCookies(vector<int>& cookies, int k) {
        vector<int> kids (k, 0);
        return distribute(0, k, cookies, kids);
    } //distributeCookies

    int distribute(int i, int k, vector<int>& cookies, vector<int>& kids) {
        if (i == cookies.size()) {
            int sol = INT_MIN;
            for (int kid : kids) sol = max(kid, sol);
            return sol;
        } //if

        int sol = INT_MAX;
        for (int kid = 0; kid < k; kid++) {
            kids[kid] += cookies[i];
            if (kids[kid] < sol) sol = min(sol, distribute(i + 1, k, cookies, kids));
            kids[kid] -= cookies[i];
            if (kids[kid] == 0) break;
        } //for

        return sol;
    } //int
};