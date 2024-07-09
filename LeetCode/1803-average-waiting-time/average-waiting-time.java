class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int [] finishTimes = new int [n];
        double waitTimeSum = 0;

        finishTimes[0] = customers[0][0] + customers[0][1];
        waitTimeSum += finishTimes[0] - customers[0][0];
        for (int i = 1; i < n; i++) {
            finishTimes[i] = (finishTimes[i - 1] >= customers[i][0]) ?
            finishTimes[i - 1] + customers[i][1] : customers[i][0] + customers[i][1];
             waitTimeSum += finishTimes[i] - customers[i][0];
        } //for


        return waitTimeSum/n;
    } //avgWaitingTime
} //Sol