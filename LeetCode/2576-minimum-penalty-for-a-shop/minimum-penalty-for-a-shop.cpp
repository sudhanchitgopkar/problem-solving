class Solution {
public:
    int bestClosingTime(string customers) {
        int n = customers.size(), sol = -1, minPenalty = INT_MAX;
        vector<int> pre (n), suf(n);
        
        pre[0] = customers[0] == 'N' ? 1 : 0;
        suf[n - 1] = customers[n - 1] == 'Y' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + (customers[i] == 'N' ? 1 : 0);
        } //for

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + (customers[i] == 'Y' ? 1 : 0);
        } //for
        
        for (int i = 0; i <= n; i++) {
            int penalty = i == 0 ? suf[i] : i == n ? pre[i - 1] : penalty = pre[i - 1] + suf[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                sol = i;
            } //if
        } //for
        
        return sol;
    } //bestClose
};