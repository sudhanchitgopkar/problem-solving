class Solution {
    public int countOrders(int n) {
        long prev = 1;

        for (int i = 2; i <= n; i++) {
            int val = 2 * (i - 1) + 1;
            long res =  prev * ((val * ++val)/2);
            prev = (long) (res % (Math.pow(10, 9) + 7));
        } //for

        return (int) (prev);
    } //countOrders
} //Sol
