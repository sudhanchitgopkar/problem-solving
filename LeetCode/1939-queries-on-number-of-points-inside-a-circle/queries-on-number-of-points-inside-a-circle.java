class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int [] sol = new int [queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int [] point : points) {
                if (in(point, queries[i])) {
                    sol[i]++;
                } //if
            } //for
        } //for

        return sol;
    } //countPoints

    private boolean in(int [] point, int [] circle) {
        //if dist between point & circle <= circle radius
        double dist = Math.sqrt(Math.pow(point[1] - circle[1], 2) +
                                Math.pow(point[0] - circle[0], 2));
        return dist <= circle[2];
    } //in
} //Sol