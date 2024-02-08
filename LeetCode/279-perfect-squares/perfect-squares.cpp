class Solution {
public:
    int numSquares(int n) {
        vector<int> dp (n + 1);

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        } //for

        int num = 2, square = num * num;
        while (square <= n) {
            for (int i = 0; i <= n; i++) {
                if (square <= i) {
                    dp[i] = min(dp[i], 1 + dp[i - square]);
                } //if
            } //for
            square = ++num * num;
        } //while

        return dp[n];
    } //numSquares
};