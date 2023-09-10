class Solution {
    public int countOrders(int n) {
        long [] dp = new long [n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int val = 2 * (i - 1) + 1;
            long res =  dp[i - 1] * ((val * ++val)/2);
            dp[i] = (long) (res % (Math.pow(10, 9) + 7));
        } //for

        return (int) (dp[n] % (Math.pow(10, 9) + 7));
    } //countOrders
} //Sol
