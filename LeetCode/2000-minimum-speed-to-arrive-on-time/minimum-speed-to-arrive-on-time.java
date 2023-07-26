class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int min = 0, max = (int) Math.pow(10, 7), sol = -1;
        
        while (min <= max) {
            int mid = (min + max)/2;
            if (check(dist, hour, mid)) {
                sol = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            } //if
        } //while
        
        return sol;
    } //minSeped

    boolean check (int [] dists, double deadline, int speed) {
        double currTime = 0.0;

        for (int i = 0; i < dists.length; i++) {
            currTime += ((dists[i] * 1.0)/speed);
            if (i != dists.length - 1) currTime = Math.ceil(currTime);
        } //for

        return currTime <= deadline;
    } //can
}
