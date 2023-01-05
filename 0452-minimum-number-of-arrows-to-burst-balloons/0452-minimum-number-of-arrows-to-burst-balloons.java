class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));

        int sol = 0, end = points[0][1];
        
        for (int [] point : points) {
            if (point[0] <= end) {
                end = end < point[1] ? end : point[1];
            } else {
                end = point[1];
                sol++;
            } //if
        } //for

        return points.length == 0 ? sol : sol + 1;
    } //findMin
} //Sol