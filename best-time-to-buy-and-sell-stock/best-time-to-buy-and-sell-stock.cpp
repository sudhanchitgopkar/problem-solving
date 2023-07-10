class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size(), minim = INT_MAX, sol = 0;

        for (int i = 0; i < n; i++) {
            minim = min(minim, prices[i]);
            sol = max(sol, prices[i] - minim);
        } //for

        return sol;
    } //maxProfit
};