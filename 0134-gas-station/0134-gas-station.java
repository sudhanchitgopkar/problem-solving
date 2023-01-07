class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, diffSum = 0;

        for (int i = 0; i < n; i++) diffSum += gas[i] - cost[i];

        if (diffSum < 0) return -1;

        int sol = 0, tank = gas[0];
        for (int i = 1; i < n; i++) {
            tank -= cost[i-1];
            if (tank < 0) {
                tank = gas[i];
                sol = i;
            } else {
                tank += gas[i];
            } //if
        } //for
        
        return sol;
    } //canComplete
} //Sol