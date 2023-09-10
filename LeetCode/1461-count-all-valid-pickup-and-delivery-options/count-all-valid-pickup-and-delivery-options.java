class Solution {
    public int countOrders(int n) {
        long [] dp = new long [n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long res = (long) ((dp[i - 1] * (sum(2 * (i - 1) + 1))) % (Math.pow(10, 9) + 7));
            dp[i] = res;
        } //for

        return (int) (dp[n] % (Math.pow(10, 9) + 7));
    } //countOrders

    public int sum(int val) {
        return (val * ++val)/2;
    } //sum
} //Sol
