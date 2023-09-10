class Solution {
    public int countOrders(int n) {
        double [] dp = new double [n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            double res = (dp[i - 1] * (sum(2 * (i - 1) + 1)));
            dp[i] = res % (Math.pow(10, 9) + 7);
        } //for

        return (int) (dp[n] % (Math.pow(10, 9) + 7));
    } //countOrders

    public int sum(int val) {
        int sum = 0;

        for (int i = 1; i <= val; i++) {
            sum += i;
        } //for

        return sum;
    } //sum
} //Sol
