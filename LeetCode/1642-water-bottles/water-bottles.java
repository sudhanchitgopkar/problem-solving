class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sol = 0, rem = 0;

        while (numBottles > 0) {
            sol += numBottles;
            int temp = (numBottles + rem) % numExchange;
            numBottles = (numBottles + rem)/numExchange;
            rem = temp;
        } //while

        return sol;
    } //numWaterBottles
} //Sol


/*
    sol: 00 15 18
    num: 15 03 01
    rem: 00 03 02
*/