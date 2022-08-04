class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] diff = new int [gas.length];
        int totalDiff = 0;
        
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            totalDiff += gas[i] - cost[i];
        } //for
        
        if (totalDiff < 0) {
            return -1;
        } //if
        
        int gasLeft = 0, start = 0;
        
        for (int i = 0; i < diff.length; i++) {
            gasLeft += diff[i];
            if (gasLeft < 0) {
                gasLeft = 0;
                start = i + 1;
            } //if
        } //for
         
        return start;
    } //canComplete
} //Sol