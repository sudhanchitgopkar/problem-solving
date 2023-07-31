class Solution {
public:
    int minimumDeleteSum(string a, string b) {
        int m = a.size(), n = b.size();
        vector<vector<int>> dp (m, vector<int> (n));
        vector<int> sufA (m), sufB (n);

        sufA[m - 1] = int(a[m - 1]);
        sufB[n - 1] = int(b[n - 1]);

        for (int i = m - 2; i >= 0; i--) {
            sufA[i] = int(a[i]) + sufA[i + 1];
        } //for

         for (int i = n - 2; i >= 0; i--) {
            sufB[i] = int(b[i]) + sufB[i + 1];
        } //for

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (a[i] == b[j]) {
                    if (i + 1 >= m || j + 1 >= n) {
                        if (i + 1 >= m && j + 1 >= n) {
                            dp[i][j] = 0;
                        } else if (i + 1 >= m) {
                            dp[i][j] = sufB[j + 1];
                        } else {
                            dp[i][j] = sufA[i + 1];
                        } //if
                    } else {
                        dp[i][j] = dp[i + 1][j + 1]; 
                    } //if
                } else {
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j] = int(a[i]) + int(b[j]);
                    } else {
                        int op1 = int(a[i]) + (i + 1 >= m ? sufB[j] : dp[i + 1][j]);
                        int op2 = int(b[j]) + (j + 1 >= n ? sufA[i] : dp[i][j + 1]);
                        dp[i][j] = min(op1, op2);
                    } //if
                } //if
            } //for
        } //for
        
        return dp[0][0];
    } //minDeleteSum

};