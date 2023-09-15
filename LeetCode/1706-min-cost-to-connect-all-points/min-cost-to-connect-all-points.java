class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, sol = 0;
        List<int []> [] edges = new ArrayList [n];
        boolean [] used = new boolean [n];
        PriorityQueue <int []> pq = new PriorityQueue <> ((int [] a, int [] b) -> (Integer.compare(a[2], b[2])));

        for (int i = 0; i < points.length; i++) {
            edges[i] = new ArrayList<int []> ();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int [] edge = {i, j, cost(points[i], points[j])};
                    edges[i].add(edge);
                } //if
            } //for
        } //for


        used[0] = true;
        for (int [] edge : edges[0]) {
            pq.offer(edge);
        } //for

        while (!pq.isEmpty()) {
            int [] curr = pq.poll();
            if (used[curr[1]]) {
                continue;
            } //if

            sol += curr[2];
            used[curr[1]] = true;
            for (int [] edge : edges[curr[1]]) {
                pq.offer(edge);
            } //for
        } //while
        
        return sol;
    } //minCostConnect

    private int cost (int [] a, int [] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    } //cost
} //Sol