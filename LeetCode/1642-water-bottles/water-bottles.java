class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        return solve(numBottles, 0, numExchange);
    } //numWaterBottles

    private int solve (int full, int empty, int exchange) {
        if (full == 0 && empty < exchange) return 0;
        if (full == 0) return solve(empty/exchange, empty % exchange, exchange);
        return full + solve(0, full + empty, exchange);
    } //solve
} //Sol
